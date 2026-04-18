## 1. Remove Non-Functional UI Elements

- [x] 1.1 Remove the "Mock mode enabled" badge (`mock-badge` div and `isMockMode` logic) from `App.js`
- [x] 1.2 Remove the "Log in with Google" button, the "or" divider, and associated Google icon import from `Login.js`
- [x] 1.3 Remove the "Don't have an account? Sign up" link from `Login.js`
- [x] 1.4 Remove the `.mock-badge` CSS rule from `App.css`

## 2. Create the AppShell Layout Component

- [x] 2.1 Create `src/layout/AppShell.js` that renders `<Header />`, `<Sidebar />`, `<Outlet />` (from React Router), and `<Footer />`
- [x] 2.2 In AppShell, wrap the content outlet in a `<Box>` with `margin-left: var(--shell-sidebar-width)` and `margin-top: var(--shell-header-height)` and `padding: 24px`
- [x] 2.3 In AppShell, use `useEffect` to set `--shell-header-height: 76px` on `document.documentElement`

## 3. Refactor App.js to Use Nested Routes

- [x] 3.1 Import `AppShell` and restructure `App.js` routes so that all authenticated routes are children of an `<Route element={<AppShell />}>` wrapper
- [x] 3.2 Keep the `/login` and `/*` (catch-all to Login) routes outside the AppShell wrapper
- [x] 3.3 Remove the standalone `<Footer />` render from `App.js` (now inside AppShell)

## 4. Fix Header — Fixed Positioning and Logo Size

- [x] 4.1 Change `Header.js` AppBar from `position="sticky"` to `position="fixed"`
- [x] 4.2 Increase the logo container from `{ xs: 40, sm: 48 }` to `{ xs: 48, sm: 64 }` (width and height)
- [x] 4.3 Remove the sidebar collapse/expand `IconButton` from `Header.js` (keep only the mobile hamburger `MenuIcon` button)

## 5. Move Sidebar Toggle into Sidebar

- [x] 5.1 In `Sidebar.js`, add a collapse/expand `IconButton` (ChevronLeft/ChevronRight) next to the "Navigation" label at the top of the drawer content
- [x] 5.2 Import `useAppLayout` and wire the button to `toggleSidebarCollapsed`
- [x] 5.3 Verify the toggle works and the sidebar animates between 260 px and 88 px widths

## 6. Remove Per-Page Header/Sidebar Imports

- [x] 6.1 Remove `<Header />` and `<Sidebar />` imports and JSX from `UserManagement.js`
- [x] 6.2 Remove `<Header />` and `<Sidebar />` imports and JSX from `Admin_c.js` (Report page)
- [x] 6.3 Remove `<Header />` and `<Sidebar />` imports and JSX from `Admin.js`
- [x] 6.4 Remove `<Header />` and `<Sidebar />` imports and JSX from `Admin1.js`
- [x] 6.5 Remove `<Header />` and `<Sidebar />` imports and JSX from `Admin2.js`
- [x] 6.6 Remove `<Header />` and `<Sidebar />` imports and JSX from `Checker.js`
- [x] 6.7 Remove `<Header />` and `<Sidebar />` imports and JSX from `Checker1.js`
- [x] 6.8 Remove `<Header />` and `<Sidebar />` imports and JSX from `LoanData.js`
- [x] 6.9 Remove `<Header />` and `<Sidebar />` imports and JSX from `DepositData.js`
- [x] 6.10 Remove `<Header />` and `<Sidebar />` imports and JSX from `RiskAssessment.js`
- [x] 6.11 Remove `<Header />` and `<Sidebar />` imports and JSX from `Maker.js`
- [x] 6.12 Remove `<Header />` and `<Sidebar />` imports and JSX from `DataTable.js`
- [x] 6.13 Remove `<Header />` and `<Sidebar />` imports and JSX from `DataTable1.js`
- [x] 6.14 Remove `<Header />` and `<Sidebar />` imports and JSX from `Verified.js`

## 7. Clean Up ModernLayout.css and Per-Page CSS

- [x] 7.1 Remove all `.adminDash`, `.table-containerr`, `.loan-data-content`, `.green-deposit-content`, `.step-wrapper`, `.container1` margin-left/margin-right `!important` rules from `ModernLayout.css` — the AppShell content wrapper handles offset now
- [x] 7.2 Update `Footer.js` to remove the `ml: 'var(--shell-sidebar-width)'` since it is now inside the AppShell content area
- [x] 7.3 Verify responsive `@media` rules still work for mobile (< 960 px) with full-width content

## 8. Global UI Polish — Typography and Spacing

- [x] 8.1 In `AppThemeProvider.js`, set MUI theme overrides: body font-size 14 px, table cell font-size 13 px, card border-radius 8 px
- [x] 8.2 Add a global PrimeReact DataTable override in `ModernLayout.css` or a new `GlobalStyles.css`: `.p-datatable { width: 100% !important; }` and `.p-card { border-radius: 8px; padding: 16px; }`
- [x] 8.3 Ensure the `Sidebar.js` drawer `top` uses `var(--shell-header-height, 76px)` and `height: calc(100% - var(--shell-header-height, 76px))` for proper alignment with the fixed header

## 9. Delete Commented-Out Legacy Code

- [ ] 9.1 Remove the large commented-out old Sidebar class component from the bottom of `Sidebar.js`
- [ ] 9.2 Remove the large commented-out old UserManagement component from the top of `UserManagement.js`
- [ ] 9.3 Remove any other dead/commented code blocks longer than 5 lines across all page components

## 10. Verification and Testing

- [ ] 10.1 Run `npm run build` to verify the project compiles without errors
- [ ] 10.2 Visually verify all routes work: `/login`, `/admin`, `/UserManagement`, `/report`, `/LoanData`, `/depositData`, `/RiskAssessment`, `/Maker`, `/Checker`
- [ ] 10.3 Verify sidebar collapse/expand toggle works from inside the sidebar on desktop
- [ ] 10.4 Verify the header stays fixed on scroll across all pages
- [ ] 10.5 Verify content does not overlap or slide under the sidebar on any page
