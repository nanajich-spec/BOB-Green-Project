## 1. Theme Configuration and Bank Branding

- [x] 1.1 Update AppThemeProvider to extend MUI theme with Bank of Baroda green (#134B2A) as primary color
- [x] 1.2 Define secondary color (blue accent), success color (green), and neutral palette (grays) in theme configuration
- [x] 1.3 Add typography system configuration (headings, body, captions) to theme provider
- [x] 1.4 Configure responsive breakpoints (xs, sm, md, lg, xl) in MUI theme breakpoints
- [x] 1.5 Create semantic color tokens in theme palette (success, warning, error, info) aligned to Bank of Baroda branding

## 2. Login Page Refactor - Layout Foundation

- [x] 2.1 Refactor Login.js to remove all className references to Login.css
- [x] 2.2 Create split-screen layout structure using Material UI Box with display flex (40% sidebar / 60% content on desktop)
- [x] 2.3 Implement responsive breakpoint logic to hide sidebar on <960px viewports
- [x] 2.4 Refactor content panel to use Material UI Card with MUI elevation, rounded corners, and responsive padding via sx prop
- [x] 2.5 Remove Login.css file from project (after verifying all styles migrated)

## 3. Decorative Left Sidebar Implementation

- [x] 3.1 Create left sidebar Box component with gradient background using Bank of Baroda green theme
- [x] 3.2 Add gradient background-image CSS via sx prop (linear-gradient with theme colors)
- [x] 3.3 Import or create decorative SVG icons (lightning bolt, coins, documents, etc.) for sidebar display
- [x] 3.4 Position icons using Material UI Grid or Stack with responsive spacing
- [x] 3.5 Implement sidebar visibility logic: hidden on <960px breakpoint using display: { xs: 'none', lg: 'flex' }
- [x] 3.6 Apply Bank of Baroda brand text or tagline to sidebar (optional, based on design team input)

## 4. Logo and Header Branding

- [x] 4.1 Update Bank of Baroda logo image path imported from project assets
- [x] 4.2 Create logo container using Material UI Box with white background, border, and responsive padding
- [x] 4.3 Update image styling to use sx prop for width, max-height, object-fit (remove from CSS)
- [x] 4.4 Update page title "Green Project" styling with Bank of Baroda primary green color, fontWeight 800, and text underline via sx
- [x] 4.5 Add subtitle "Secure access for Maker, Checker and Admin roles" with secondary color

## 5. Form Fields Migration to Material UI

- [x] 5.1 Replace TextField components with fullWidth version and ensure Material UI v7 defaults apply
- [x] 5.2 Update Domain ID input TextField with label, placeholder, maxLength constraint, and responsive variant
- [x] 5.3 Update Password input TextField with type="password", label, placeholder, and responsive variant
- [x] 5.4 Add visual error states to TextFields using helperText and error props for validation feedback
- [x] 5.5 Implement Form-level error handling and display validation messages below respective fields
- [x] 5.6 Update TextField styling to use MUI theme colors and remove any inline CSS

## 6. Advanced Form Controls

- [x] 6.1 Create Remember Me checkbox using Material UI Checkbox component with FormControlLabel label
- [x] 6.2 Position Remember Me checkbox and Forgot Password link in a Stack above role selection section
- [x] 6.3 Create Forgot Password link as Material UI Link component (placeholder for future implementation)
- [x] 6.4 Implement focus states and hover effects for checkbox and link using MUI's built-in interactions
- [x] 6.5 Update form field spacing using Material UI Stack with consistent gap values from theme

## 7. Role Selection Cards Implementation

- [x] 7.1 Replace Accordion-based role selection with Material UI Card components (remove Accordion imports)
- [x] 7.2 Create individual Card component for each role (Maker, Checker, Admin) with CardContent wrapper
- [x] 7.3 Add role icon using Material UI icons (AccountTreeIcon for Maker, AssignmentTurnedInIcon for Checker, ManageAccountsIcon for Admin)
- [x] 7.4 Add role title, description text, and role badge (Chip) to each Card
- [x] 7.5 Implement "Login [Role]" Button as Material UI Button with color="success" inside each Card
- [x] 7.6 Add hover elevation effect to Cards via sx prop (elevation: { default: 1, hover: 4 })
- [x] 7.7 Implement onClick handler for role buttons to store userId/userRole in sessionStorage and navigate to appropriate route

## 8. Social Login Buttons

- [x] 8.1 Create "Login with Google" button using Material UI Button with variant="outlined"
- [x] 8.2 Add Google logo or icon to button using Material UI icon or image component
- [x] 8.3 Implement placeholder onClick handler that shows tooltip "Coming soon - OAuth integration in progress"
- [x] 8.4 Add social media footer links (Twitter, Facebook, Instagram, LinkedIn) using Material UI Link components
- [x] 8.5 Position social media icons in horizontal Stack with responsive spacing
- [x] 8.6 Make social links open in new tabs with target="_blank" and rel="noopener noreferrer"

## 9. Animations and Transitions

- [x] 9.1 Import Material UI Fade component for page entrance animation
- [x] 9.2 Wrap login page content in Fade component with timeout={600} for smooth entrance on load
- [x] 9.3 Add role card hover animation using sx prop with transition and transform scale (1.02x on hover)
- [x] 9.4 Implement form field focus animation with smooth border color transition via sx transition prop
- [x] 9.5 Add icon animations in sidebar using keyframes animation via emotion styled components
- [x] 9.6 Ensure all animations use CSS transforms (scale, translate) and opacity for GPU acceleration
- [x] 9.7 Implement prefers-reduced-motion media query support to disable animations for accessibility

## 10. Responsive Design and Mobile Layout

- [ ] 10.1 Test split-screen layout at desktop (>960px), tablet (600-960px), and mobile (<600px) viewports
- [ ] 10.2 Verify sidebar hides correctly on <960px breakpoint and content expands to full width
- [ ] 10.3 Implement responsive padding for content panel: xs: 2.5, sm: 3.5 via theme spacing system
- [ ] 10.4 Ensure form fields remain full-width on all breakpoints and stack vertically
- [ ] 10.5 Verify buttons maintain appropriate sizing on mobile without layout breakage
- [ ] 10.6 Test role card layout on mobile - may stack vertically or scroll horizontally
- [ ] 10.7 Validate logo and header sizing on mobile screens
- [ ] 10.8 Test all interactive elements (inputs, buttons, checkboxes) are easily tappable on mobile (>44x44px touch targets)

## 11. Accessibility Implementation

- [x] 11.1 Add semantic HTML structure: use <form> for login form, <main> for main content, <section> for sections
- [x] 11.2 Implement proper heading hierarchy: h1 for "Green Project", h2 for section titles
- [x] 11.3 Add aria-label attributes to all form inputs (Domain ID, Password) and buttons
- [x] 11.4 Add aria-describedby to form fields for error message association
- [x] 11.5 Implement aria-invalid="true" attribute on TextField components when validation fails
- [x] 11.6 Ensure all interactive elements have visible focus indicators with contrast ratio >= 3:1
- [x] 11.7 Add alt text to Bank of Baroda logo image: alt="Bank of Baroda Logo"
- [x] 11.8 Add aria-hidden="true" to decorative icons in sidebar (if purely decorative)
- [ ] 11.9 Test keyboard navigation: Tab through all inputs, buttons, and links in logical order
- [ ] 11.10 Verify form submission works with keyboard only (Enter key on buttons)
- [ ] 11.11 Verify color contrast compliance: headings >= 4.5:1, buttons >= 4.5:1, text >= 4.5:1

## 12. Testing and Validation

- [x] 12.1 Run npm build and resolve any TypeScript/JSX errors
- [ ] 12.2 Start development server and visually test login page on desktop (Chrome, Firefox, Safari)
- [ ] 12.3 Test responsive breakpoints using browser DevTools (mobile 375px, tablet 768px, desktop 1280px)
- [ ] 12.4 Verify form field validation and error messages display correctly
- [ ] 12.5 Test all buttons navigate to correct routes (Maker, Checker, Admin)
- [ ] 12.6 Verify sessionStorage userId and userRole are set correctly on role selection
- [ ] 12.7 Test hover and focus states on all interactive elements
- [ ] 12.8 Test animations play smoothly without jank or performance degradation
- [x] 12.9 Verify no CSS class references to Login.css remain in application
- [ ] 12.10 Run accessibility audit using axe/Lighthouse and fix any identified issues
- [ ] 12.11 Test on real mobile device (iOS and Android) for touch interactions and layout

## 13. Cleanup and Documentation

- [x] 13.1 Delete Login.css file from src directory
- [x] 13.2 Remove all CSS-related imports from Login.js (verify none remain)
- [ ] 13.3 Update any component documentation or comments to reflect Material UI styling approach
- [ ] 13.4 Create or update UI_MODERNIZATION_ROLLOUT_CHECKLIST.md with login page completion details
- [ ] 13.5 Generate before/after screenshots for QA verification and documentation
- [x] 13.6 Test production build (`npm run build`) and verify bundle size is acceptable
- [ ] 13.7 Verify deployed login page matches design mockups on staging environment

## 14. Browser and Cross-Device Testing

- [ ] 14.1 Test on Chrome desktop (latest version)
- [ ] 14.2 Test on Firefox desktop (latest version)
- [ ] 14.3 Test on Safari desktop (latest version)
- [ ] 14.4 Test on Chrome mobile (iOS and Android)
- [ ] 14.5 Test on Safari mobile (iOS)
- [ ] 14.6 Verify print styles (if applicable) via browser print preview
- [ ] 14.7 Test with browser zoom levels (75%, 100%, 125%, 150%) to ensure layout stability

## 15. Post-Implementation Review

- [ ] 15.1 Verify all spec requirements are met and mark specs as implemented
- [ ] 15.2 Update existing UI_MODERNIZATION_INVENTORY.md with new components and styling approach
- [ ] 15.3 Obtain stakeholder sign-off (design team, QA, product management)
- [ ] 15.4 Schedule deployment to production and notify users of UI updates
- [ ] 15.5 Monitor production for any user-reported issues or bugs related to login page
