## Context

The repository contains a Java backend (`green-project`) and a React frontend (`Green_test/Green_test`). Current implementation has multiple feature pages and role-focused screens, but lacks a guaranteed repeatable local workflow to run and validate all major flows with representative data. The UI is functional but visually inconsistent due to fragmented styling across many component-specific CSS files.

## Goals / Non-Goals

**Goals:**
- Establish deterministic backend mock data initialization for local/dev verification.
- Ensure frontend can run against backend with practical test data and basic end-to-end validation steps.
- Modernize shared UI styling and layout primitives while preserving existing behavior.
- Deliver incremental implementation through OpenSpec tasks with verifiable checkpoints.

**Non-Goals:**
- Re-architect backend domain model or replace existing API contracts.
- Rewrite frontend routing/business logic from scratch.
- Introduce a new design system framework that requires full component rewrites.

## Decisions

1. Add controlled mock data seeding in backend startup path for local profile.
   - Rationale: Keeps API contracts stable while guaranteeing data availability.
   - Alternative considered: Frontend-only static mocks. Rejected because it bypasses backend integration.

2. Add a lightweight frontend API failover mode and test fixtures for key screens.
   - Rationale: Allows local validation when backend is unavailable and helps UI testing.
   - Alternative considered: Hard dependency on backend uptime for all frontend checks. Rejected due to slower iteration.

3. Apply a modern UI refresh by introducing shared tokens/utilities and updating core shell components first (`App`, header/sidebar/navigation containers), then major pages.
   - Rationale: Improves consistency with controlled risk.
   - Alternative considered: Full redesign in one pass. Rejected as too risky for regression and scope.

## Risks / Trade-offs

- [Risk] Mock seed data diverges from production realism → Mitigation: keep fixtures representative and documented; isolate to local/dev profile.
- [Risk] Styling changes break page layouts → Mitigation: update shell first, then page-level checks per route.
- [Risk] Existing CSS specificity conflicts with new tokens → Mitigation: introduce shared variables and refactor gradually.

## Migration Plan

1. Add backend seed mechanism and local config toggle.
2. Add frontend environment wiring and mock fallback where needed.
3. Validate app startup path for backend and frontend.
4. Apply UI modernization incrementally across shared shell and feature pages.
5. Document run/test steps for local use.

Rollback: disable mock seed toggle and revert styling commits per component group if regressions appear.

## Open Questions

- Which exact user journeys are mandatory for “all features” acceptance in this repository version?
- Should mock mode be default in local profile or opt-in via property/env flag?
- Are there brand/style constraints beyond “modern look and feel” for colors/typography?