# Green Frontend (React)

## Local runtime

1. Install dependencies:
	- `npm install`
2. Set optional environment values:
	- `REACT_APP_API_BASE=http://localhost:8080/green-project/api/v1`
	- `REACT_APP_ENABLE_MOCK=true`
3. Start the app:
	- `npm start`

The app is served at `http://localhost:3000/greenfinance`.

## API + mock behavior

- Global axios setup is initialized in `src/setupAxios.js`.
- Hardcoded API calls pointing to `/green-project/api/v1` are normalized to `REACT_APP_API_BASE`.
- If backend calls fail and `REACT_APP_ENABLE_MOCK` is not `false`, fallback responses are served from `src/mockApiData.js`.
- A `Mock mode enabled` badge appears in the UI when mock fallback mode is active.

## Validation

- Build check:
  - `npm run build`
- Current status:
  - Frontend build succeeds (with pre-existing ESLint warnings in legacy files).

## UI refresh scope

- Shared visual tokens and global style normalization in `src/index.css`.
- Updated shell styling in `src/App.css`, `src/Header.css`, and `src/Sidebar.css`.
- Updated page/container styling in `src/Login.css`, `src/DataTable.css`, and `src/Maker.css`.
