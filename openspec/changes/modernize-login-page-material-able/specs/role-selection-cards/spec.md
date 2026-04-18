## ADDED Requirements

### Requirement: Role Selection Card Component
The role selection section SHALL display each role (Maker, Checker, Admin) as a Material UI Card component with title, icon, description, and action button.

#### Scenario: Role card rendering
- **WHEN** role selection section loads
- **THEN** each of three roles (Maker, Checker, Admin) displays as a separate Material UI Card

#### Scenario: Role card content
- **WHEN** role card is displayed
- **THEN** card shows role name, description text, role icon, and "Login [Role]" action button

### Requirement: Role Card Interactive Styling
Each role card SHALL display elevated shadow and scale up slightly on hover or focus state, indicating interactivity.

#### Scenario: Hover effect on card
- **WHEN** user hovers over a role card
- **THEN** card elevation increases, shadow becomes more pronounced, and cursor changes to pointer

#### Scenario: Focus state on card
- **WHEN** user tabs to a role card via keyboard
- **THEN** card displays focus outline and visual highlight indicating keyboard focus

### Requirement: Role Icon Display
Each role card SHALL display a relevant Material UI icon:
- Maker: AccountTree icon
- Checker: AssignmentTurnedIn icon  
- Admin: ManageAccounts icon

#### Scenario: Maker role icon
- **WHEN** Maker role card renders
- **THEN** AccountTree icon displays in green color

#### Scenario: Checker role icon
- **WHEN** Checker role card renders
- **THEN** AssignmentTurnedIn icon displays in green color

#### Scenario: Admin role icon
- **WHEN** Admin role card renders
- **THEN** ManageAccounts icon displays in green color

### Requirement: Role Description Text
Each role card SHALL display a brief helper text describing the role's responsibilities.

#### Scenario: Maker description
- **WHEN** Maker card displays
- **THEN** description reads "Create and maintain new green finance records."

#### Scenario: Checker description
- **WHEN** Checker card displays
- **THEN** description reads "Review submissions and validate pending records."

#### Scenario: Admin description
- **WHEN** Admin card displays
- **THEN** description reads "Approve workflows and manage users/reports."

### Requirement: Role Card Action Button
Each role card SHALL contain a colored button with text "Login [Role]" that triggers navigation to that role's dashboard.

#### Scenario: Login button action
- **WHEN** user clicks "Login [Role]" button
- **THEN** userId and userRole are stored in sessionStorage and user navigates to appropriate route

#### Scenario: Button styling
- **WHEN** role button renders
- **THEN** button displays in success green color with white text using Material UI theming
