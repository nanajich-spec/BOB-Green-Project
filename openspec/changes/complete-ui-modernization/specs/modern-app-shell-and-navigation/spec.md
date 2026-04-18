## ADDED Requirements

### Requirement: Unified Responsive Application Shell
The system SHALL provide a unified application shell for all authenticated UI screens that includes a header, sidebar, footer, and responsive main content container.

#### Scenario: Shell renders consistently across routes
- **WHEN** a user navigates between role-based pages
- **THEN** the same shell structure (header, sidebar, footer, content region) MUST remain consistent and only page content changes

#### Scenario: Main content uses available viewport safely
- **WHEN** the shell is rendered on desktop or mobile viewport sizes
- **THEN** the content region MUST adapt to available space without overlap with header, sidebar, or footer

### Requirement: Branded Header With Theme and Profile Controls
The system SHALL provide a header containing application logo/branding, a dark/light mode toggle, and profile information/actions in the top corner.

#### Scenario: Theme mode toggles globally
- **WHEN** the user switches theme mode from header control
- **THEN** the entire UI MUST update to the selected theme without route refresh

#### Scenario: Profile block is always accessible
- **WHEN** any authenticated page is open
- **THEN** profile identity and action controls MUST be visible in the header corner

### Requirement: Collapsible Sidebar Navigation
The system SHALL provide a collapsible sidebar with enabled navigation options and responsive behavior by breakpoint.

#### Scenario: User collapses sidebar on desktop
- **WHEN** the user activates collapse control on desktop view
- **THEN** the sidebar MUST collapse to a compact state and main content width MUST expand accordingly

#### Scenario: Sidebar overlays on smaller screens
- **WHEN** viewport width is below configured mobile/tablet breakpoint
- **THEN** sidebar navigation MUST open as an overlay/drawer and close after navigation selection

### Requirement: Footer Presence and Layout Stability
The system SHALL provide a footer within the shell that does not obstruct page interaction and maintains visual structure.

#### Scenario: Footer remains non-overlapping
- **WHEN** content length is short or long
- **THEN** footer MUST remain visually stable and MUST NOT overlap interactive content