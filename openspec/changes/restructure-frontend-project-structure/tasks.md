# Frontend Restructuring - Implementation Tasks

## Phase 1: Project Structure Setup (Day 1)

### Task 1.1: Create Folder Structure
- [ ] Create all main folders: `pages/`, `components/`, `layouts/`, `hooks/`, `context/`, `services/`, `styles/`, `utils/`, `types/`, `config/`, `theme/`
- [ ] Create subfolders within each main folder (admin, checker, maker, etc.)
- [ ] Verify folder hierarchy matches design.md specification
- [ ] Create index.js files in each folder for clean exports

### Task 1.2: Setup Configuration Files
- [ ] Create `config/constants.js` with app-wide constants
- [ ] Create `config/routes.js` with centralized route definitions
- [ ] Create `utils/constants.js` for status codes, roles, labels
- [ ] Create `config/mockData.js` with mock data for testing
- [ ] Verify all configs export properly

### Task 1.3: Setup Styling Foundation
- [ ] Create `styles/design-tokens.css` with CSS variables
- [ ] Create `styles/theme.css` with theme definitions
 [x] Create all main folders: `pages/`, `components/`, `layouts/`, `hooks/`, `context/`, `services/`, `styles/`, `utils/`, `types/`, `config/`, `theme/`
 [x] Create subfolders within each main folder (admin, checker, maker, etc.)
 [x] Verify folder hierarchy matches design.md specification
 [x] Create index.js files in each folder for clean exports

## Phase 2: Context & Hooks (Day 1)
 [x] Create `config/constants.js` with app-wide constants
 [x] Create `config/routes.js` with centralized route definitions
 [x] Create `utils/constants.js` for status codes, roles, labels
 [x] Create `config/mockData.js` with mock data for testing
 [x] Verify all configs export properly
- [ ] Create `context/NotificationContext.js` for toast messages
- [ ] Wrap App.js with all providers
 [x] Create `styles/design-tokens.css` with CSS variables
 [x] Create `styles/theme.css` with theme definitions
 [x] Create `styles/globals.css` with global resets
 [x] Create `styles/typography.css` with font definitions
 [x] Create `styles/responsive.css` with breakpoint definitions
 [x] Import all styles in `index.js`
- [ ] Create `hooks/useNavigation.js` - role-based navigation
- [ ] Create `hooks/useTheme.js` - theme toggle
 [x] Create `context/AuthContext.js` for user authentication
 [x] Create `context/ThemeContext.js` for light/dark mode
 [x] Create `context/LayoutContext.js` for sidebar/mobile state
 [x] Create `context/NotificationContext.js` for toast messages
 [x] Wrap App.js with all providers
 [ ] Test context access in components
- [ ] Create `services/api/axiosInstance.js` with configured axios client
- [ ] Create `services/api/accountsApi.js` for account endpoints
 [x] Create `hooks/useAuth.js` - access auth context
 [x] Create `hooks/useApi.js` - API fetching with loading/error states
 [x] Create `hooks/useForm.js` - form state management
 [x] Create `hooks/useNavigation.js` - role-based navigation
 [x] Create `hooks/useTheme.js` - theme toggle
 [x] Create `hooks/index.js` with all exports
 [ ] Document hook usage patterns
- [ ] Create `services/auth.js` for authentication logic
- [ ] Create `services/validation.js` for form validation
 [x] Create `services/api/axiosInstance.js` with configured axios client
 [x] Create `services/api/accountsApi.js` for account endpoints
 [x] Create `services/api/usersApi.js` for user management
 [x] Create `services/api/loansApi.js` for loan data
 [x] Create `services/api/depositsApi.js` for deposit data
 [x] Create `services/api/index.js` with all exports
 [ ] Replace all axios calls with service methods
- [ ] Create `layouts/CheckerLayout.js` - checker-specific layout
- [ ] Create `layouts/MakerLayout.js` - maker-specific layout
 [x] Create `services/auth.js` for authentication logic
 [x] Create `services/validation.js` for form validation
 [x] Create `services/index.js` with all exports
 [ ] Test service methods with mock data

### Task 4.2: Update Core Layout Components
 [x] Create `layouts/AdminLayout.js` - admin-specific layout
 [x] Create `layouts/CheckerLayout.js` - checker-specific layout
 [x] Create `layouts/MakerLayout.js` - maker-specific layout
 [x] Create `layouts/AuthLayout.js` - no header/sidebar layout
 [x] Each layout includes breadcrumbs, title, styling
 [ ] Test layouts with all pages
 [ ] Verify responsive behavior
## Phase 5: Reusable Components (Day 2)

 [x] Update `components/layout/Header.js` with new structure
 [x] Update `components/layout/Sidebar.js` with new structure
 [x] Update `components/layout/Footer.js` with new structure
 [x] Create `components/layout/Breadcrumbs.js`
 [ ] Update `layout/AppShell.js` to support new layouts
 [ ] Test all layout components
- [ ] Test tables across all pages

 [x] Create `components/tables/DataTableWrapper.js` - reusable table wrapper
 [x] Keep `components/SearchBar.js` - already exists
 [x] Create `components/tables/TablePagination.js` - pagination controls
 [ ] Update all pages to use DataTableWrapper
 [ ] Remove duplicate table styling code
 [ ] Test tables across all pages

### Task 5.3: Create Dialog Components
 [x] Create `components/forms/FormSection.js` - editable form sections
 [x] Create `components/forms/InputGroup.js` - labeled inputs
 [x] Create `components/forms/FileUploader.js` - file upload
 [ ] Update Admin1/Admin2 pages to use form components
 [ ] Test form interactions and validation
## Phase 6: Page Migration (Day 2-3)

 [x] Create `components/dialogs/ConfirmDialog.js`
 [x] Create `components/dialogs/NotificationDialog.js`
 [ ] Update pages to use dialog components
 [ ] Test dialog interactions
  - `pages/admin/AdminDetails.js` (from Admin1.js + Admin2.js)
  - `pages/admin/AdminRiskAssessment.js` (from RiskAssessment.js)
 [x] Move & rename page files:
   - [x] `pages/admin/AdminPending.js` (from Admin.js)
   - [x] `pages/admin/AdminReport.js` (from Admin_c.js)
   - [x] `pages/admin/AdminDetails.js` (from Admin1.js + Admin2.js)
   - [x] `pages/admin/AdminRiskAssessment.js` (from RiskAssessment.js)
 [ ] Wrap pages with AdminLayout
 [ ] Update all imports to use service layer
 [ ] Update all imports to use hooks
 [ ] Test all admin pages
  - `pages/checker/CheckerVerified.js` (from Verified.js)
- [ ] Wrap pages with CheckerLayout
 [x] Move & rename page files:
   - [x] `pages/checker/CheckerPending.js` (from Checker.js)
   - [x] `pages/checker/CheckerDetails.js` (from Checker1.js)
   - [x] `pages/checker/CheckerVerified.js` (from Verified.js)
 [ ] Wrap pages with CheckerLayout
 [ ] Update all imports to service layer
 [ ] Test all checker pages
  - `pages/maker/MakerDetails.js` (from DataTable.js, DataTable1.js)
- [ ] Wrap pages with MakerLayout
 [x] Move & rename page files:
   - [x] `pages/maker/MakerNew.js` (from Maker.js)
   - [x] `pages/maker/MakerExisting.js` (from ExistingRecordsPage.js)
   - [x] `pages/maker/MakerDetails.js` (from DataTable.js, DataTable1.js)
 [ ] Wrap pages with MakerLayout
 [ ] Update all imports
 [ ] Test all maker pages
  - `pages/dashboards/RiskAssessmentDash.js`
  - `pages/dashboards/ProjectSpecificIndicator.js`
 [x] Move & rename page files:
   - [x] `pages/dashboards/LoanDashboard.js` (from LoanData.js)
   - [x] `pages/dashboards/DepositPosition.js` (from DepositData.js)
   - [x] `pages/dashboards/RiskAssessmentDash.js`
   - [x] `pages/dashboards/ProjectSpecificIndicator.js`
   - [x] `pages/dashboards/UserManagement.js`
 [ ] Wrap pages with AdminLayout
 [ ] Update all imports
 [ ] Test all dashboard pages
- [ ] Test login flow

 [x] Move `pages/auth/Login.js` (from Login.js)
 [ ] Wrap with AuthLayout
 [ ] Update imports
 [ ] Test login flow
- [x] Update all route paths using centralized ROUTES config
- [x] Update AppShell integration with new pages
- [ ] Test all route transitions
- [x] Verify 404 handling

### Task 7.2: Update Sidebar Navigation
- [x] Update Sidebar.js to use centralized ROUTES config
- [ ] Test navigation across all roles
- [ ] Verify breadcrumbs on each page
- [ ] Test responsive navigation on mobile

## Phase 8: Import & Dependency Updates (Day 3)

### Task 8.1: Update All Imports
- [ ] Find all relative imports pointing to old locations
- [x] Replace with new paths from restructured locations
- [x] Update barrel exports in index.js files
- [x] Run linter to catch any remaining issues

### Task 8.2: Clean Up Old Files
- [ ] Backup old src/ structure
- [ ] Remove old page files (Admin.js, Checker.js, etc.)
- [ ] Remove old component files from root
- [ ] Remove old CSS files
- [ ] Verify no dead imports remain

## Phase 9: Testing & Verification (Day 3)

### Task 9.1: Console & Build Validation
- [ ] Clear all console errors and warnings
- [ ] Run full build without warnings
- [x] Test dev server startup
- [ ] Verify hot reload works

### Task 9.2: Functional Testing
- [ ] Test Admin role: all 6 sidebar pages
  - [ ] Pending accounts page with search
  - [ ] User management page
  - [ ] Report page with search
  - [ ] Dashboard (Loan) with search
  - [ ] Dashboard Charts (Risk Assessment)
  - [ ] Green Deposit Position with search
- [ ] Test Checker role: pending & verified accounts
- [ ] Test Maker role: new & existing records
- [ ] Test Login flow
- [ ] Test account detail pages (Admin1/Admin2 flow)
- [ ] Test form editing capabilities
- [ ] Test file uploads

### Task 9.3: Responsive Testing
- [ ] Test all pages on mobile breakpoints (xs, sm)
- [ ] Test all pages on tablet breakpoints (md, lg)
- [ ] Test all pages on desktop (xl)
- [ ] Verify sidebar collapse on mobile
- [ ] Verify responsive tables

### Task 9.4: Theme Testing
- [ ] Test light theme across all pages
- [ ] Test dark theme across all pages
- [ ] Verify color contrast accessibility
- [ ] Test theme toggle

## Phase 10: Documentation & Handoff (Day 3)

### Task 10.1: Create Documentation
- [ ] Generate folder structure diagram
- [ ] Create component usage guide
- [ ] Create hook usage examples
- [ ] Create service layer documentation
- [ ] Create routing documentation

### Task 10.2: Code Comments
- [ ] Add JSDoc comments to all components
- [ ] Add usage examples in complex components
- [ ] Document props and return types
- [ ] Add inline comments for complex logic

### Task 10.3: Final Verification
- [ ] Code review of all changes
- [ ] Performance check (bundle size, load time)
- [ ] Security review
- [ ] Cross-browser testing
- [ ] Final sign-off

## Success Metrics

✅ Zero console errors or warnings
✅ All pages load and render correctly
✅ All routes navigate properly
✅ All API calls working with mock or real data
✅ Search functionality works on all data pages
✅ Forms fully editable and functional
✅ All 3 roles (Admin, Maker, Checker) functioning
✅ Responsive design maintained
✅ Dark/light theme working
✅ Build completes without warnings
✅ Hot reload functioning
✅ Breadcrumbs display correctly
✅ All tables styled consistently

## Timeline Estimate

- Phase 1-2: 4 hours (Day 1 morning)
- Phase 3: 3 hours (Day 1 afternoon)
- Phase 4-5: 4 hours (Day 2 morning)
- Phase 6: 5 hours (Day 2 afternoon)
- Phase 7-8: 4 hours (Day 3 morning)
- Phase 9-10: 3 hours (Day 3 afternoon)

**Total: ~23 hours (~3 days)**
