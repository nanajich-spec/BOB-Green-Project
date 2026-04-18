// Mock data for development and testing
import { ACCOUNT_STATUS } from './constants';

export const mockAdminAccounts = [
  {
    id: '1001',
    accountNumber: 'ACC001001',
    holderName: 'Rajesh Kumar',
    email: 'rajesh@example.com',
    phone: '+91-9876543210',
    status: ACCOUNT_STATUS.PENDING,
    amount: 500000,
    loanAmount: 250000,
    interestRate: 8.5,
    tenure: 60,
    created: '2026-01-15',
    indicators: ['Green', 'Sustainable', 'Low Risk']
  },
  {
    id: '1002',
    accountNumber: 'ACC001002',
    holderName: 'Priya Sharma',
    email: 'priya@example.com',
    phone: '+91-8765432109',
    status: ACCOUNT_STATUS.PENDING,
    amount: 750000,
    loanAmount: 400000,
    interestRate: 7.5,
    tenure: 84,
    created: '2026-01-16',
    indicators: ['Green', 'Non-Fossil Renewable Energy']
  },
  {
    id: '1003',
    accountNumber: 'ACC001003',
    holderName: 'Amit Patel',
    email: 'amit@example.com',
    phone: '+91-7654321098',
    status: ACCOUNT_STATUS.VERIFIED,
    amount: 1000000,
    loanAmount: 500000,
    interestRate: 9.0,
    tenure: 120,
    created: '2026-01-14',
    indicators: ['Green', 'Sustainable Agriculture', 'Water Conservation']
  }
];

export const mockCheckerAccounts = [
  {
    id: '2001',
    accountNumber: 'CHK001001',
    holderName: 'Vikram Singh',
    status: ACCOUNT_STATUS.PENDING,
    submittedBy: 'Maker1',
    documentStatus: 'Pending Review'
  },
  {
    id: '2002',
    accountNumber: 'CHK001002',
    holderName: 'Neha Gupta',
    status: ACCOUNT_STATUS.PENDING,
    submittedBy: 'Maker2',
    documentStatus: 'Pending Review'
  }
];

export const mockLoanData = [
  {
    accountNumber: 'ACC001001',
    loanType: 'Green Loan',
    amount: 250000,
    interest: 8.5,
    emi: 4500,
    remainingTenure: 48,
    status: 'Active'
  },
  {
    accountNumber: 'ACC001002',
    loanType: 'Solar Loan',
    amount: 400000,
    interest: 7.5,
    emi: 5200,
    remainingTenure: 72,
    status: 'Active'
  }
];

export const mockDepositData = [
  {
    accountNumber: 'ACC001001',
    depositZone: 'Zone A',
    amount: 100000,
    interestRate: 5.5,
    tenure: 12
  },
  {
    accountNumber: 'ACC001002',
    depositZone: 'Zone B',
    amount: 150000,
    interestRate: 6.0,
    tenure: 24
  }
];

export const mockUsers = [
  {
    id: 'U001',
    name: 'Admin User',
    email: 'admin@greenfinance.com',
    role: 'ADMIN',
    department: 'Administration'
  },
  {
    id: 'U002',
    name: 'Checker User',
    email: 'checker@greenfinance.com',
    role: 'CHECKER',
    department: 'Verification'
  },
  {
    id: 'U003',
    name: 'Maker User',
    email: 'maker@greenfinance.com',
    role: 'MAKER',
    department: 'Operations'
  }
];
