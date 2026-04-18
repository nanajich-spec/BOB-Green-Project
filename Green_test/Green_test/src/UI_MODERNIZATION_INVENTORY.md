# UI Modernization Inventory

## Priority 1 (high traffic / role core)
- `Admin.js`, `Admin1.js`, `Admin2.js`, `Admin_c.js`
- `Maker.js`
- `Checker.js`, `Checker1.js`, `Verified.js`

## Priority 2 (operational dashboards and data pages)
- `LoanData.js`
- `DepositData.js`
- `DataTable.js`
- `DataTable1.js`
- `ExistingRecordsPage.js`

## Priority 3 (supporting workflows)
- `RiskAssessment.js`
- `ProjectSpecificIndicator.js`
- `UserManagement.js`
- `PDFDocument.js` viewer/download surfaces

## Shared Shell / Cross-Cutting Components
- `Header.js` (logo, profile, theme toggle, navigation controls)
- `Sidebar.js` (role menu, collapsible desktop + mobile drawer)
- `Footer.js`
- `theme/AppThemeProvider.js`
- `layout/AppLayoutContext.js`
- `ModernLayout.css`

## CSS Migration Inventory (April 2026)

### Consolidated into shared style layers
- `styles/DesignTokens.css`: semantic surface/text/border/accent variables and dark-mode token overrides.
- `styles/LayoutShell.css`: fixed shell geometry (header/footer/main scroll), page containers, and table card shells.
- `styles/GenericTable.css`: shared PrimeReact table typography, spacing, hover, pagination, and responsive width behavior.

### Legacy page CSS retired from active route usage
- `Admin.css` (replaced by shared table/layout layers)
- `Checker.css` (replaced by shared table/layout layers)
- `DataTable.css` removed from active route components (`DataTable.js`, `DataTable1.js`)

### Remaining high-priority migration targets
- `Maker.css`, `Admin1.css`, and any role-specific table overrides should progressively shift to shared style primitives.
- Legacy files not referenced in routes (e.g., recovery/debug variants) remain out of active modernization scope.

## Target Frontend Structure Map

- `layout/` — shell and layout state (`AppShell`, layout context)
- `theme/` — MUI theme provider + mode switching
- `styles/` — generic/global style primitives (`DesignTokens`, `LayoutShell`, `GenericTable`, `FormStyles`, `ResponsiveUtils`)
- `pages (logical grouping)` — role pages (`Maker`, `Checker`, `Admin*`) and data views (`DataTable*`, `LoanData`, `DepositData`)
- `shared components` — `Header`, `Sidebar`, `Footer`, and reusable UI blocks
