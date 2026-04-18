## 1. UI Foundation and Banking Design System

- [x] 1.1 Add Material UI dependencies (`@mui/material`, `@mui/icons-material`, `@emotion/react`, `@emotion/styled`) to `Green_test/Green_test/package.json`
- [x] 1.2 Create a centralized banking-grade theme module with light/dark theme tokens, institutional color palette, professional typography scale, and theme context provider
- [x] 1.3 Wrap the app root with MUI `ThemeProvider` and persistent theme state initialization
- [ ] 1.4 Create Figma design token file documenting all colors, typography, spacing, shadows, and breakpoints; establish design-to-code token synchronization process
- [ ] 1.5 Create banking design system documentation: component library, token reference, design principles, and accessibility standards

## 2. Phoenix-Template Application Shell with Unified Header/Footer/Sidebar

- [x] 2.1 Build shared Phoenix-inspired shell components for header, collapsible sidebar, footer, and responsive main content container
- [x] 2.2 Implement professional banking header with institutional logo area, secure session display, profile info/actions corner, and global theme toggle
- [x] 2.3 Implement sidebar navigation with expanded/collapsed desktop modes, drawer behavior on small screens, and role-specific navigation items
- [x] 2.4 Implement footer with institution information, help links, compliance information, and consistent styling across all pages
- [ ] 2.5 Ensure shell components follow Phoenix responsive patterns: sidebar collapse at `sm` breakpoint, drawer at `xs`, header remains visible at all breakpoints
- [ ] 2.6 Audit header/footer/sidebar styling and behavior consistency across all role pages (admin, maker, checker, data views); fix any inconsistencies
- [x] 2.7 Integrate shell wrapper with existing route/page structure so shell remains constant across all role screens without exception

## 3. Banking-Specific Design Components and Patterns

- [ ] 3.1 Create banking component library in `src/components/banking/`:
  - [ ] 3.1.1 `TransactionTable`: Displays transactions with amounts, timestamps, user/date audit columns, secure number rendering, role-specific actions, status indicators
  - [ ] 3.1.2 `SecureForm`: Form patterns with masked inputs (passwords, account numbers), field validation, secure submission indicators, error handling
  - [ ] 3.1.3 `SecureInfoDisplay`: Displays sensitive data with masking and selective reveal controls, audit-trail friendly formatting
  - [ ] 3.1.4 `RoleActionMenu`: Role-specific action displays (approve, reject, send, verify) with confirmation patterns and action audit logging
  - [ ] 3.1.5 `AuditTrail`: Displays change history with user, timestamp, action type, and old/new values in banking-readable format
  - [ ] 3.1.6 `DataDensityControl`: Allows users to adjust table/form display density (compact, normal, spacious) with persistent preference
  - [ ] 3.1.7 `StatusIndicator`: Banking-specific status styling (pending, approved, declined, processing, verified) with icons and semantic colors
- [ ] 3.2 Implement banking-specific styling patterns:
  - [ ] 3.2.1 Amount/currency display: right-aligned, monospace font, thousands separators, currency symbols
  - [ ] 3.2.2 Responsive form layouts: mobile-optimized field stacking, desktop multi-column, consistent label alignment
  - [ ] 3.2.3 Data table header freeze: headers sticky while scrolling, action columns always visible
  - [ ] 3.2.4 Secure data rendering: account number masking (e.g., XXXX-XXXX-1234), password field obscuring
- [ ] 3.3 Document all banking components in Figma design system file with usage guidelines, pattern examples, and responsive variants
- [ ] 3.4 Integrate banking components into Material UI theme so styling is centralized and theme-aware
- [ ] 3.5 Add banking component unit tests covering responsive behavior, accessibility, and theme variants

## 4. Role Screen Modernization with Banking Patterns and Consistent Shell

- [x] 4.1 Inventory existing role and operational screens (admin, maker, checker, verification, loan/deposit/data views) and map migration priority
- [x] 4.2 Refactor `Admin*` screens to use shared shell, responsive grids, banking action menus, and consistent MUI components
- [x] 4.3 Refactor `Maker*` and `Checker*` screens to use shared shell, banking secure forms, transaction tables, role action menus, and consistent actions
- [x] 4.4 Refactor remaining operational screens (`UserManagement`, `RiskAssessment`, `LoanData`, `DepositData`, `DataTable`, `Verified`) to use shell, banking transaction/audit components, and banking patterns
- [ ] 4.5 Replace all existing tables with banking `TransactionTable` component (includes audit columns, amount styling, status indicators, responsive behavior)
- [ ] 4.6 Replace all existing forms with banking `SecureForm` component (includes masked inputs, validation patterns, secure submission, audit logging)
- [ ] 4.7 Ensure **every page** uses the unified shell (header/footer/sidebar)—perform automated audit to confirm no page bypasses shell
- [ ] 4.8 Standardize role-specific action displays: all role pages (admin, maker, checker) use the same `RoleActionMenu` pattern
- [ ] 4.9 Add audit trail display to all data-modification pages (create, edit, approve, verify actions) using `AuditTrail` component
- [x] 4.10 Remove obsolete per-page legacy CSS causing overlaps once each page migration is complete

## 5. Figma Design Integration and Design System Foundation

- [ ] 5.1 Create master Figma file: `Banking Application Design System`
  - [ ] 5.1.1 Design Tokens page: colors (light/dark), typography, spacing scale, shadows, breakpoints documented
  - [ ] 5.1.2 Component Library page: Material UI components + banking components with usage variants
  - [ ] 5.1.3 Pattern Library page: form patterns, transaction table patterns, secure displays, action menus, audit trails
  - [ ] 5.1.4 Icons page: all Material UI icons + custom banking icons (approve, reject, verify, audit, secure)
  - [ ] 5.1.5 Breakpoint specification page: responsive behavior at `xs`, `sm`, `md`, `lg`, `xl` with layout diagrams
- [ ] 5.2 Establish token synchronization: automated export from Figma tokens to code (colors.json, typography.json, spacing.json)
- [ ] 5.3 Document Figma-to-code workflow: when design tokens update, how developers sync and apply changes
- [ ] 5.4 Create component documentation linking Figma designs to React component implementations
- [ ] 5.5 Establish design review process: all pull requests with UI changes must reference Figma designs and include design review approval

## 6. Responsive and Interaction Quality

- [ ] 6.1 Validate layout behavior at mobile/tablet/desktop breakpoints (`xs`, `sm`, `md`, `lg`, `xl`) for all modernized screens
- [ ] 6.2 Test sidebar collapse/expand at breakpoint transitions (desktop to tablet, tablet to mobile)
- [ ] 6.3 Verify drawer behavior on mobile (`xs`, `sm` breakpoints) with no layout overlap
- [ ] 6.4 Confirm all headers, footers, and sidebars remain styled consistently across breakpoint changes
- [ ] 6.5 Test dark/light theme switching on all screens—verify no color contrast issues or unreadable elements
- [ ] 6.6 Confirm form layout responsiveness: mobile stacks fields vertically, tablet/desktop uses multi-column where appropriate
- [ ] 6.7 Validate transaction table behavior: desktop shows all columns, tablet/mobile hides secondary columns with swipe reveal or expand
- [ ] 6.8 Test data density control: compact/normal/spacious modes render correctly at all breakpoints
- [ ] 6.9 Perform accessibility validation: keyboard navigation, screen reader compatibility, color contrast (WCAG AA minimum)

## 7. Banking-Specific Validation and Compliance

- [ ] 7.1 Audit all data displays for secure rendering: account numbers masked, sensitive fields not logged, audit trails complete
- [ ] 7.2 Verify transaction clarity: amounts clear, status obvious, role-specific actions visible and unambiguous
- [ ] 7.3 Validate form security: no sensitive data in URL parameters, submission confirmation, error messages don't leak information
- [ ] 7.4 Confirm audit trail completeness: all user actions (approve, reject, create, modify) captured with user, timestamp, and change details
- [ ] 7.5 Test role-based permission displays: only authorized actions shown per user role, disabled actions clearly marked
- [ ] 7.6 Validate session display security: session timeout warnings visible, logout accessible from header, profile info secure

## 8. Testing and Release Readiness

- [x] 8.1 Run frontend tests/build and resolve implementation-related regressions introduced by the modernization
- [ ] 8.2 Perform role-based UI smoke testing (admin, maker, checker) covering:
  - [ ] 8.2.1 Navigation: sidebar menu items correct per role, links work, responsive drawer on mobile
  - [ ] 8.2.2 Shell consistency: header/footer/sidebar identical across all pages, theme switching works globally
  - [ ] 8.2.3 Banking patterns: transaction tables display correctly, secure forms validate, action menus work per role
  - [ ] 8.2.4 Data pages: loan/deposit/data views use banking components, responsive behavior correct, theme consistent
- [ ] 8.3 Perform comprehensive browser/device testing: Chrome, Firefox, Safari; desktop, tablet, mobile; light/dark themes
- [ ] 8.4 Conduct banking pattern compliance review: audit trails, secure displays, form validation, action confirmations meet expectations
- [x] 8.5 Capture before/after visual verification notes and finalize migration checklist for rollout
- [ ] 8.6 Performance testing: bundle size monitoring, theme switch latency, table rendering with large datasets, responsive layout reflows
- [ ] 8.7 Create rollout documentation: deployment steps, known limitations, user guides for theme switching/density control, support contacts

## 9. Future Design Extension

- [ ] 9.1 Establish process for future feature design: designers work in Figma first, developers implement using existing banking components
- [ ] 9.2 Document how to propose new banking components: process for design review, token integration, testing, and release
- [ ] 9.3 Create developer onboarding guide: how to use design system, access Figma, reference design tokens, build new pages