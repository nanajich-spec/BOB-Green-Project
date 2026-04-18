# UI Modernization Rollout Checklist

## Before/After Visual Verification Notes
- Header modernized with logo, theme toggle, profile chip, and logout control.
- Sidebar modernized with role-aware navigation, desktop collapse mode, and mobile drawer mode.
- Footer is fixed and persistent for authenticated screens.
- Main content scroll is isolated to the shell content area (`AppShell`) instead of full-document scroll.
- Generic table style layers now drive active Admin/Checker/return-table pages.
- Dark-mode tokens are applied through `data-theme` attributes from `AppThemeProvider`.

## Role-Based Smoke Checklist
- [ ] Login as Admin and verify `Pending`, `User Management`, `Report`, `Loan Dashboard`, `Deposit Position`, `Risk Assessment` links.
- [ ] Login as Checker and verify `Pending`/`Verified` filters in sidebar navigation.
- [ ] Login as Maker and verify `New Record` and `Existing Records` submenu navigation.
- [ ] Verify dark/light mode switch persists after refresh.
- [ ] Verify profile chip and logout action on all authenticated pages.
- [ ] Verify mobile drawer open/close and desktop collapse behavior.

## Responsive Verification Matrix
- [ ] Desktop (>=1200px): no overlap in Admin, Maker, Checker, LoanData, DepositData, UserManagement.
- [ ] Tablet (768px-1199px): content reflow and sidebar behavior correct.
- [ ] Mobile (<768px): drawer navigation and table overflow handling usable.

## Rollout Notes
- Build now succeeds after CSS parser/minifier blockers were fixed (`ProjectSpecificIndicator.css` embedded script removed, responsive utility selector escaped).
- Existing lint warnings are largely pre-existing in legacy files and should be addressed in a separate cleanup change.
