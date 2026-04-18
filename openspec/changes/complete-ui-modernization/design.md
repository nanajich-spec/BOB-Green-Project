## Context

The current frontend under `Green_test/Green_test/src` is composed of many page-specific CSS/JS files with inconsistent layout patterns and repeated structure logic. As a banking application, it must convey institutional trust, data security, and operational clarity—yet the current design undermines this with outdated styling, inconsistent layouts, and fragmented navigation. 

This modernization:
1. Integrates **Phoenix template patterns**: modern, responsive application shell with clear separation of navigation, content, and actions
2. Establishes **banking design standards**: transaction tables with audit trails, secure form styling, role-specific action displays, professional typography for financial data
3. Ensures **unified visual language**: consistent header, footer, sidebar, and spacing across all role-driven workflows (admin, maker, checker, verification, loan/deposit views)
4. Aligns with **Figma design system**: all design decisions, tokens, and components reference a living Figma file for future consistency and rapid feature design

The modernization must preserve existing backend APIs while raising the entire frontend to production-grade banking application standards.

## Goals / Non-Goals

**Goals:**
- Deliver a production-grade React application shell with Phoenix-inspired responsive design: branded header (logo, secure session display, theme toggle), collapsible sidebar, footer, and adaptive main content area.
- Implement banking-specific design patterns: transaction tables with audit columns, secure form styling, data density controls, role-specific action displays, professional typography, and institutional color palette.
- Ensure **consistent header/footer/sidebar** across all pages—every page uses the same unified shell and follows the same spacing/typography/interaction rules.
- Apply Material UI as the component foundation while layering banking-specific patterns on top (transaction components, secure forms, data tables with audit support).
- Establish a comprehensive Figma design system: all components, tokens, breakpoints, and patterns documented and synchronized between design and code.
- Provide dark/light theme modes with banking-appropriate color contrast and accessibility standards.
- Ensure responsive behavior at mobile/tablet/desktop breakpoints while maintaining banking transaction clarity and data density.

**Non-Goals:**
- No backend contract or endpoint behavior changes.
- No role or authorization model redesign.
- No full business workflow rewrite—focus on UI/UX presentation and interaction improvements for existing workflows.

## Decisions

1. **Adopt Phoenix template patterns** as the application shell architecture.
   - Rationale: Phoenix provides proven responsive patterns, professional appearance, and clear separation of navigation (sidebar), content (main), and actions (header/footer). Aligns with banking industry standards.
   - Implications: All pages rendered within the same shell; shell components must be responsive and handle collapsible sidebar, persistent header, and footer across all breakpoints.

2. **Use Material UI (`@mui/material`, `@mui/icons-material`, `@emotion/react`, `@emotion/styled`) as the primary component system**, layered with banking-specific pattern components.
   - Rationale: MUI provides responsive layout primitives, design token support, accessibility defaults, and component consistency. Banking patterns built on top add transaction/form/security-specific behaviors.
   - Alternatives considered: Tailwind-only rejected (requires large-scale refactor and lacks banking component patterns). Custom CSS rejected (source of inconsistency).

3. **Create banking design system** with dedicated component library: `src/components/banking/` including transaction tables, secure forms, secure info displays, role-action menus, and audit trail components.
   - Rationale: Banking users expect specific UI patterns for transaction clarity, audit trails, secure displays, and form validation. Generic components insufficient; specialized banking components ensure compliance and trust.
   - Implications: Additional component layer above Material UI; clear reusable patterns for all role pages.

4. **Establish Figma as the single source of truth** for design tokens, colors, typography, spacing, and component patterns.
   - Rationale: Ensures design-to-code consistency, enables rapid feature design, and allows design validation. All developers reference Figma when building new features.
   - Implications: Figma file must document component library, design tokens, breakpoint behavior, and theme variants. Updates to Figma drive code updates via token synchronization.

5. **Implement unified shell** with `AppShell`, `Header`, `Sidebar`, `MainContent`, `Footer` components used by **all** role pages without exception.
   - Rationale: Centralizes navigation/layout logic, guarantees consistent appearance across roles, avoids per-screen variation that causes confusion for banking users who switch roles.
   - Implications: Every page inherits shell structure; sidebar navigation items tied to user role; header profile/actions consistent across all roles.

6. **Enforce responsive breakpoint strategy** (`xs`, `sm`, `md`, `lg`, `xl`) with Phoenix-aligned behavior: sidebar collapsible on mobile, navigation drawer, content reflows to maintain data clarity.
   - Rationale: Banking operations occur on desktop (primary), tablet (operational), and mobile (monitoring). Each breakpoint must preserve transaction clarity and form usability.
   - Implications: All banking components tested at each breakpoint; no layout clipping or overlaps in data-dense screens.

7. **Use banking-appropriate color palette** mapped in Figma and Material UI theme: professional blues/grays for institutional credibility, semantic reds for alerts/declines, greens for approvals/success.
   - Rationale: Banking users recognize trust signals; inappropriate colors undermine credibility. Dark mode essential for operations teams working long shifts.
   - Implications: All color tokens defined in Figma and synchronized to MUI theme; light/dark variants documented.

8. **Migrate screen-by-screen** in a staged approach while preserving existing routes and API integrations.
   - Rationale: Reduces rollout risk and allows incremental validation by role. Housing testing and UAT per role.
   - Implications: Migration batches: core role screens first (admin, maker, checker), then supporting screens (data/loan/deposit), then operational screens.

## Risks / Trade-offs

- [Large UI surface area + banking pattern complexity] → Mitigation: implement shared shell, banking component library, and design system first; then migrate pages in role-based batches with banking pattern validation.
- [Visual regressions during migration + banking pattern consistency] → Mitigation: baseline Figma designs and role-based UAT checklist per screen; validate transaction clarity and audit trails.
- [Bundle size increase from UI library + banking components] → Mitigation: tree-shake Material UI imports; lazy-load banking components for pages that use them; monitor bundle metrics.
- [Figma-to-code synchronization overhead] → Mitigation: automated token generation from Figma (e.g., Figma plugin); document token update process; version control design tokens.
- [Short-term mixed styling while migrating] → Mitigation: enforce migration completion criteria before final release; no partial banking pattern implementations.
- [Banking pattern misalignment with regulatory expectations] → Mitigation: review pattern designs with compliance team; document audit trail and secure display patterns; validate with banking QA.

## Unified Shell Architecture

Every page uses this structure (no exceptions):
```
AppShell
├── Header (logo, secure session display, theme toggle, profile menu)
├── Sidebar (navigation items by role, collapsible on mobile)
├── MainContent
│   └── Page component (admin, maker, checker, data, etc.)
└── Footer (institution info, help, compliance info)
```

All pages inherit consistent:
- Header styling, spacing, responsive behavior
- Sidebar navigation patterns, icon usage, role-specific menu items
- Footer layout and information architecture
- Spacing scale, typography hierarchy, color palette
- Theme (light/dark) application across all elements

## Banking Component Patterns

New component library (`src/components/banking/`) includes:
- **TransactionTable**: Displays transactions with amounts, timestamps, statuses, audit user/timestamp columns, secure number rendering
- **SecureForm**: Form patterns with field validation, masked inputs (passwords, account numbers), secure submission indicators
- **SecureInfoDisplay**: Displays sensitive data (account numbers, routing info) with masking and selective reveal controls
- **RoleActionMenu**: Role-specific action displays (approve, reject, send, etc.) with confirmation patterns
- **AuditTrail**: Displays change history with user, timestamp, action, and old/new display
- **DataDensityControl**: Allows users to adjust table/form display density (compact, normal, spacious) for different working styles
- **StatusIndicator**: Banking-specific status styling (pending, approved, declined, processing) with icons and colors

## Figma Integration Points

1. **Design Tokens File**: Figma file documents all tokens (colors, typography, spacing, shadows, breakpoints)
2. **Component Library**: Figma file mirrors React component library—every Material UI component and banking pattern component documented
3. **Token Synchronization**: Automated process exports tokens from Figma to code (JSON/CSS variables) during build
4. **Design QA**: Before code review, link Figma design to pull request; design team validates pixel-perfect alignment
5. **Future Feature Design**: New features designed in Figma first, then implemented by developers using existing banking components

## Migration Plan

1. Add Material UI dependencies and initialize global theme provider.
2. Implement unified shell components and route wrapper integration.
3. Migrate high-traffic role pages first (admin, maker, checker), then supporting data pages.
4. Remove obsolete page-level layout CSS once each page is migrated.
5. Validate responsive behavior/theme/profile/sidebar interactions in QA and UAT.
6. Rollback strategy: keep migration in isolated commits per module so shell/theme/page batches can be reverted independently.

## Open Questions

- Should theme preference persist server-side per user profile, or client-side storage is sufficient for initial release?
- Which profile actions are mandatory in header corner for v1 (view profile, logout, settings)?
- Is there a mandated Bank of Baroda design token reference that must be mapped into the MUI theme before implementation?