## Context

The BOB Green Finance Portal is a React SPA using Material UI (MUI) and PrimeReact. Currently, every authenticated page (Admin, Checker, UserManagement, Report, LoanData, DepositData, etc.) independently imports and renders `<Header />` and `<Sidebar />`. There is no shared layout shell. The main content area is pushed via CSS variables (`--shell-sidebar-width`) set imperatively from `Sidebar.js`, and each page's root element uses `margin-left` via `ModernLayout.css` selectors. This brittle approach causes:

- The header scrolling away or overlapping content on some pages.
- The main content sliding under the sidebar on User Management and Report pages.
- The sidebar collapse toggle living in the header instead of the sidebar.
- Inconsistent font sizes, spacing, and card styles across pages.
- Non-functional UI elements (Google login, sign-up, mock badge) polluting the interface.

The application uses React Router v6 with a basename of `/greenfinance`. MUI `AppBar` with `position="sticky"` and a permanent MUI `Drawer` form the current header/sidebar pair.

## Goals / Non-Goals

**Goals:**
- Create a single `AppShell` wrapper component that renders `Header`, `Sidebar`, and a content outlet for all authenticated routes — removing per-page imports.
- Make the header truly fixed (`position: fixed`) with proper z-indexing so it never scrolls off-screen.
- Relocate the sidebar collapse/expand toggle into the sidebar (at the top, below the "Navigation" label).
- Enlarge the header logo from 48 px to 64 px.
- Ensure the content area is always offset correctly (via `margin-left` and `margin-top`) regardless of sidebar collapsed/expanded state, with smooth CSS transitions.
- Remove: Google login button + divider, sign-up link, and the global mock-mode badge.
- Normalize font sizes (body 14 px, table cells 13 px, headings via MUI `Typography` variants) and standardise card/table padding across all pages.
- Delete large commented-out legacy code blocks (old Sidebar, old UserManagement).

**Non-Goals:**
- No changes to backend APIs or data models.
- No new feature functionality (no new pages, no new business logic).
- No migration to a different component library.
- No introduction of server-side rendering or code splitting.
- No changes to the PrimeReact DataTable styling engine beyond consistent wrapper sizing.

## Decisions

### 1. Shared AppShell layout via React Router nested routes

**Decision:** Introduce an `AppShell` component that renders `<Header />`, `<Sidebar />`, and `<Outlet />`, and wrap all authenticated routes inside it as nested routes in `App.js`.

**Rationale:** This is the idiomatic React Router v6 pattern. It guarantees a single render of header/sidebar, eliminates per-page imports, and gives a single place to control content offset.

**Alternative considered:** Keep per-page imports but fix CSS — rejected because it leaves duplication and makes future layout changes fragile.

### 2. Fixed header with CSS `position: fixed`

**Decision:** Change `AppBar` from `position="sticky"` to `position="fixed"` and add `margin-top: <header-height>` to the content area.

**Rationale:** `sticky` only works within the scroll container it belongs to. With the new shell layout, `fixed` ensures the header never leaves the viewport regardless of scroll depth. We store header height (76 px) as a CSS variable `--shell-header-height`.

### 3. Sidebar collapse toggle inside the sidebar

**Decision:** Remove the collapse `IconButton` from `Header.js` and place it at the top of the `Sidebar.js` drawer content, right-aligned next to the "Navigation" label. On mobile, the hamburger menu button stays in the header (since the sidebar is a temporary overlay).

**Rationale:** The collapse toggle semantically belongs to the sidebar — it controls sidebar width. Keeping it in the header wastes horizontal space and confuses users.

### 4. CSS variable-driven layout offsets

**Decision:** Continue using CSS custom properties (`--shell-sidebar-width`, `--shell-header-height`) but set them from the `AppShell` component via `useEffect`, and apply them only in the shell's own styles — not in `ModernLayout.css` selector soup. Remove all per-class `margin-left !important` rules from `ModernLayout.css`.

**Rationale:** A single wrapper div with `margin-left: var(--shell-sidebar-width)` and `margin-top: var(--shell-header-height)` is cleaner than dozens of class selectors.

### 5. Login page cleanup — remove non-functional elements

**Decision:** Delete the Google login `<Button>`, the surrounding `<Divider>`, and the "Sign up" `<Typography>` block entirely from `Login.js`. Remove the mock-badge `<div>` from `App.js`.

**Rationale:** These are placeholder elements with no backend integration. They mislead users and add visual clutter.

### 6. Typography and spacing normalisation

**Decision:** Define consistent spacing tokens in the `AppShell` content wrapper (padding: 24 px, gap: 16 px) and standardise `Typography` variants across pages. Use MUI theme overrides where possible.

**Rationale:** Avoids per-page CSS divergence. A single set of spacing values keeps the UI predictable.

## Risks / Trade-offs

- **[Risk] Nested-route refactor may temporarily break direct URL navigation** → Mitigation: Keep all existing route paths unchanged; only restructure the component tree. Test all routes after the change.
- **[Risk] PrimeReact DataTable width may still behave unexpectedly after removing `margin-left !important` rules** → Mitigation: Wrap all DataTable pages in a `Box` with `width: 100%` from the shell content area; test each page visually.
- **[Risk] Old commented-out code deletion could remove useful reference code** → Mitigation: Code is in git history; the old code provides no runtime value and harms readability.
- **[Trade-off] Fixed header consumes 76 px of vertical space permanently** → Acceptable for a data-heavy portal where navigation access is more important than screen real estate.
