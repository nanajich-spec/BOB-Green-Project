## ADDED Requirements

### Requirement: Consistent base font size across all pages
The application SHALL use a base body font size of 14 px and table cell font size of 13 px across all pages.

#### Scenario: Table text on User Management page
- **WHEN** the User Management page renders its data table
- **THEN** all table cell text SHALL be rendered at 13 px font size

#### Scenario: Body text on any authenticated page
- **WHEN** any authenticated page renders
- **THEN** paragraph and label text SHALL be rendered at 14 px font size

### Requirement: Consistent content padding
The main content area inside the AppShell SHALL apply uniform padding (24 px on all sides) so that all pages have the same gutter between content and the edges of the viewport.

#### Scenario: Report page content padding
- **WHEN** the Report page renders inside the AppShell
- **THEN** its content SHALL have 24 px padding on all sides

#### Scenario: User Management page content padding
- **WHEN** the User Management page renders inside the AppShell
- **THEN** its content SHALL have 24 px padding on all sides

### Requirement: Tables occupy full available width
All PrimeReact DataTable and MUI Table components SHALL expand to 100% of their parent container width without overflowing the viewport.

#### Scenario: Report data table width
- **WHEN** the Report page renders its data table with the sidebar expanded
- **THEN** the table SHALL fill the available horizontal space between sidebar and viewport edge, without horizontal scrollbar appearing for normal column counts

#### Scenario: User Management data table width
- **WHEN** the User Management page renders its data table
- **THEN** the table SHALL fill the available horizontal space without overlapping the sidebar

### Requirement: No commented-out legacy code in source files
All large blocks of commented-out legacy code (old Sidebar, old UserManagement, unused CSS) SHALL be removed from source files.

#### Scenario: Sidebar.js has no legacy comments
- **WHEN** a developer opens `Sidebar.js`
- **THEN** there SHALL be no block of commented-out code longer than 5 lines from the old class-based sidebar implementation

#### Scenario: UserManagement.js has no legacy comments
- **WHEN** a developer opens `UserManagement.js`
- **THEN** there SHALL be no block of commented-out code longer than 5 lines from the old UserManagement implementation

### Requirement: Responsive layout at mobile breakpoints
On screens narrower than 960 px, the sidebar SHALL become a temporary overlay drawer and the content area SHALL use the full viewport width.

#### Scenario: Mobile view layout
- **WHEN** the viewport width is below 960 px
- **THEN** the sidebar SHALL not consume permanent horizontal space and the content area SHALL span the full viewport width

### Requirement: Consistent card and section styling
All card components (PrimeReact Card, MUI Card) SHALL use consistent border-radius (8 px), shadow depth, and internal padding (16 px) across all pages.

#### Scenario: User Management card styling
- **WHEN** the User Management page renders its card container
- **THEN** the card SHALL have 8 px border-radius, a subtle shadow, and 16 px internal padding

#### Scenario: Report card styling
- **WHEN** the Report page renders its card container
- **THEN** the card SHALL have 8 px border-radius, a subtle shadow, and 16 px internal padding
