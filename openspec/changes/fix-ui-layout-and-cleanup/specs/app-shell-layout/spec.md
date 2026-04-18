## ADDED Requirements

### Requirement: Shared AppShell wraps all authenticated pages
The system SHALL render a single `AppShell` component that contains the Header, Sidebar, and a content outlet for every route except `/login`.

#### Scenario: Navigating between authenticated pages
- **WHEN** a user navigates from the Pending page to the User Management page
- **THEN** the Header and Sidebar SHALL remain mounted without re-rendering, and only the content area SHALL update

#### Scenario: Login page has no shell
- **WHEN** a user visits the `/login` route
- **THEN** the AppShell (Header, Sidebar, Footer) SHALL NOT be rendered

### Requirement: Header is fixed to viewport top
The system SHALL render the Header with `position: fixed` so it remains visible at all scroll positions within any page.

#### Scenario: Scrolling a long data table page
- **WHEN** a user scrolls down on the Report or User Management page
- **THEN** the Header SHALL remain fixed at the top of the viewport and SHALL NOT scroll out of view

#### Scenario: Content does not hide behind the header
- **WHEN** any authenticated page renders
- **THEN** the content area top edge SHALL begin below the header (offset by header height) so no content is hidden behind it

### Requirement: Content area does not overlap with sidebar
The system SHALL offset the main content area by the current sidebar width so that content is never hidden behind or overlapping the sidebar.

#### Scenario: Sidebar expanded
- **WHEN** the sidebar is in its expanded state (260 px)
- **THEN** the content area left edge SHALL start at 260 px from the viewport left

#### Scenario: Sidebar collapsed
- **WHEN** the sidebar is in its collapsed state (88 px)
- **THEN** the content area left edge SHALL start at 88 px from the viewport left

#### Scenario: Sidebar transition
- **WHEN** the sidebar transitions between collapsed and expanded states
- **THEN** the content area SHALL smoothly transition its left offset without layout jumps

### Requirement: Sidebar collapse toggle is inside the sidebar
The system SHALL place the sidebar collapse/expand toggle button inside the sidebar component, not in the header.

#### Scenario: Desktop view toggle location
- **WHEN** the application is viewed on a desktop screen (≥ 960 px)
- **THEN** a collapse/expand icon button SHALL be visible inside the sidebar (near the "Navigation" label or at the bottom) and SHALL NOT appear in the header

#### Scenario: Mobile view hamburger stays in header
- **WHEN** the application is viewed on a mobile screen (< 960 px)
- **THEN** a hamburger menu icon SHALL appear in the header to open the temporary sidebar drawer

### Requirement: Logo is displayed at an increased size
The system SHALL render the Bank of Baroda logo in the header at a minimum size of 56×56 px (up from 48×48 px).

#### Scenario: Header logo dimensions
- **WHEN** the header renders on a desktop screen
- **THEN** the logo container SHALL be at least 56 px wide and 56 px tall

### Requirement: Pages do not individually import Header or Sidebar
No authenticated page component SHALL directly import or render `<Header />` or `<Sidebar />`. These SHALL only be rendered by the `AppShell`.

#### Scenario: UserManagement page structure
- **WHEN** the UserManagement component renders
- **THEN** it SHALL NOT contain `<Header />` or `<Sidebar />` elements in its JSX — only its own content

#### Scenario: Admin_c (Report) page structure
- **WHEN** the Admin_c component renders
- **THEN** it SHALL NOT contain `<Header />` or `<Sidebar />` elements in its JSX — only its own content
