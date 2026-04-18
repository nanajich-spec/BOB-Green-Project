# Frontend Restructuring - Design & Architecture

## Folder Structure

```
src/
├── pages/                          # Page components organized by role/feature
│   ├── admin/
│   │   ├── AdminPending.js         # Admin - Pending Accounts
│   │   ├── AdminReport.js          # Admin - Report View
│   │   ├── AdminDetails.js         # Admin - Account Details (Admin1/Admin2)
│   │   └── AdminRiskAssessment.js  # Admin - Risk Assessment
│   ├── checker/
│   │   ├── CheckerPending.js       # Checker - Pending Verification
│   │   ├── CheckerDetails.js       # Checker - Check Details
│   │   └── CheckerVerified.js      # Checker - Verified Accounts
│   ├── maker/
│   │   ├── MakerNew.js             # Maker - Create New Record
│   │   ├── MakerExisting.js        # Maker - Existing Records
│   │   └── MakerDetails.js         # Maker - Record Details
│   ├── dashboards/
│   │   ├── LoanDashboard.js        # Loan Dashboard (Dashboard Charts)
│   │   ├── DepositPosition.js      # Green Deposit Position
│   │   ├── RiskAssessment.js       # Risk Assessment Dashboard
│   │   ├── ProjectSpecificIndicator.js
│   │   └── UserManagement.js       # User Management
│   ├── auth/
│   │   └── Login.js                # Login page
│   └── index.js                    # Page exports
├── layouts/                        # Layout wrappers
│   ├── AppShell.js                 # Main layout (Header + Sidebar + Footer)
│   ├── AdminLayout.js              # Admin-specific layout
│   ├── CheckerLayout.js            # Checker-specific layout
│   ├── MakerLayout.js              # Maker-specific layout
│   └── AuthLayout.js               # Auth layout (no header/sidebar)
├── components/                     # Reusable UI components
│   ├── layout/
│   │   ├── Header.js
│   │   ├── Sidebar.js
│   │   ├── Footer.js
│   │   └── Breadcrumbs.js
│   ├── tables/
│   │   ├── DataTableWrapper.js     # Reusable table component
│   │   ├── SearchBar.js            # Search/filter component
│   │   └── TablePagination.js      # Pagination controls
│   ├── forms/
│   │   ├── FormSection.js          # Section with edit toggle
│   │   ├── InputGroup.js           # Labeled input group
│   │   └── FileUploader.js         # File upload component
│   ├── dialogs/
│   │   ├── ConfirmDialog.js
│   │   └── NotificationDialog.js
│   └── index.js                    # Component exports
├── hooks/                          # Custom React hooks
│   ├── useAuth.js                  # Authentication context
│   ├── useApi.js                   # API fetching with loading/error states
│   ├── useForm.js                  # Form state management
│   ├── useNavigation.js            # Role-based navigation
│   └── index.js                    # Hook exports
├── context/                        # React Context providers
│   ├── AuthContext.js              # User authentication state
│   ├── ThemeContext.js             # Theme/color mode
│   ├── LayoutContext.js            # Sidebar/Mobile state
│   └── NotificationContext.js      # Toast/notification management
├── services/                       # API clients & business logic
│   ├── api/
│   │   ├── accountsApi.js          # Accounts endpoints
│   │   ├── usersApi.js             # User management endpoints
│   │   ├── loansApi.js             # Loan data endpoints
│   │   ├── depositsApi.js          # Deposit position endpoints
│   │   └── axiosInstance.js        # Configured axios client
│   ├── auth.js                     # Authentication service
│   ├── validation.js               # Form validation utilities
│   └── index.js                    # Service exports
├── styles/                         # Global styles & design tokens
│   ├── design-tokens.css           # Colors, spacing, typography
│   ├── theme.css                   # Theme definitions
│   ├── globals.css                 # Global resets and utilities
│   ├── typography.css              # Font definitions
│   ├── components.css              # Component-specific base styles
│   └── responsive.css              # Responsive breakpoints
├── theme/                          # Theme configuration
│   ├── AppThemeProvider.js         # Material-UI theme provider
│   ├── themeConfig.js              # Theme colors and settings
│   └── useTheme.js                 # Theme hook
├── utils/                          # Utility functions
│   ├── constants.js                # App constants, roles, statuses
│   ├── helpers.js                  # Common helper functions
│   ├── dateFormatter.js            # Date/time formatting
│   ├── numberFormatter.js          # Number/currency formatting
│   ├── validation.js               # Input validation rules
│   └── index.js                    # Utils exports
├── types/                          # TypeScript types & interfaces
│   ├── account.ts                  # Account types
│   ├── user.ts                     # User types
│   ├── api.ts                      # API response types
│   └── index.ts                    # Type exports
├── config/                         # Configuration
│   ├── constants.js                # API endpoints, roles
│   ├── routes.js                   # Route definitions with roles
│   └── mockData.js                 # Mock data (testing)
├── App.js                          # Main app component
├── index.js                        # Entry point
└── setupTests.js                   # Test configuration
```

## Architectural Decisions

### 1. **Page Organization by Role**
- Pages organized under `pages/{role}/` for clarity
- Each role (admin, checker, maker) has dedicated folder
- Dashboards grouped separately for easy discovery

### 2. **Layout Wrapper Pattern**
```javascript
<AdminLayout>
  <AdminPending />
</AdminLayout>
```
- Eliminates repetitive header/sidebar/footer in each page
- Enables role-specific styling and navigation
- Simplifies page content to focus on business logic

### 3. **Service Layer for API Calls**
Instead of scattered axios calls:
```javascript
// Before (scattered)
const response = await axios.get('/green-project/api/v1/ViewDetailsAdmin');

// After (centralized)
const accounts = await accountsApi.getAdminAccounts();
```

### 4. **Custom Hooks for Common Patterns**
```javascript
const { data, loading, error } = useApi('accounts/pending');
const { formData, setField, handleSubmit } = useForm(initialValues);
const { user, roles } = useAuth();
```

### 5. **Centralized Styling**
- Design tokens in CSS variables for easy theming
- Global styles imported once in index.js
- Per-component CSS only for component-specific styling
- No more scattered, duplicated styles

### 6. **Navigation & Routing**
Centralized route configuration in `config/routes.js`:
```javascript
const ROUTES = {
  ADMIN: {
    PENDING: '/admin',
    REPORT: '/report',
    DETAILS: '/admin/details/:id'
  },
  CHECKER: {
    PENDING: '/checker',
    DETAILS: '/checker/details/:id'
  },
  // ...
};
```

### 7. **Context API for Global State**
- AuthContext: User, role, permissions
- ThemeContext: Dark/light mode
- LayoutContext: Sidebar collapse, mobile state
- NotificationContext: Toast messages

## Component Composition

### SearchBar Usage
```javascript
<SearchBar 
  onSearch={handleSearch} 
  placeholder="Search by Account Number"
/>
```

### DataTable Wrapper
```javascript
<DataTableWrapper
  data={accounts}
  columns={[
    { field: 'accountNumber', header: 'Account Number' },
    { field: 'borrowerName', header: 'Borrower Name' }
  ]}
  onRowClick={handleRowClick}
  loading={isLoading}
/>
```

### Layout Structure
```javascript
<AdminLayout title="Pending Accounts" breadcrumbs={[...]}>
  <SearchBar onSearch={handleSearch} />
  <DataTableWrapper data={filteredAccounts} />
</AdminLayout>
```

## Styling Strategy

### Design Tokens (CSS Variables)
```css
:root {
  --color-primary: #0d3520;
  --color-secondary: #22c55e;
  --spacing-sm: 8px;
  --spacing-md: 16px;
  --radius-md: 10px;
}
```

### Component CSS
```css
.admin-layout {
  display: flex;
  flex-direction: column;
}

.admin-layout__header {
  background: linear-gradient(...);
}
```

## Migration Path

1. Create new folder structure (non-breaking)
2. Copy pages to new locations with updated imports
3. Create layout wrappers and update pages
4. Extract services layer
5. Create hooks layer
6. Centralize styling
7. Update routing in App.js
8. Remove old files
9. Comprehensive testing

## Benefits

✅ **Maintainability**: Clear structure makes code easy to locate and modify
✅ **Scalability**: Easy to add new pages, components, and features
✅ **Collaboration**: Team members can work on different domains independently
✅ **Reusability**: Shared components and hooks reduce duplication
✅ **Testing**: Isolated components and services are easier to test
✅ **Performance**: Service layer enables caching and optimization
✅ **Documentation**: Folder structure serves as documentation
