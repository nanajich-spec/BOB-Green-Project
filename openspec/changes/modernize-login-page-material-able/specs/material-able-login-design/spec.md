## ADDED Requirements

### Requirement: Material Able Split-Screen Login Layout
The login page SHALL display as a split-screen design with a decorative left sidebar and content-focused right panel on desktop viewports (>=960px). Below 960px, the sidebar SHALL be hidden and the entire page becomes single-column centered.

#### Scenario: Desktop login display
- **WHEN** viewport width is 960px or greater
- **THEN** the page displays a flex layout with left sidebar (40%) containing decorative elements and right panel (60%) containing login form

#### Scenario: Mobile login display
- **WHEN** viewport width is less than 960px
- **THEN** the page displays single-column centered layout with no left sidebar

### Requirement: Decorative Left Sidebar
The left sidebar SHALL display on desktop containing Bank of Baroda branding, icons representing financial services (lightning bolt, coins, documents), and a gradient background using Bank of Baroda green theme.

#### Scenario: Sidebar content visibility
- **WHEN** viewport is desktop (>=960px)
- **THEN** left sidebar is visible with gradient background image and decorative icons

#### Scenario: Sidebar responsive hiding
- **WHEN** viewport is mobile/tablet (<960px)
- **THEN** left sidebar is hidden and not rendered in DOM

### Requirement: Content Panel with Form
The right panel SHALL contain the login form with Bank of Baroda logo, page title, login fields, role selection, and footer within a Material UI Card component.

#### Scenario: Content panel structure
- **WHEN** page loads
- **THEN** content panel displays Bank of Baroda logo, "Green Project" title, login form, role selection section, and copyright footer

#### Scenario: Panel styling
- **WHEN** page renders
- **THEN** content panel is styled with Material UI Card elevation, rounded corners, and responsive padding using MUI spacing system
