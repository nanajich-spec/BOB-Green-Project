## Why

The Green Finance Portal frontend has critical layout and UI consistency issues that prevent production readiness. The header overlaps or detaches from content on several pages, the main content area slides under the sidebar on pages like User Management and Report, the sidebar collapse toggle is misplaced in the header instead of inside the sidebar, the logo is too small, and non-functional elements (Google login, sign-up link, mock-mode badge) clutter the interface and confuse users. Font sizes, spacing, and page structure vary across pages because each page independently renders `<Header />` and `<Sidebar />` instead of using a shared shell layout. These issues must be resolved before the application can be deployed to production.

## What Changes

- **Introduce a shared `AppShell` layout** that wraps all authenticated pages with a fixed header, sidebar, and scrollable content area — eliminating per-page `<Header />` / `<Sidebar />` imports.
- **Fix header to viewport top** (`position: fixed`) so it never scrolls away or overlaps content.
- **Move the sidebar collapse/expand toggle** from the header into the sidebar itself (top or bottom), freeing header space.
- **Increase logo size** in the header for better brand visibility.
- **Fix main content area positioning** so it never overlaps or slides under the sidebar — use CSS-variable-driven margin/padding tied to actual sidebar width.
- **Remove "Login with Google" button** and the "or" divider from the Login page.
- **Remove "Sign up" link** from the Login page (no self-registration).
- **Remove the "Mock mode enabled" badge** from all pages (the `mock-badge` element in `App.js`).
- **Standardize typography and spacing** across all pages — consistent font sizes, paddings, and card styling for a clean, production-ready look.
- **Clean up dead/commented-out code** in component files (e.g., large blocks of old Sidebar and UserManagement code).

## Capabilities

### New Capabilities
- `app-shell-layout`: A shared layout shell component (`AppShell`) that provides fixed header, collapsible sidebar with built-in toggle, and a properly offset scrollable content area — used by all authenticated routes.
- `login-cleanup`: Streamline the Login page by removing Google OAuth button, sign-up link, and any mock-mode references, keeping only the domain-ID/password form and role selection.
- `global-ui-polish`: Standardize font sizes, spacing, table widths, card styles, and responsive breakpoints across every page for a consistent production-grade appearance.

### Modified Capabilities
<!-- No existing specs to modify -->

## Impact

- **Frontend components affected**: `App.js`, `Header.js`, `Sidebar.js`, `Footer.js`, `Login.js`, `UserManagement.js`, `Admin_c.js`, `Admin.js`, `Checker.js`, `Checker1.js`, `LoanData.js`, `DepositData.js`, `RiskAssessment.js`, `Maker.js`, `DataTable.js`, `DataTable1.js`, `Verified.js`, `ModernLayout.css`, `App.css`, and all per-page CSS files.
- **Layout context**: `AppLayoutContext.js` will be extended to support the new shell pattern.
- **No backend/API changes** required.
- **No new dependencies** — leverages existing MUI and PrimeReact libraries.
- **Risk**: Low — purely presentational changes; no data or API contract modifications.
