## ADDED Requirements

### Requirement: Social Login Button Components
The login form SHALL display "Login with Google" button providing visual placeholder for future OAuth integration.

#### Scenario: Google login button display
- **WHEN** login form loads
- **THEN** "Login with Google" button is visible below the role selection section

#### Scenario: Google button styling
- **WHEN** Google button renders
- **THEN** button displays Google logo, text, and Material UI standard button styling with appropriate hover state

### Requirement: Social Login Button Functionality Placeholder
Social login buttons SHALL be rendered but functionality is disabled pending backend OAuth implementation.

#### Scenario: Disabled social button state
- **WHEN** user clicks Google login button
- **THEN** a tooltip or alert message displays "Coming soon - OAuth integration in progress" and no navigation occurs

#### Scenario: Button accessibility
- **WHEN** user navigates to Google button via keyboard
- **THEN** button is properly focused and tooltip becomes visible on focus

### Requirement: Social Media Footer Links
The login footer SHALL display social media icons (Twitter, Facebook, Instagram, LinkedIn) as links to Bank of Baroda social media profiles.

#### Scenario: Social media icons display
- **WHEN** login page footer renders
- **THEN** five social media icons appear in a horizontal stack

#### Scenario: Social media link targets
- **WHEN** user clicks a social media icon
- **THEN** appropriate social media profile opens in new tab (placeholder URLs for non-implemented profiles)
