## Context

The current login page uses a centered card pattern with Material UI components but lacks sophisticated theming and visual hierarchy. The application already has Material UI v7 integrated with `@emotion/react` and `@emotion/styled`. Bank of Baroda branding is minimal. The role selection mechanism uses MUI Accordions but doesn't provide intuitive visual selection. Mobile experience is adequate but not optimized for the Material Able paradigm.

**Current State:**
- Single-container centered card design
- Accordion-based role selection
- Basic form fields with minimal visual feedback
- No decorated sidebar or visual hierarchy
- CSS file (`Login.css`) handles layout and gradients
- Logo container with minimal styling

**System Constraints:**
- React 18 and Material UI v7 ecosystem
- Homepage: `https://noncbsuat.bankofbaroda.co.in/greenfinance/`
- Maintain existing routing structure (`/Maker`, `/verify`, `/admin`)
- Session storage for user details (userId, userRole)
- Support mobile, tablet, and desktop viewports
- No external design system overrides beyond Material UI

## Goals / Non-Goals

**Goals:**
- Design and implement a Material Able-inspired login page with split-screen layout (decorative left sidebar + content right panel)
- Establish Bank of Baroda visual identity throughout login experience (colors, logos, typography)
- Replace all CSS with Material UI theming and sx prop styling
- Enhance role selection UX with interactive Material UI cards instead of accordions
- Implement responsive design that adapts to mobile (<600px), tablet (600-960px), and desktop (>960px) viewports
- Add smooth animations and micro-interactions (hover effects, focus states, icon animations)
- Ensure accessibility compliance (ARIA, keyboard navigation, semantic HTML)

**Non-Goals:**
- Implement actual OAuth/Google sign-in backend integration (placeholder buttons only)
- Change authentication mechanism or session storage structure
- Modify backend API endpoints or response formats
- Create reusable component library for other pages in this phase
- Implement dark mode theme variations (future enhancement)
- Add multi-language support

## Decisions

### Decision 1: Material Able Split-Screen Architecture
**Choice:** Implement a responsive split-screen layout where decorative left sidebar is hidden on mobile (<960px) and revealed as a full-width hero section on desktop.

**Rationale:** Material Able template provides a premium, modern aesthetic. Split-screen is a proven UX pattern for login pages that creates visual hierarchy (decorative vs. functional). Responsive adaptation ensures mobile usability without duplicating logic.

**Alternatives Considered:**
- Single-column responsive layout: Simpler but less visually distinctive
- Persistent left sidebar overlay: Could confuse mobile users; harder to manage z-index
- Alternating layouts (hero on top for mobile, side by side for desktop): More flexible but requires more conditional rendering

### Decision 2: Themed Material UI Colors for Bank of Baroda Identity
**Choice:** Extend `AppThemeProvider` with a new palette configuration featuring Bank of Baroda green (#134B2A or similar), secondary accent (blue), and neutral grays. Apply exclusively to login page initially.

**Rationale:** Bank of Baroda has a distinct green color identity. Using palette theming ensures consistency and allows rapid theme changes. MUI's palette system supports dark/light mode out of the box.

**Alternatives Considered:**
- CSS custom properties: Would require additional CSS file (rejected per requirements)
- Hardcoded color values in sx: Works but creates maintenance burden across components
- Global theme override: Could affect other pages; prefer isolated login styling

### Decision 3: Role Selection Cards Instead of Accordions
**Choice:** Replace Accordion components with Material UI Cards displaying role information, description, and action button. Cards expand on hover/focus with subtle elevation increase and shadow.

**Rationale:** Cards provide better visual affordance for selectable items. Hover/focus states are more discoverable than accordion expand icons. Eliminates unnecessary disclosure hierarchy.

**Alternatives Considered:**
- Keep Accordions: Current implementation; less visually distinctive
- Radio button group: Too compact for role descriptions
- Separate page/modal: Requires navigation; same information available on login

### Decision 4: Remove Login.css Entirely
**Choice:** Convert all Login.css styles to Material UI theming, sx prop, and component-level styles using emotion/styled components when necessary.

**Rationale:** Requirement to use only Material UI. CSS removal ensures single source of truth (Material UI theme). Easier maintenance and consistency.

**Specific Migrations:**
- `.login-page`: Base container becomes a full-height Box with display flex
- Gradient background: Migrate to `sx={{ background: 'linear-gradient(...)' }}`
- `.login-shell`: Remove custom card wrapper; use MUI Card with elevation and sx overrides
- `.login-logo-wrap`: Replace with Box using MUI spacing system and borders

### Decision 5: Responsive Breakpoints for Mobile Layout
**Choice:** Use MUI's breakpoint system to hide left sidebar on <960px (lg breakpoint), show full-width content. On mobile (<600px), switch to single-column with top hero banner.

**Rationale:** Aligns with MUI's design patterns and material design responsive guidelines. Desktop experience unchanged; mobile gets optimized layout.

**Implementation:**
- Desktop (lg+): `display: flex` with left sidebar (40% width) and right panel (60% width)
- Tablet (md-lg): Sidebar hidden, full-width content centered
- Mobile (xs-sm): Full-width centered layout with top hero section

### Decision 6: Animation Framework Using Framer Motion or MUI Transitions
**Choice:** Use MUI's built-in transition utilities (`Fade`, `Slide`, `Grow`) from `@mui/material` for entrance animations. Additional micro-interactions via emotion keyframes if needed.

**Rationale:** MUI transitions are lightweight, already installed via @emotion. No additional dependency. Consistent with Material Design motion principles.

**Implementation:**
- Page entrance: Fade-in animation on load
- Role cards: Subtle scale-up on hover with shadow increase
- Form focus: Smooth border color transition

## Risks / Trade-offs

| Risk | Impact | Mitigation |
|------|--------|-----------|
| Removing CSS may break subtle layout rules | Medium | Test all responsive breakpoints; use MUI debugger to verify box model |
| Split-screen design requires responsive reworking | Medium | Use MUI's responsive sx={{ display: { xs, md, lg } }} to manage visibility |
| Animation performance on low-end devices | Low | Throttle animations; use `prefers-reduced-motion` media query |
| Bank of Baroda brand color consistency | Low | Define colors in theme file; document hex values for QA |
| Material UI bundle size increase | Low | MUI is already a dependency; tree-shaking handles unused components |
| Mobile-first vs desktop-first approach | Low-Medium | Adopt mobile-first (CSS cascading); test on real devices |

## Migration Plan

1. **Phase 1 - Preparation**: Update theme config with Bank of Baroda brand colors; create new Login.js component importing MUI components only
2. **Phase 2 - Component Refactor**: Rebuild form controls, role cards, buttons with MUI equivalents; remove all className references to Login.css
3. **Phase 3 - Responsive Design**: Implement breakpoint logic; test on mobile, tablet, desktop; adjust spacing/sizing as needed
4. **Phase 4 - Animations & Polish**: Add entrance animations, hover effects, form validation feedback
5. **Phase 5 - Accessibility Audit**: Verify ARIA labels, keyboard navigation, contrast ratios; run axe accessibility scan
6. **Phase 6 - QA & Rollout**: Screenshot comparison, functional testing, UAT on staging environment; deploy to production

**Rollback Strategy:** Login.css remains in git history. If critical issues arise post-deployment, revert Login.js to previous version (before CSS removal); restore Login.css from git.

## Open Questions

- Should we implement Google OAuth placeholder buttons, or just display them for future integration?
- Are there specific Bank of Baroda brand guidelines (primary/secondary colors, logo specifications) we should follow beyond the green color?
- Should the left sidebar display different content (bank tagline, features, security badges) or remain a decorative graphic?
- Do we need to support any additional languages or RTL layout for international use?
- Should we implement remember-me functionality with local storage, or keep it as a UI-only checkbox?
