const mockAccounts = [
  {
    accountNumber: '40590600001108',
    borrowerName: 'Green Infra Solutions Ltd',
    branchName: 'Mumbai Main Branch',
    status: 'Queried By Checker',
    susobj: 'SOLAR',
    zone: 'Mumbai',
    region: 'West',
    disbursementAmount: 5000000,
    sanctionedAmount: 7500000,
    outstanding: 4500000,
    dateOfDisbursement: '2022-06-15',
    maturityDate: '2027-06-15'
  },
  {
    accountNumber: '40590600001109',
    borrowerName: 'Clean Mobility Pvt Ltd',
    branchName: 'Mumbai Main Branch',
    status: 'Verified',
    susobj: 'EV',
    zone: 'Mumbai',
    region: 'West',
    disbursementAmount: 3000000,
    sanctionedAmount: 5000000,
    outstanding: 2800000,
    dateOfDisbursement: '2022-08-20',
    maturityDate: '2025-08-20'
  },
  {
    accountNumber: '40590600001110',
    borrowerName: 'Renewable Energy Corp',
    branchName: 'Delhi Branch',
    status: 'Pending',
    susobj: 'WIND',
    zone: 'Delhi',
    region: 'North',
    disbursementAmount: 8000000,
    sanctionedAmount: 10000000,
    outstanding: 7200000,
    dateOfDisbursement: '2023-03-10',
    maturityDate: '2028-03-10'
  },
  {
    accountNumber: '40590600001111',
    borrowerName: 'Water Management Systems',
    branchName: 'Bangalore Branch',
    status: 'Verified',
    susobj: 'WATER',
    zone: 'Bangalore',
    region: 'South',
    disbursementAmount: 2500000,
    sanctionedAmount: 4000000,
    outstanding: 2100000,
    dateOfDisbursement: '2022-12-05',
    maturityDate: '2027-12-05'
  },
  {
    accountNumber: '40590600001112',
    borrowerName: 'Green Building Consultants',
    branchName: 'Chennai Branch',
    status: 'Pending',
    susobj: 'GREEN_BUILDING',
    zone: 'Chennai',
    region: 'South',
    disbursementAmount: 1500000,
    sanctionedAmount: 3000000,
    outstanding: 1200000,
    dateOfDisbursement: '2023-05-12',
    maturityDate: '2026-05-12'
  },
  {
    accountNumber: '40590600001113',
    borrowerName: 'Waste Management Solutions',
    branchName: 'Kolkata Branch',
    status: 'Queried By Checker',
    susobj: 'WASTE',
    zone: 'Kolkata',
    region: 'East',
    disbursementAmount: 2000000,
    sanctionedAmount: 3500000,
    outstanding: 1800000,
    dateOfDisbursement: '2023-01-20',
    maturityDate: '2026-01-20'
  }
];

const mockCheckerAccounts = [
  {
    accountNumber: '40590600001108',
    borrowerName: 'Green Infra Solutions Ltd',
    status: 'Pending Verification',
    zone: 'Mumbai',
    susobj: 'SOLAR',
    sanctionedAmount: 7500000,
    outstanding: 4500000
  },
  {
    accountNumber: '40590600001110',
    borrowerName: 'Renewable Energy Corp',
    status: 'Pending Verification',
    zone: 'Delhi',
    susobj: 'WIND',
    sanctionedAmount: 10000000,
    outstanding: 7200000
  },
  {
    accountNumber: '40590600001113',
    borrowerName: 'Waste Management Solutions',
    status: 'Pending Verification',
    zone: 'Kolkata',
    susobj: 'WASTE',
    sanctionedAmount: 3500000,
    outstanding: 1800000
  },
  {
    accountNumber: '40590600001115',
    borrowerName: 'Solar Tech Industries',
    status: 'Pending Verification',
    zone: 'Mumbai',
    susobj: 'SOLAR',
    sanctionedAmount: 6000000,
    outstanding: 5400000
  }
];

const mockLoanData = [
  {
    accountNumber: '40590600001108',
    accountName: 'Green Infra Solutions Ltd',
    custId: 'GRNINF001',
    solID: 'SOL-1001',
    schemeCode: 'GRNLOAN',
    activityCode: 'SOLAR',
    activityDescription: 'Solar Energy Installation',
    segment: 'MSME',
    accountOpeningDate: '2022-06-01',
    dateOfDisbursement: '2022-06-15',
    amountSanctioned: 7500000,
    amountDisbursed: 5000000,
    amountOutstanding: 4500000,
    maturity: '2027-06-15',
    amountTransferred: 500000,
    dateOfTransfer: '2023-01-15',
    instalmentStartDate: '2022-07-15',
    instalmentFrequency: 'Monthly',
    instalmentAmount: 150000
  },
  {
    accountNumber: '40590600001109',
    accountName: 'Clean Mobility Pvt Ltd',
    custId: 'CLNMOB001',
    solID: 'SOL-1002',
    schemeCode: 'GRNLOAN',
    activityCode: 'EV',
    activityDescription: 'Electric Vehicle Charging Infrastructure',
    segment: 'MSME',
    accountOpeningDate: '2022-08-01',
    dateOfDisbursement: '2022-08-20',
    amountSanctioned: 5000000,
    amountDisbursed: 3000000,
    amountOutstanding: 2800000,
    maturity: '2025-08-20',
    amountTransferred: 200000,
    dateOfTransfer: '2023-02-10',
    instalmentStartDate: '2022-09-20',
    instalmentFrequency: 'Monthly',
    instalmentAmount: 120000
  },
  {
    accountNumber: '40590600001110',
    accountName: 'Renewable Energy Corp',
    custId: 'RENCORP001',
    solID: 'SOL-1003',
    schemeCode: 'GRNLOAN',
    activityCode: 'WIND',
    activityDescription: 'Wind Energy Project',
    segment: 'Corporate',
    accountOpeningDate: '2023-03-01',
    dateOfDisbursement: '2023-03-10',
    amountSanctioned: 10000000,
    amountDisbursed: 8000000,
    amountOutstanding: 7200000,
    maturity: '2028-03-10',
    amountTransferred: 800000,
    dateOfTransfer: '2023-03-20',
    instalmentStartDate: '2023-04-10',
    instalmentFrequency: 'Quarterly',
    instalmentAmount: 500000
  }
];

const mockDepositData = [
  {
    accountNumber: '40590600001108',
    zoroname: 'Mumbai Zone',
    numberAccountOpened: 45,
    numberAccountClosed: 5,
    totalAccounts: 40,
    outstandingAmount: 45000000,
    outstandingValue: 45000000
  },
  {
    accountNumber: '40590600001109',
    zoroname: 'Delhi Zone',
    numberAccountOpened: 38,
    numberAccountClosed: 3,
    totalAccounts: 35,
    outstandingAmount: 28000000,
    outstandingValue: 28000000
  },
  {
    accountNumber: '40590600001110',
    zoroname: 'Bangalore Zone',
    numberAccountOpened: 52,
    numberAccountClosed: 8,
    totalAccounts: 44,
    outstandingAmount: 35200000,
    outstandingValue: 35200000
  },
  {
    accountNumber: '40590600001111',
    zoroname: 'Chennai Zone',
    numberAccountOpened: 28,
    numberAccountClosed: 2,
    totalAccounts: 26,
    outstandingAmount: 20800000,
    outstandingValue: 20800000
  }
];

const mockUsers = [
  {
    userid: 'MKR1001',
    empname: 'Rajesh Kumar',
    designation: 'Senior Manager',
    role: 'maker',
    zone: 'Mumbai',
    region: 'West',
    branchAlpha: 'MUM',
    enable: 'Y',
    deleted: false
  },
  {
    userid: 'CHK1001',
    empname: 'Priya Sharma',
    designation: 'Assistant Manager',
    role: 'checker',
    zone: 'Delhi',
    region: 'North',
    branchAlpha: 'DEL',
    enable: 'Y',
    deleted: false
  },
  {
    userid: 'ADM1001',
    empname: 'Amit Patel',
    designation: 'Head',
    role: 'admin',
    zone: 'Mumbai',
    region: 'West',
    branchAlpha: 'MUM',
    enable: 'Y',
    deleted: false
  },
  {
    userid: 'ADM1002',
    empname: 'Neha Verma',
    designation: 'Specialist',
    role: 'admin',
    zone: 'Bangalore',
    region: 'South',
    branchAlpha: 'BNG',
    enable: 'Y',
    deleted: false
  }
];

const accountDetails = {
  accountNumber: '40590600001108',
  borrowerName: 'Green Infra Solutions Ltd',
  borrowerAddress: '123 Green Street, Mumbai, MH 400001, India',
  borrowerPhone: '+91-9876543210',
  borrowerEmail: 'info@greeninfra.com',
  sanctionedAmount: 7500000,
  disbursedAmount: 5000000,
  outstanding: 4500000,
  status: 'Queried By Checker',
  sustainability: 'SOLAR',
  riskRating: 'A',
  dateOfDisbursement: '2022-06-15',
  maturityDate: '2027-06-15',
  interestRate: '8.95%',
  processedBy: 'Rajesh Kumar',
  approvedBy: 'Amit Patel',
  lastModified: '2024-03-15',
  comments: []
};

const getPath = (url) => {
  if (!url) {
    return '/';
  }
  const marker = '/green-project/api/v1';
  const markerIndex = url.indexOf(marker);
  if (markerIndex >= 0) {
    const path = url.substring(markerIndex + marker.length);
    return path.startsWith('/') ? path : `/${path}`;
  }
  if (url.startsWith('http://') || url.startsWith('https://')) {
    try {
      return new URL(url).pathname;
    } catch (error) {
      return url;
    }
  }
  return url.startsWith('/') ? url : `/${url}`;
};

export const getMockResponse = (config) => {
  const method = (config.method || 'get').toLowerCase();
  const path = getPath(config.url || '');

  // Admin page - Pending Accounts
  if (method === 'get' && (path === '/ViewDetailsAdmin' || path === '/ViewDetailsAdmin/')) {
    return mockAccounts;
  }
  
  // Checker page - Accounts for verification
  if (method === 'get' && (path === '/ViewDetails' || path === '/ViewDetails/')) {
    return mockCheckerAccounts;
  }
  
  // Loan Data Dashboard
  if (method === 'get' && (path === '/ViewDetailsLoan' || path === '/ViewDetailsLoan/')) {
    return mockLoanData;
  }
  
  // Deposit Position Data
  if (method === 'get' && (path === '/ViewDetailsDeposit' || path === '/ViewDetailsDeposit/')) {
    return mockDepositData;
  }
  
  // User Management
  if (method === 'get' && (path === '/users-to-verify' || path === '/users-to-verify/')) {
    return mockUsers;
  }
  
  // Sustainability objective details
  if (method === 'get' && path.startsWith('/pickdataSusObj/')) {
    return {
      susobj: path.split('/').pop(),
      details: 'Mock sustainability objective details',
      score: 'A'
    };
  }
  
  // Comments
  if (method === 'get' && path.startsWith('/getComments/')) {
    return [];
  }
  
  // Account details download
  if (method === 'get' && path.startsWith('/download/')) {
    return accountDetails;
  }
  
  // Account details by account number
  if (method === 'get' && /^\/[A-Za-z0-9]+$/.test(path)) {
    return accountDetails;
  }

  // POST/PUT/DELETE operations
  if (method === 'post' || method === 'put' || method === 'delete') {
    return {
      success: true,
      message: 'Mock operation completed successfully',
      requestPath: path,
      timestamp: new Date().toISOString()
    };
  }

  return [];
};

export { mockAccounts, mockCheckerAccounts, mockLoanData, mockDepositData, mockUsers, accountDetails };
