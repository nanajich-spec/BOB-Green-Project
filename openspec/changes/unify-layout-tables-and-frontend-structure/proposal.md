## Why

The frontend currently has inconsistent layout behavior, fragmented styling, and weak dark-mode readability across pages, which makes operations harder for Maker, Checker, and Admin users. This change is needed now to establish a stable, maintainable UI baseline before further feature development.

## What Changes

- Implement a global fixed-shell layout so header and footer remain visible while only the main content area scrolls.
- Standardize page spacing, typography scale, and responsive sizing across all core pages (Maker, Checker, Admin, and shared data screens).
- Introduce a reusable generic table styling system with modern width behavior, consistent density, and improved readability.
- Correct dark-mode table/content contrast issues where white text/background combinations reduce visibility.
- Consolidate scattered CSS into shared, generic style layers and remove redundant per-page CSS files where possible.
- Restructure frontend folders and naming conventions to improve discoverability, debugging, and long-term maintainability.

## Capabilities

### New Capabilities
- `global-app-shell-layout`: Provides a fixed header/footer shell with scrollable main content and consistent viewport behavior across pages.
- `unified-table-system`: Provides reusable table primitives for sizing, typography, spacing, overflow, and responsive width handling.
- `theme-safe-data-contrast`: Enforces readable table/body contrast in both light and dark modes.
- `frontend-structure-standardization`: Defines organized folders and shared style architecture for easier debugging and extension.

### Modified Capabilities
- None.

## Impact

- Affected frontend code in `Green_test/Green_test/src/` including shared layout components, page containers, and table rendering components.
- Significant CSS refactor impact: migration from duplicated page-level styles to shared generic style modules.
- No expected backend API contract changes.
- Build/test scope includes regression checks for layout persistence, dark-mode readability, and table rendering across Maker/Checker/Admin paths.
