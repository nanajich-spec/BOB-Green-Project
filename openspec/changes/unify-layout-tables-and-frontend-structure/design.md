## Context

The current React frontend in `Green_test/Green_test/src/` has page-specific CSS spread across many files, resulting in inconsistent layout behavior and styling drift between Maker, Checker, Admin, and shared data pages. Header/footer behavior is not consistently fixed, some views scroll the full page instead of content-only, and dark mode has table contrast defects in several screens. The project also has low structural clarity, making debugging and onboarding difficult.

Primary constraints:
- Existing business flows and backend API integration must remain unchanged.
- Changes must be incremental and regression-safe across all role pages.
- Styling must become reusable and centralized to reduce file sprawl.

## Goals / Non-Goals

**Goals:**
- Establish a global app shell with fixed header/footer and a scrollable main content container.
- Introduce shared, generic style foundations for typography, spacing, and table rendering.
- Ensure dark-mode-safe content/table contrast for all core pages.
- Improve frontend folder and styling organization for easier maintenance and debugging.
- Reduce duplicated page-specific CSS by migrating to shared layout/table/theme layers.

**Non-Goals:**
- No backend API contract changes or database changes.
- No redesign of business workflows, role permissions, or page-level feature scope.
- No broad component library migration outside current stack.

## Decisions

### 1) Global fixed app shell architecture
- Decision: Standardize all role pages on a shared shell composition (`Header` + `MainContent` + `Footer`) where only `MainContent` has vertical scroll.
- Rationale: Enforces consistent viewport behavior and navigation visibility across all screens.
- Alternatives considered:
  - Per-page sticky headers/footers: rejected due to duplication and drift.
  - Full-page scroll with sticky elements: rejected due to inconsistent offsets and overflow bugs.

### 2) Shared generic styling layers
- Decision: Consolidate layout, typography, spacing, and table styles into shared generic CSS modules under a clear structure (e.g., `styles/base`, `styles/layout`, `styles/components`).
- Rationale: Reduces duplicated CSS, lowers maintenance cost, and improves predictability.
- Alternatives considered:
  - Keep page-local CSS with minor cleanup: rejected because it does not solve long-term inconsistency.
  - Full CSS-in-JS rewrite: rejected as high-risk and out of scope.

### 3) Unified table system
- Decision: Apply a reusable table class contract (container, header, rows, cells, responsive overflow wrappers) with standardized font scale, spacing, and width behavior.
- Rationale: Tables are repeated across data pages and currently diverge in density/readability.
- Alternatives considered:
  - Keep custom table styles per page: rejected due to inconsistent UX.
  - Introduce a new table framework: rejected for scope and migration overhead.

### 4) Theme-safe contrast rules
- Decision: Define explicit semantic variables/tokens for surface, text, border, and hover states and apply them to all table/content regions in both light and dark themes.
- Rationale: Resolves current dark-mode cases where content appears white-on-white or low-contrast.
- Alternatives considered:
  - Spot-fix individual pages only: rejected because defects recur and are hard to audit.

### 5) Frontend structure standardization
- Decision: Reorganize frontend folders by concern (layout, pages, shared components, styles, theme) and align naming conventions for predictable discovery.
- Rationale: Improves debugging speed and reduces cognitive load for future changes.
- Alternatives considered:
  - Keep current structure and add documentation only: rejected as insufficient without physical organization changes.

## Risks / Trade-offs

- [Risk] Layout shell migration may alter spacing/overflow on some legacy pages. → Mitigation: roll out role-by-role with visual regression checks and fallback class adapters.
- [Risk] CSS consolidation may unintentionally change page-specific visual behavior. → Mitigation: map old class usage, migrate in batches, and keep temporary compatibility aliases.
- [Risk] Dark-mode token updates may miss edge-case custom elements. → Mitigation: run checklist-based dark-mode audit on all data tables and high-traffic screens.
- [Risk] Folder restructuring can break imports during transition. → Mitigation: use staged moves, path alias checks, and per-stage build validation.

## Migration Plan

1. Introduce shared shell and generic style foundation without removing legacy CSS.
2. Migrate Maker pages to shared shell/table/theme classes and validate build/visual behavior.
3. Migrate Checker and Admin pages with the same pattern and remove replaced local CSS.
4. Apply final folder restructuring and import normalization.
5. Execute full frontend build and regression sweep; keep rollback by preserving pre-migration commit boundaries.

Rollback strategy:
- Revert migration batch by batch (layout, table styles, theme tokens, folder moves) if regressions appear.
- Preserve temporary compatibility classes during cutover until all pages are migrated.

## Open Questions

- Which existing page-specific CSS files are currently authoritative vs obsolete duplicates?
- Should table density use a single default or role-specific presets (compact/comfortable)?
- Do we need route-level layout exceptions for any legacy full-screen pages?
