## MODIFIED Requirements

### Requirement: Theme Provider Configuration
The theme system SHALL define and export Material UI theme configuration including palette colors, typography variants, breakpoints, and component overrides.

#### Scenario: Theme palette definition
- **WHEN** theme is initialized
- **THEN** theme palette includes primary (Bank of Baroda green), secondary, success, error, warning, info colors

#### Scenario: Breakpoint configuration
- **WHEN** responsive components use theme breakpoints
- **THEN** breakpoints include xs (0), sm (600), md (960), lg (1280), xl (1920) at minimum

#### Scenario: Component default styles
- **WHEN** Material UI components are used
- **THEN** theme overrides apply consistent styling to Button, Card, TextField, Chip, and other components across the application

### Requirement: Theme Context Provider
The application root SHALL wrap all components with MUI ThemeProvider and optional custom context for theme state management and brand color configuration.

#### Scenario: ThemeProvider wrapping
- **WHEN** application initializes
- **THEN** App root is wrapped with Material UI ThemeProvider and custom AppThemeProvider context

#### Scenario: Theme persistence
- **WHEN** user returns to application
- **THEN** previously selected theme (light/dark) is restored from localStorage or persisted state

### Requirement: Brand Color Tokens
The theme configuration SHALL define Bank of Baroda brand colors as semantic tokens (primary, secondary, success, warning) accessible throughout the application.

#### Scenario: Primary color usage
- **WHEN** UI components use theme.palette.primary
- **THEN** color resolves to Bank of Baroda green (#134B2A or approved value)

#### Scenario: Secondary color usage
- **WHEN** UI components use theme.palette.secondary
- **THEN** color resolves to secondary brand accent (blue or defined value)

#### Scenario: Success color usage
- **WHEN** success states render (roles, approvals)
- **THEN** success color applies theme.palette.success using green tone

### Requirement: Typography System Configuration
The theme SHALL define and export typography variants for headings, body text, captions, and labels with consistent font families and sizing.

#### Scenario: Heading typography
- **WHEN** h1, h2, h3 variants are used via Typography component
- **THEN** font size, weight, and line spacing follow Material Design hierarchy

#### Scenario: Body typography
- **WHEN** body content renders via Typography
- **THEN** font sizing and family follow theme configuration for readability

#### Scenario: Component text consistency
- **WHEN** buttons, labels, and UI text render
- **THEN** typography inherits theme values ensuring consistent appearance throughout application
