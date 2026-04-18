import { ROLES } from './constants';

export const ROUTES = {
  // Auth
  LOGIN: '/login',
  
  // Admin Routes
  ADMIN_PENDING: '/admin',
  ADMIN_REPORT: '/report',
  ADMIN_DETAILS: '/admin/details/:id',
  ADMIN_RISK_ASSESSMENT: '/RiskAssessment',
  USER_MANAGEMENT: '/UserManagement',
  LOAN_DATA: '/loanData',
  DEPOSIT_DATA: '/depositData',
  PROJECT_SPECIFIC: '/ProjectSpecificIndicator',
  
  // Checker Routes
  CHECKER_PENDING: '/checker/pending',
  CHECKER_DETAILS: '/checker/details/:id',
  CHECKER_VERIFIED: '/checker/verified',
  
  // Maker Routes
  MAKER_NEW: '/maker/new',
  MAKER_EXISTING: '/maker/existing',
  MAKER_DETAILS: '/maker/details/:id'
};

// Navigation structure by role
export const NAVIGATION_BY_ROLE = {
  [ROLES.ADMIN]: [
    { label: 'Pending', path: ROUTES.ADMIN_PENDING, icon: 'pending' },
    { label: 'User Management', path: ROUTES.USER_MANAGEMENT, icon: 'users' },
    { label: 'Report', path: ROUTES.ADMIN_REPORT, icon: 'report' },
    { label: 'Dashboard', path: ROUTES.LOAN_DATA, icon: 'dashboard' },
    { label: 'Dashboard Charts', path: ROUTES.ADMIN_RISK_ASSESSMENT, icon: 'chart' },
    { label: 'Green Deposit Position', path: ROUTES.DEPOSIT_DATA, icon: 'deposit' }
  ],
  [ROLES.CHECKER]: [
    { label: 'Pending Verification', path: ROUTES.CHECKER_PENDING, icon: 'pending' },
    { label: 'Verified Accounts', path: ROUTES.CHECKER_VERIFIED, icon: 'verified' }
  ],
  [ROLES.MAKER]: [
    { label: 'New Record', path: ROUTES.MAKER_NEW, icon: 'add' },
    { label: 'Existing Records', path: ROUTES.MAKER_EXISTING, icon: 'list' }
  ]
};

// Route permission mapping
export const ROUTE_PERMISSIONS = {
  [ROUTES.LOGIN]: ['GUEST'],
  [ROUTES.ADMIN_PENDING]: [ROLES.ADMIN],
  [ROUTES.ADMIN_REPORT]: [ROLES.ADMIN],
  [ROUTES.ADMIN_DETAILS]: [ROLES.ADMIN],
  [ROUTES.ADMIN_RISK_ASSESSMENT]: [ROLES.ADMIN],
  [ROUTES.USER_MANAGEMENT]: [ROLES.ADMIN],
  [ROUTES.LOAN_DATA]: [ROLES.ADMIN],
  [ROUTES.DEPOSIT_DATA]: [ROLES.ADMIN],
  [ROUTES.PROJECT_SPECIFIC]: [ROLES.ADMIN],
  [ROUTES.CHECKER_PENDING]: [ROLES.CHECKER],
  [ROUTES.CHECKER_DETAILS]: [ROLES.CHECKER],
  [ROUTES.CHECKER_VERIFIED]: [ROLES.CHECKER],
  [ROUTES.MAKER_NEW]: [ROLES.MAKER],
  [ROUTES.MAKER_EXISTING]: [ROLES.MAKER],
  [ROUTES.MAKER_DETAILS]: [ROLES.MAKER]
};
