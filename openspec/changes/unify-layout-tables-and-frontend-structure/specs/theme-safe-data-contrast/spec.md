## ADDED Requirements

### Requirement: Dark-mode-safe content contrast
The application SHALL ensure data tables and content regions meet readable foreground/background contrast in dark mode.

#### Scenario: Dark mode table text remains readable
- **WHEN** a user enables dark mode and opens any data-heavy page
- **THEN** table headers, rows, and cell text remain clearly visible without white-on-white or low-contrast combinations

### Requirement: Theme-consistent semantic styling
The application SHALL use shared semantic theme variables for table surfaces, borders, text, and hover/focus states in both light and dark themes.

#### Scenario: Theme switch preserves semantic styling
- **WHEN** a user switches between light and dark themes
- **THEN** table and content styling updates consistently using semantic theme values without page-specific overrides breaking readability
