## Why

The current login page lacks visual sophistication and doesn't fully leverage Material Design principles. Users encounter a basic centered card design that doesn't convey the modern, professional nature of the Green Project financing platform. By adopting a Material Able-inspired split-screen design pattern with enhanced theming and Bank of Baroda branding, we can deliver a world-class first impression that builds user confidence, improves perceived platform quality, and establishes a strong visual foundation for the entire application.

## What Changes

- Redesign login page with Material Able template pattern: decorative left sidebar with gradient, icons, and brand visualization, plus content-focused right panel
- Implement advanced Material UI components exclusively (card shadows, smooth animations, responsive breakpoints, elevation hierarchy)
- Integrate Bank of Baroda brand identity with logos, colors, and typography throughout the login experience
- Remove all CSS-based styling; convert to Material UI theming and `sx` prop for complete design consistency
- Add sophisticated UI elements: animated icons, interactive role selection cards (replacing accordions), form validation indicators, social login buttons (Google OAuth placeholder)
- Enhance mobile responsiveness with drawer-based layout for small screens instead of stacked content
- Implement smooth transitions, hover effects, and focus states using Material UI motion utilities
- Display application name as "Green Project" with Bank of Baroda attribution and professional footer with social media links

## Capabilities

### New Capabilities

- `material-able-login-design`: Split-screen Material Able-inspired login page with decorative left sidebar and main content panel
- `advanced-form-controls`: Enhanced form inputs with Material UI styling, validation states, and visual feedback
- `bank-branding-integration`: Bank of Baroda logo, color scheme, and brand identity applied throughout login experience
- `responsive-mobile-login`: Mobile-optimized login with drawer navigation and stacked layouts for screens under 768px
- `role-selection-cards`: Interactive Material UI cards for role selection with descriptions, icons, and action buttons
- `social-auth-buttons`: Google OAuth and social login button components with Material Design styling
- `login-animations`: Smooth entrance animations, icon transitions, and interactive state changes
- `accessibility-enhancements`: ARIA labels, keyboard navigation, focus management, and semantic HTML structure

### Modified Capabilities

- `application-theme-system`: Extend existing theme with new brand colors (Bank of Baroda green palette), enhanced breakpoints for split-screen layout, and new component configurations

## Impact

- **Frontend Code**: Login.js and Login.css completely refactored; Login.css removed entirely
- **Theme System**: Enhanced AppThemeProvider with bank-specific color tokens and new typography variants
- **Dependencies**: May require `@mui/lab` for additional advanced components (Masonry, Timeline, etc.)
- **Breaking Changes**: Login page URL/props remain the same, but visual redesign may require updated QA test screenshots
- **Browser Support**: Maintained across all modern browsers (Material UI v7 support)
- **Performance**: Slight initial bundle increase from new animations, mitigated by Material UI's tree-shaking
