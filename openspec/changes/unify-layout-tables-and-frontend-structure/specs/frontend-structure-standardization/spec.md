## ADDED Requirements

### Requirement: Organized frontend directory structure
The frontend SHALL be organized by clear concerns (layout, pages, shared components, styles, theme) with predictable naming conventions.

#### Scenario: Developer can locate related files quickly
- **WHEN** a developer investigates a page-level UI issue
- **THEN** relevant layout, page, and shared style files are discoverable through standardized folder organization

### Requirement: Shared generic styles replace redundant local CSS
The frontend SHALL centralize common layout and table styling in shared generic style files and SHALL remove redundant page-specific CSS where behavior overlaps.

#### Scenario: Duplicate style definitions are reduced
- **WHEN** migration of role pages is complete
- **THEN** duplicated CSS definitions are replaced by shared style references with equivalent rendered behavior
