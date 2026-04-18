## ADDED Requirements

### Requirement: Bank of Baroda Color Theme
The login page theme SHALL use Bank of Baroda colors defined in the Material UI palette: primary green (#134B2A or approved brand color), secondary blue accent, success green, and neutral grays for backgrounds.

#### Scenario: Primary color application
- **WHEN** login page renders theme
- **THEN** primary buttons, headings, and interactive elements use Bank of Baroda primary green color

#### Scenario: Logo and branding display
- **WHEN** page loads
- **WHEN** Bank of Baroda logo is displayed in the logo container with proper sizing

### Requirement: Bank of Baroda Logo Placement
The Bank of Baroda logo SHALL be displayed prominently at the top-center of the content panel with a white background container and subtle border.

#### Scenario: Logo rendering
- **WHEN** login page loads
- **THEN** BOB logo image displays centered with appropriate sizing and aspect ratio preservation

#### Scenario: Logo container styling
- **WHEN** logo is displayed
- **THEN** logo sits within a Material UI Box container with white background, border, and responsive padding

### Requirement: Application Branding Text
The login page title SHALL display as "Green Project" with "Bank of Baroda" attribution clearly visible in subtitle or footer.

#### Scenario: Page title display
- **WHEN** page renders
- **THEN** "Green Project" appears as main heading in Bank of Baroda primary green color with underline decoration

#### Scenario: Bank attribution
- **WHEN** page loads
- **THEN** "Bank of Baroda" appears in footer with copyright year

### Requirement: Color Consistency Across Components
All buttons, links, form elements, and interactive components SHALL inherit consistent colors from Material UI theme palette.

#### Scenario: Button color theming
- **WHEN** primary action buttons render
- **THEN** buttons use theme.palette.primary.main (Bank of Baroda green)

#### Scenario: Secondary element theming
- **WHEN** secondary actions or text appears
- **THEN** elements use theme.palette.secondary or theme.palette.text colors
