# Restructure Frontend Project - Complete Organization & Architecture

## Why

The current frontend project has grown organically with flat file structures, mixed concerns, and unclear separation between pages, layouts, components, and utilities. This makes onboarding difficult, creates maintenance bottlenecks, and increases the risk of code duplication and styling conflicts. A proper structured folder hierarchy with clear separation of concerns is essential for scalability and team collaboration.

## What Changes

- **Reorganize src/ folder** into logically separated domains: `pages/`, `components/`, `layouts/`, `hooks/`, `context/`, `services/`, `styles/`, `utils/`, and `types/`
- **Separate page-level components** from reusable UI components for clarity and reusability
- **Implement consistent navigation patterns** with a centralized routing configuration and breadcrumb system
- **Extract and centralize styling** into a shared theme system with consistent design tokens (colors, spacing, typography, shadows)
- **Create custom hooks** for common patterns (authentication, data fetching, form handling)
- **Establish service layer** for API calls, replacing scattered axios usage
- **Implement proper component composition** with layout wrappers (e.g., AdminLayout, AuthLayout, CheckerLayout)
- **Add proper TypeScript types/interfaces** for consistency and type safety
- **Create comprehensive documentation** for navigation, folder structure, and component patterns

## Capabilities

### New Capabilities
- `organized-folder-structure`: Provides clear separation of concerns with dedicated folders for pages, components, layouts, hooks, services, and styles
- `consistent-page-navigation`: Enables standardized breadcrumbs, page titles, and navigation flows across all roles (Admin, Maker, Checker)
- `reusable-layout-components`: Provides AdminLayout, CheckerLayout, MakerLayout wrappers for consistent page structure
- `centralized-styling-system`: Provides shared design tokens, theme utilities, and consistent CSS organization
- `service-layer-abstraction`: Provides centralized API clients and data fetching hooks to replace scattered axios calls
- `component-composition-patterns`: Establishes best practices for component hierarchy and prop patterns

### Modified Capabilities
- None (architectural refactor only, no functional changes)

## Impact

- **Scope**: Complete frontend restructuring in `Green_test/Green_test/src/`
- **Risk**: Medium - significant file reorganization requires careful import/export updates and testing
- **Timeline**: 2-3 days for reorganization + testing
- **No backend changes**: Routing and API contracts remain identical
- **Testing scope**: Navigation testing, layout verification, cross-role scenario testing

## Success Criteria

- ✅ All pages organized into proper folder structure
- ✅ Consistent navigation and breadcrumbs across all pages
- ✅ Centralized styling with no style duplication
- ✅ All imports updated and working
- ✅ Zero console errors or warnings
- ✅ All 3 roles (Admin, Maker, Checker) functioning correctly
- ✅ Responsive design maintained across all breakpoints
