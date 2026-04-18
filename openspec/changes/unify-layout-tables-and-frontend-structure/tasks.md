## 1. Baseline audit and migration setup

- [x] 1.1 Inventory current layout, table, and page-specific CSS usage across Maker, Checker, Admin, and shared data pages.
- [x] 1.2 Define target folder structure for layout, pages, shared components, styles, and theme with a migration map from current files.
- [x] 1.3 Create shared style foundation files for base tokens, layout primitives, and table primitives without removing legacy styles.

## 2. Global app shell implementation

- [x] 2.1 Refactor app/page composition to use a common shell with fixed header and fixed footer.
- [x] 2.2 Implement a dedicated scrollable main content container and prevent document-level vertical scrolling for standard pages.
- [ ] 2.3 Validate shell behavior across Maker, Checker, and Admin routes with long-content screens.

## 3. Unified table system rollout

- [x] 3.1 Implement reusable table classes/components for container, header, rows, cells, and overflow wrappers.
- [x] 3.2 Apply unified table styling to all core tabular screens (Maker, Checker, Admin, loan/deposit/records views).
- [x] 3.3 Standardize table typography, spacing, and responsive width/overflow behavior across migrated pages.

## 4. Dark mode contrast hardening

- [x] 4.1 Define semantic theme variables for table/content surfaces, text, borders, and interactive states.
- [x] 4.2 Replace page-level dark-mode overrides that produce white-on-white or low-contrast content.
- [ ] 4.3 Run dark-mode visual verification across all migrated pages and resolve remaining contrast defects.

## 5. CSS consolidation and structure cleanup

- [x] 5.1 Migrate repeated page-level layout/table styles into shared generic style layers.
- [x] 5.2 Remove redundant CSS files and dead selectors after each page migration is verified.
- [x] 5.3 Reorganize frontend files/folders to the standardized structure and fix import paths.

## 6. Validation and completion

- [x] 6.1 Execute frontend build and fix migration-introduced regressions related to layout and styling.
- [ ] 6.2 Perform role-based regression checks for Maker, Checker, and Admin critical flows.
- [ ] 6.3 Confirm spec coverage and prepare the change for implementation/apply execution.
