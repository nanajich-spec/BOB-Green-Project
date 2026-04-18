## ADDED Requirements

### Requirement: Semantic HTML Structure
The login page SHALL use semantic HTML elements (main, form, section) with proper heading hierarchy (h1 for title, h2 for sections).

#### Scenario: Page semantic structure
- **WHEN** page renders
- **THEN** login form uses `<form>` element, main content uses `<main>`, and sections use `<section>` elements

#### Scenario: Heading hierarchy
- **WHEN** page loads
- **THEN** "Green Project" uses h1, section titles use h2, and no heading levels are skipped

### Requirement: ARIA Labels and Descriptions
Form inputs, buttons, and interactive elements SHALL include appropriate ARIA labels or descriptions for screen readers.

#### Scenario: Form field ARIA labels
- **WHEN** Domain ID and Password fields render
- **THEN** each field has aria-label or associated label element with clear description

#### Scenario: Button ARIA labels
- **WHEN** buttons render without text (icon-only buttons)
- **THEN** buttons include aria-label describing their function

#### Scenario: Role requirement for interactive elements
- **WHEN** interactive components render
- **THEN** components have proper role attributes (button, checkbox, link)

### Requirement: Keyboard Navigation Support
The login page SHALL be fully navigable using only keyboard (Tab, Enter, Arrow keys) without requiring mouse input.

#### Scenario: Tab navigation order
- **WHEN** user presses Tab
- **THEN** focus moves through form inputs, buttons, and links in logical reading order

#### Scenario: Enter key activation
- **WHEN** user focuses on button and presses Enter
- **THEN** button action is triggered

#### Scenario: Space key activation
- **WHEN** user focuses on checkbox and presses Space
- **THEN** checkbox state toggles

### Requirement: Focus Indicators
All interactive elements SHALL display visible focus indicators when focused via keyboard, with sufficient contrast.

#### Scenario: Form field focus outline
- **WHEN** form field receives keyboard focus
- **THEN** focus outline is visible with contrast ratio >= 3:1 against background

#### Scenario: Button focus state
- **WHEN** button receives keyboard focus
- **THEN** button displays visible focus indicator (outline or highlight) meeting WCAG contrast requirements

### Requirement: Color Contrast Compliance
Text and interactive elements SHALL meet WCAG AA color contrast requirements (4.5:1 for text, 3:1 for graphics).

#### Scenario: Heading contrast
- **WHEN** "Green Project" heading displays
- **THEN** text contrast ratio >= 4.5:1 against background

#### Scenario: Button contrast
- **WHEN** action buttons display
- **THEN** button text contrast ratio >= 4.5:1 against button background

#### Scenario: Form label contrast
- **WHEN** form labels display
- **THEN** label text contrast >= 4.5:1 against page background

### Requirement: Alternative Text for Images
All images SHALL include descriptive alt text for screen reader users.

#### Scenario: Logo alt text
- **WHEN** Bank of Baroda logo displays
- **THEN** image has alt="Bank of Baroda Logo" or descriptive text

#### Scenario: Icon alt text
- **WHEN** decorative icons display
- **THEN** icons either have aria-hidden="true" if decorative, or descriptive aria-label if meaningful

### Requirement: Error Message Association
Error messages SHALL be associated with their corresponding form fields using aria-describedby or aria-invalid attributes.

#### Scenario: Field error messaging
- **WHEN** form field validation fails
- **THEN** error message is announced to screen readers and associated with field using aria-describedby

#### Scenario: Invalid state indication
- **WHEN** form field has validation error
- **THEN** field has aria-invalid="true" and appropriate visual indicator beyond color alone
