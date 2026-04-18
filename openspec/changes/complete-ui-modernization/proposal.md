## Why

The current React screens look outdated, have overlapping layout issues, and do not use available viewport space effectively across devices. As a production-grade banking application, the frontend must deliver institutional confidence, security-first design, and consistent professional appearance across all user roles. A comprehensive UI modernization is needed now to:
- Improve usability, consistency, and maintainability for admin, maker, checker, and verification workflows
- Establish a production-level banking application framework aligned with industry standards
- Provide a unified design system that banking users expect (secure displays, transaction clarity, audit trails, professional typography)

## What Changes

- Introduce a modern Phoenix-template-inspired application shell with persistent branded header, collapsible sidebar, footer, and responsive main content region.
- Add a professional banking-grade header with institutional logo, secure profile/session display, and theme switching (light/dark).
- Integrate Phoenix template design patterns and responsive breakpoint strategy across the entire application.
- Implement banking-specific design components: transaction tables with audit trails, secure form patterns, data density controls, and role-specific action displays.
- Redesign all major role-based screens (admin, maker, checker, verification, loan/deposit/data views) with consistent banking UI patterns and responsive behavior.
- Replace legacy CSS-heavy page structures with a component-driven UI foundation using Material UI, banking-specific patterns, and Figma-designed design tokens.
- Establish and document a comprehensive design system with Figma integration points for future feature design and validation.
- Standardize spacing, typography, interaction states, and layout behavior across all pages to deliver institutional-grade consistency.

## Capabilities

### New Capabilities
- `phoenix-banking-app-shell`: Provides a production-grade responsive shell with institutional header (logo, session display, theme toggle, profile), collapsible sidebar, footer, and adaptive content area. Implements Phoenix design patterns and banking-specific navigation expectations.
- `banking-design-system`: Introduces a complete banking UI component library including transaction tables with audit columns, secure form patterns, data density controls, role-action displays, and status indicators aligned to banking workflows.
- `figma-design-integration`: Establishes Figma design tokens, component library mappings, and design-to-code synchronization points for consistent future feature development and UI validation.
- `role-screen-modernization`: Defines modernized, role-based page experiences for admin/maker/checker and related operational screens using banking design patterns, shared components, and consistent responsive behavior.
- `banking-specific-patterns`: Implements secure info displays, transaction audit tables, form validation UX, password/session handling, and compliance-ready interaction patterns.

### Modified Capabilities
- None.

## Impact

- Frontend code in `Green_test/Green_test/src` across layout, navigation, banking-specific components, and role-specific page components.
- Styling architecture moves from fragmented CSS files toward a centralized banking design system with Material UI theming, Figma-mapped design tokens, and production-grade consistency.
- New directories created: `src/components/banking/` (secure forms, transaction tables, info displays), `src/design-system/` (tokens, breakpoints, utilities), `src/theme/` (banking color palette, typography scale).
- Frontend dependencies add Material UI, banking icons/utilities, and Figma integration tooling while retaining existing backend API contracts.
- Documentation scope includes Figma design token mapping, design system guidelines, and component usage patterns for banking workflows.
- QA scope expands to responsive behavior, theme consistency, banking pattern correctness (transaction clarity, audit trails, security displays), and role-based accessibility validation.
- Follow-up design audits leverage Figma designs to validate implementation alignment and guide future feature design.