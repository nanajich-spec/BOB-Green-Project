## ADDED Requirements

### Requirement: Google login button is removed
The Login page SHALL NOT display a "Log in with Google" button or any OAuth-related login option.

#### Scenario: Login page renders without Google button
- **WHEN** a user visits the `/login` page
- **THEN** there SHALL be no button labelled "Log in with Google" and no "or" divider above it

### Requirement: Sign-up link is removed
The Login page SHALL NOT display a "Don't have an account? Sign up" link or any self-registration prompt.

#### Scenario: Login page renders without sign-up prompt
- **WHEN** a user visits the `/login` page
- **THEN** there SHALL be no text containing "Don't have an account?" or "Sign up"

### Requirement: Mock mode badge is removed globally
The application SHALL NOT display a "Mock mode enabled" badge on any page.

#### Scenario: App renders without mock badge
- **WHEN** any page in the application renders (login or authenticated)
- **THEN** there SHALL be no visible element with the text "Mock mode enabled"

### Requirement: Login form retains core functionality
The Login page SHALL continue to display the Domain ID field, password field, role selection cards, and the "Log in" button.

#### Scenario: Login with valid credentials
- **WHEN** a user enters a domain ID and password and clicks "Log in"
- **THEN** the user SHALL be navigated to the route corresponding to their selected role

#### Scenario: Login validation
- **WHEN** a user clicks "Log in" without entering a domain ID or password
- **THEN** validation error messages SHALL be displayed for the missing fields
