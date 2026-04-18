## Why

The current full-stack application cannot be reliably validated end-to-end because it lacks a consistent mock-data strategy and clear startup verification steps. At the same time, the frontend UI is dated and inconsistent, which reduces usability and makes future feature work harder.

## What Changes

- Add a reproducible local run path for backend and frontend with seeded mock data.
- Add verification coverage for critical application flows using the mock-data setup.
- Modernize frontend visual design across pages using a consistent style system and updated layout patterns.
- Preserve current business behavior while improving presentation and usability.

## Capabilities

### New Capabilities
- `mock-data-runtime-validation`: Provide deterministic mock data and startup/test workflow so the app can be run and validated locally.
- `modern-frontend-ui-refresh`: Provide a consistent, modern look-and-feel across the React frontend without changing core business logic.

### Modified Capabilities
- None.

## Impact

- Affected code: `green-project` backend config/controllers/services for mock or dev data behavior; `Green_test/Green_test/src` React components and styles.
- APIs: No intentional contract breaks; responses may include seeded sample records in development mode.
- Dependencies: Possible additions for UI styling/utilities and frontend test support.
- Systems: Local developer workflow for run/verify steps will be updated.
