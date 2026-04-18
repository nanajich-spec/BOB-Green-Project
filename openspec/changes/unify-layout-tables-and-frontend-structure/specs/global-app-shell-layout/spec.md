## ADDED Requirements

### Requirement: Persistent shell with fixed chrome
The application SHALL render a persistent page shell where header and footer remain visible while users navigate within Maker, Checker, and Admin content areas.

#### Scenario: Header and footer remain visible during long content navigation
- **WHEN** a user opens any core page with content taller than the viewport
- **THEN** the header and footer remain fixed and visible at all times

### Requirement: Scroll isolation to main content area
The application SHALL constrain vertical scrolling to the main content container and SHALL prevent full-document scrolling for standard app pages.

#### Scenario: Main content scrolls independently
- **WHEN** a user scrolls on a long data page
- **THEN** only the main content region scrolls and shell chrome does not shift
