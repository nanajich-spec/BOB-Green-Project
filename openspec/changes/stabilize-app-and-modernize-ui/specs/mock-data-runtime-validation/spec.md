## ADDED Requirements

### Requirement: Backend provides deterministic local seed data
The system SHALL provide deterministic mock records for critical business entities when running in local development mode.

#### Scenario: Seed on startup in local mode
- **WHEN** the backend starts with local mock-data mode enabled
- **THEN** the system initializes a known baseline dataset required by frontend feature screens

### Requirement: Frontend supports local validation against seeded data
The frontend SHALL run against the backend and render seeded records in core pages without runtime errors.

#### Scenario: Feature pages render with seeded API responses
- **WHEN** a user opens key feature routes in the local environment
- **THEN** each route loads using seeded backend data and displays non-empty, valid UI states

### Requirement: Local run workflow is documented and reproducible
The project SHALL document commands and prerequisites to start backend/frontend and validate core features.

#### Scenario: New developer follows documented steps
- **WHEN** a developer follows the run-and-verify instructions in repository docs
- **THEN** the full application starts successfully and core feature checks pass in local setup