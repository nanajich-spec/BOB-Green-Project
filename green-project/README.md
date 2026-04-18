# Green Backend (Spring Boot)

## Local mock-data profile

This project now supports a local profile with deterministic mock seeding.

### Run locally

Use a Spring profile that activates H2 + seeding:

- `spring.profiles.active=local`
- `app.mock.seed.enabled=true`

Equivalent command (if Maven is available):

- `mvn spring-boot:run -Dspring-boot.run.profiles=local`

## What local profile does

- Switches datasource to in-memory H2 (`application-local.properties`).
- Keeps context path at `/green-project`.
- Seeds representative records at startup via `DevMockDataSeeder` when mock seed is enabled.

Seeded entities include:

- `UserMaster`
- `User`
- `LoanDetails`
- `DepositDetails`

## Notes

- Default `application.properties` remains Oracle-oriented and sets `app.mock.seed.enabled=false`.
- Local seed is isolated by profile and conditional property.
