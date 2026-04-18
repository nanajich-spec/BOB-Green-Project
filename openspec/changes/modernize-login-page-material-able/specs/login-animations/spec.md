## ADDED Requirements

### Requirement: Page Entrance Animation
The login page SHALL animate in smoothly on initial load using Material UI Fade transition.

#### Scenario: Page load animation
- **WHEN** login page initially renders
- **THEN** entire page fades in over 500-600ms with smooth easing

### Requirement: Role Card Hover Animation
Role selection cards SHALL display subtle scale-up animation and shadow increase on hover state.

#### Scenario: Card hover scale
- **WHEN** user hovers over a role card
- **THEN** card scales to 1.02x its original size and shadow elevation increases

#### Scenario: Animation timing
- **WHEN** user hovers over role card
- **THEN** animation transitions smoothly over 200-300ms with standard material easing

### Requirement: Form Field Focus Animation
Form input fields SHALL display smooth border color and background color transitions when focused.

#### Scenario: Text field focus
- **WHEN** user clicks a form input field
- **THEN** field border smoothly transitions to theme primary color and background adjusts color

#### Scenario: Focus animation timing
- **WHEN** input field receives focus
- **THEN** focus transition completes in 200ms with smooth easing curve

### Requirement: Icon Animation
Decorative icons in left sidebar and role cards SHALL have subtle animations (fade, rotate, pulse) on page load.

#### Scenario: Sidebar icon animation
- **WHEN** page loads
- **THEN** decorative icons in left sidebar fade in sequentially with staggered timing (50-100ms between each)

#### Scenario: Role icon animation
- **WHEN** role cards render
- **THEN** role icons have subtle pulse effect indicating interactivity

### Requirement: Button Press Ripple Effect
Material UI buttons SHALL display ripple effect on click using MUI's built-in ripple animation.

#### Scenario: Login button ripple
- **WHEN** user clicks a "Login [Role]" button
- **THEN** ripple animation radiates from click point across button surface

### Requirement: Transition Performance Optimization
All animations SHALL use CSS transforms and opacity for optimal performance on low-end devices.

#### Scenario: GPU-accelerated animation
- **WHEN** page animations run
- **THEN** animations use only transform, opacity, and scale properties (never top/left/width/height)

#### Scenario: Reduced motion accessibility
- **WHEN** user has `prefers-reduced-motion` enabled in browser
- **THEN** animations are disabled or greatly reduced in duration for accessibility compliance
