## ADDED Requirements

### Requirement: Reusable table style contract
The application SHALL provide a shared table style contract that standardizes table container behavior, typography, spacing, and row/cell alignment across all role pages.

#### Scenario: Shared table classes are applied across role views
- **WHEN** Maker, Checker, and Admin pages render tabular data
- **THEN** all tables use the shared contract and present consistent structure and visual density

### Requirement: Responsive width and overflow handling
The application SHALL support modern table width behavior with predictable horizontal overflow handling on narrow viewports.

#### Scenario: Table remains usable on smaller screens
- **WHEN** a table contains more columns than viewport width
- **THEN** the table remains readable via controlled horizontal scrolling without clipping critical content
