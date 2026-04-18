// API Endpoints
export const API_BASE_URL = process.env.REACT_APP_API_BASE_URL || 'http://localhost:8085/green-project/api/v1';

// User Roles
export const ROLES = {
  ADMIN: 'ADMIN',
  CHECKER: 'CHECKER',
  MAKER: 'MAKER'
};

// Account Status
export const ACCOUNT_STATUS = {
  PENDING: 'PENDING',
  APPROVED: 'APPROVED',
  REJECTED: 'REJECTED',
  VERIFIED: 'VERIFIED'
};

// Data Table Constants
export const PAGE_SIZE = 10;
export const PAGE_SIZE_OPTIONS = [5, 10, 25, 50];

// Theme
export const THEME_MODES = {
  LIGHT: 'light',
  DARK: 'dark'
};

// Application Settings
export const APP_NAME = 'GreenFinance';
export const LOGO_ALT = 'GreenFinance Logo';

// Timeouts
export const API_TIMEOUT = 30000;
export const TOAST_DURATION = 4000;
