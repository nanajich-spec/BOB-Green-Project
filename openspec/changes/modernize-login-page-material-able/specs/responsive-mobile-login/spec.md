## ADDED Requirements

### Requirement: Mobile Responsive Layout Override
The login page layout SHALL adapt to mobile viewports (<600px) by switching from split-screen to single-column centered layout.

#### Scenario: Mobile stacked layout
- **WHEN** viewport width is less than 600px (xs breakpoint)
- **THEN** page displays full-width content centered with top hero section replacing left sidebar

#### Scenario: Tablet layout
- **WHEN** viewport width is between 600px and 960px (sm-md breakpoint)
- **THEN** sidebar is hidden and content occupies full width with centered alignment

### Requirement: Responsive Padding and Spacing
All container elements SHALL use Material UI responsive spacing system with different padding values for mobile vs desktop.

#### Scenario: Content panel padding mobile
- **WHEN** viewport is mobile size
- **THEN** content panel uses reduced padding (xs: 2.5 units)

#### Scenario: Content panel padding desktop
- **WHEN** viewport is tablet or larger
- **THEN** content panel uses increased padding (sm+: 3.5 units)

### Requirement: Form Field Responsive Width
Form input fields SHALL be full-width on all screen sizes and stack vertically on mobile.

#### Scenario: Mobile form layout
- **WHEN** viewport is mobile
- **THEN** form fields display full-width in vertical stack

#### Scenario: Desktop form layout
- **WHEN** viewport is desktop
- **THEN** form fields remain full-width stacked in content panel

### Requirement: Button Responsive Sizing
Action buttons SHALL maintain consistent sizing across breakpoints without breaking layout.

#### Scenario: Mobile button width
- **WHEN** viewport is mobile
- **THEN** login buttons display full-width or responsive width fitting content area

#### Scenario: Desktop button layout
- **WHEN** viewport is desktop
- **THEN** buttons maintain appropriate width within role selection card layout

### Requirement: Navigation Drawer for Mobile
Mobile viewport (<600px) navigation SHALL use Material UI Drawer for sidebar content if sidebar becomes interactive.

#### Scenario: Mobile drawer availability
- **WHEN** viewport is mobile and sidebar content is needed
- **THEN** user can open drawer via hamburger or app bar button
