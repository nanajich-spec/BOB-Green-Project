/**
 * Mock data for testing all Dashboard pages when backend API is unavailable.
 * Set USE_MOCK_DATA = true to force mock data, or false to use real API.
 * When false, mock data is still used as fallback if API calls fail.
 */
export const USE_MOCK_DATA = true;

// ─── Helper ───
const zones = ['Western Zone', 'Northern Zone', 'Southern Zone', 'Eastern Zone', 'Central Zone'];
const regions = ['Mumbai', 'Delhi', 'Chennai', 'Kolkata', 'Bhopal', 'Ahmedabad', 'Pune', 'Lucknow'];
const segments = ['Retail', 'MSME', 'Corporate', 'Agri'];
const schemeCodes = ['GRDEP1', 'GRDEP2', 'GRDEP3', 'GRDEP4', 'GRDEP5'];
const schemeDescriptions = [
  'Green Fixed Deposit 1Y', 'Green Fixed Deposit 2Y', 'Green Recurring Deposit',
  'Green Tax Saver FD', 'Green Senior Citizen FD'
];
const activityCodes = ['RE01', 'EE02', 'WM03', 'PT04', 'GB05'];
const loanSchemes = ['GRLN1', 'GRLN2', 'GRLN3', 'GRLN4'];
const months = ['Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec', 'Jan', 'Feb', 'Mar'];
const branchNames = [
  'Fort Branch', 'Connaught Place', 'T Nagar', 'Salt Lake', 'MP Nagar',
  'CG Road', 'FC Road', 'Hazratganj', 'Banjara Hills', 'MG Road'
];

const rand = (min, max) => Math.floor(Math.random() * (max - min + 1)) + min;
const randFloat = (min, max, dec = 2) => parseFloat((Math.random() * (max - min) + min).toFixed(dec));
const padDate = (d, m, y) => `${String(d).padStart(2, '0')}-${String(m).padStart(2, '0')}-${y}`;

// ─── Chart Mock Data (RiskAssessment / Dashboard Charts) ───

/** Deposits by Scheme Code - Pie (PieChartDTO: schemecode, count) */
export const mockDepositPieData = [
  { schemecode: 'GRDEP1', count: 1245 },
  { schemecode: 'GRDEP2', count: 892 },
  { schemecode: 'GRDEP3', count: 567 },
  { schemecode: 'GRDEP4', count: 423 },
  { schemecode: 'GRDEP5', count: 318 },
];

/** Loans by Account Segment - Pie (LoanChartDTO: accountSegment, count) */
export const mockLoanPieData = [
  { accountSegment: 'Retail', count: 2150 },
  { accountSegment: 'MSME', count: 1340 },
  { accountSegment: 'Corporate', count: 780 },
  { accountSegment: 'Agri', count: 1620 },
];

/** Monthly Deposits - Bar (BarChartDTO: year, month, entryCount) */
export const mockMonthlyDepositData = months.map((m, i) => ({
  year: i >= 9 ? '2026' : '2025',
  month: m,
  entryCount: rand(80, 350),
}));

/** Monthly Deposits vs Loans - Grouped Bar (LoanBarChartDTO: month, depositsCount, loansCount) */
export const mockMonthlyDepositVsLoanData = months.map(m => ({
  month: m,
  depositsCount: rand(100, 400),
  loansCount: rand(60, 300),
}));

/** Cumulative Deposits - Line (LineChartDTO: year, month, cumulativeAmount) */
export const mockCumulativeDepositData = (() => {
  let cum = 0;
  return months.map((m, i) => {
    cum += rand(500000, 2500000);
    return { year: i >= 9 ? '2026' : '2025', month: m, cumulativeAmount: cum };
  });
})();

/** Cumulative Loans - Line (LineChartDTO: year, month, cumulativeAmount) */
export const mockCumulativeLoanData = (() => {
  let cum = 0;
  return months.map((m, i) => {
    cum += rand(400000, 2000000);
    return { year: i >= 9 ? '2026' : '2025', month: m, cumulativeAmount: cum };
  });
})();

/** Loans by Segment - Bar (SegmentChartDTO: accountSegment, count) */
export const mockSegmentData = [
  { accountSegment: 'Retail', count: 2150 },
  { accountSegment: 'MSME', count: 1340 },
  { accountSegment: 'Corporate', count: 780 },
  { accountSegment: 'Agri', count: 1620 },
];

/** Green Loans by Scheme & Activity (SchemeActivityChartDTO: schemeCode, activityCode, count) */
export const mockSchemeActivityData = [];
loanSchemes.forEach(sc => {
  activityCodes.forEach(ac => {
    mockSchemeActivityData.push({ schemeCode: sc, activityCode: ac, count: rand(10, 200) });
  });
});

// ─── Loan Table Mock Data (LoanDetails entity) ───
export const mockLoanTableData = Array.from({ length: 35 }, (_, i) => {
  const zIdx = i % zones.length;
  const rIdx = i % regions.length;
  const sIdx = i % segments.length;
  const openDay = rand(1, 28);
  const openMonth = rand(1, 12);
  const openYear = rand(2023, 2025);
  const sanctionAmt = rand(500000, 50000000);
  return {
    zone: zones[zIdx],
    Region: regions[rIdx],
    SolDesc: branchNames[i % branchNames.length],
    SolID: String(1000 + i),
    CustId: `CUST${String(100000 + i)}`,
    AccountNumber: `GRLN${String(2000000000 + i)}`,
    AccountName: `M/s Green Enterprise ${i + 1}`,
    AccountOpenedDate: padDate(openDay, openMonth, openYear),
    SantionLimitDate: padDate(rand(1, 28), openMonth, openYear),
    AggregateDisbursementAmount: sanctionAmt,
    OutstandingAmount: rand(100000, sanctionAmt),
    Maturity: padDate(rand(1, 28), rand(1, 12), openYear + rand(1, 5)),
    AccountSegment: segments[sIdx],
    SchemeCode: loanSchemes[i % loanSchemes.length],
    ActivityCode: activityCodes[i % activityCodes.length],
    SantionLimit: sanctionAmt,
  };
});

// ─── Deposit Table Mock Data (DepositDetails entity) ───
export const mockDepositTableData = Array.from({ length: 40 }, (_, i) => {
  const zIdx = i % zones.length;
  const rIdx = i % regions.length;
  const scIdx = i % schemeCodes.length;
  const openDay = rand(1, 28);
  const openMonth = rand(1, 12);
  const openYear = rand(2023, 2025);
  const faceVal = rand(50000, 10000000);
  const months = rand(6, 60);
  return {
    zone: zones[zIdx],
    region: regions[rIdx],
    solid: String(2000 + i),
    branchcode: `BR${String(3000 + i)}`,
    custid: `CUST${String(200000 + i)}`,
    accountno: `GRDP${String(3000000000 + i)}`,
    accountname: `Green Deposit Account ${i + 1}`,
    accountopeningdate: padDate(openDay, openMonth, openYear),
    schemecode: schemeCodes[scIdx],
    schemedescription: schemeDescriptions[scIdx],
    netIntRate: randFloat(5.5, 8.5),
    totalperiodinmonths: months,
    totalperiodindays: months * 30,
    facevalue: faceVal,
    currentbalance: rand(faceVal, Math.floor(faceVal * 1.1)),
    maturityamount: Math.floor(faceVal * (1 + randFloat(0.05, 0.08))),
    maturitydate: padDate(rand(1, 28), rand(1, 12), openYear + Math.ceil(months / 12)),
    businessDate: padDate(15, 4, 2026),
    uploadDate: padDate(15, 4, 2026),
  };
});

// ─── Checker / Admin / DataTable (Return) Mock Data ───
// These pages show accounts with accountNumber, borrowerName, status
const statuses = ['Pending at Checker', 'Pending at Admin', 'Queried By Checker', 'Approved', 'Rejected'];
const borrowerNames = [
  'M/s Green Solar Pvt Ltd', 'Eco Winds Energy Corp', 'Sustainable Farming Co-op',
  'CleanTech Industries', 'BioFuel Enterprises', 'GreenBuild Construction',
  'Aqua Purification Ltd', 'Solar Rooftop Solutions', 'EV Charging Networks',
  'Organic Agri Exports', 'Wind Power Holdings', 'Recycled Materials Inc',
  'Green Hydrogen Ltd', 'EcoTex Garments', 'Smart Grid Systems',
];
const branchNamesAll = [
  'Fort Branch', 'Connaught Place', 'T Nagar Branch', 'Salt Lake Branch',
  'MP Nagar Branch', 'Banjara Hills', 'FC Road Branch', 'Hazratganj Branch',
];
const sustainableObjs = [
  'Affordable and Clean Energy', 'Clean Water and Sanitation', 'Climate Action',
  'Industry Innovation and Infrastructure', 'Responsible Consumption and Production',
  'Life on Land', 'Sustainable Cities and Communities',
];
const sectorTypes = ['Renewable Energy', 'Green Building', 'Pollution Prevention', 'Clean Transport', 'Biodiversity'];

/** Checker page - pending accounts */
export const mockCheckerAccounts = Array.from({ length: 8 }, (_, i) => ({
  accountNumber: `GRLN${String(4000000001 + i)}`,
  borrowerName: borrowerNames[i % borrowerNames.length],
  status: i < 5 ? 'Pending at Checker' : 'Queried By Checker',
  solID: String(1000 + rand(0, 50)),
  branchName: branchNamesAll[i % branchNamesAll.length],
}));

/** Admin page - pending admin accounts */
export const mockAdminAccounts = Array.from({ length: 6 }, (_, i) => ({
  accountNumber: `GRLN${String(5000000001 + i)}`,
  borrowerName: borrowerNames[(i + 3) % borrowerNames.length],
  status: 'Pending at Admin',
  solID: String(2000 + rand(0, 50)),
  branchName: branchNamesAll[(i + 2) % branchNamesAll.length],
}));

/** DataTable.js (Return from Checker) - returned/queried accounts */
export const mockReturnedAccounts = Array.from({ length: 4 }, (_, i) => ({
  accountNumber: `GRLN${String(6000000001 + i)}`,
  borrowerName: borrowerNames[(i + 5) % borrowerNames.length],
  status: 'Queried By Checker',
  returnCheckerID: `CHK${String(100 + i)}`,
  reasonForReturning: ['Document missing', 'Incorrect data', 'Need clarification', 'Incomplete form'][i],
}));

/** Verified page - approved records */
export const mockVerifiedAccounts = Array.from({ length: 10 }, (_, i) => ({
  accountNumber: `GRLN${String(7000000001 + i)}`,
  borrowerName: borrowerNames[(i + 7) % borrowerNames.length],
  status: 'Approved',
  approvalDate: padDate(rand(1, 28), rand(1, 4), 2026),
}));

/** Maker page - full account detail for pre-filling the form */
export const mockMakerAccountDetail = {
  accountNumber: 'GRLN4000000001',
  borrowerName: 'M/s Green Solar Pvt Ltd',
  branchName: 'Fort Branch',
  panNumber: 'AABCG1234K',
  cinNumber: 'U40100MH2020PTC123456',
  schemeCode: 'GRLN1',
  activityCode: 'RE01',
  briefDtls: 'Solar power plant installation for 50MW capacity',
  description: 'Installation of solar panels across 100 acres for green energy generation',
  projName: 'Green Solar - Phase II',
  sector: 'Renewable Energy',
  locationType: 'Rural',
  othersAdd: 'Village Khandala, Taluka Maval, Pune',
  susobj: 'Affordable and Clean Energy',
  longitude: '73.7500',
  latitude: '18.7600',
  stakeEng: 'Local community, State Electricity Board, Green Finance team',
  reportReq: 'Quarterly progress & annual impact report',
  timeline: '24 months',
  budget: '45,00,00,000',
  pincode: '410401',
  legalVerificationComments: 'All legal clearances obtained including environmental clearance',
  financialHealthComments: 'Strong balance sheet, CRISIL AA rated',
  esgCompliance: 'Full ESG compliance verified',
  eiacomments: 'EIA conducted by approved agency, no adverse findings',
  vulnerability: 'Low flood risk area; seismic zone II',
  carbonintensive: 'Not applicable - renewable energy project',
  sealevel: 'Not applicable - inland location',
  assetrisk: 'Low - diversified solar asset base',
  supplychain: 'Supply chain secured with 3 panel manufacturers',
  shifting: 'Favorable - increasing demand for solar energy',
  business: 'Business continuity plan in place with insurance coverage',
  climate: 'Climate resilient infrastructure with hail protection',
  borroweremission: 'Net negative carbon footprint expected post-commissioning',
};

/** Sustainability Objective Indicators (for pickdataSusObj API) */
export const mockSusObjIndicators = [
  { indicator: "Pollution Control", description: "Measure of pollution reduction", comment: "", type: "Quantitative", methodology: "Annual assessment", commentKey: "pollContCmnt" },
  { indicator: "Water Pollution", description: "Water contamination levels", comment: "", type: "Quantitative", methodology: "Water quality tests", commentKey: "waterPolluCmnt" },
  { indicator: "Protected Areas", description: "Area under conservation", comment: "", type: "Quantitative", methodology: "GIS mapping", commentKey: "protectAreaComnt" },
  { indicator: "Stakeholder Information", description: "Stakeholder engagement metrics", comment: "", type: "Qualitative", methodology: "Surveys", commentKey: "infoStakeComnt" },
  { indicator: "Clean Vehicles", description: "Number of clean vehicles financed", comment: "", type: "Quantitative", methodology: "Fleet records", commentKey: "cleanVehicleCmnt" },
  { indicator: "Capacity of Renewable Energy Plants", description: "MW capacity installed", comment: "", type: "Quantitative", methodology: "Plant commissioning report", commentKey: "capPlantComment" },
  { indicator: "Energy Pre & Post Assessment", description: "Energy savings pre vs post", comment: "", type: "Quantitative", methodology: "Energy audit", commentKey: "energyPrePostcmnt" },
  { indicator: "Estimated Reduction", description: "Estimated CO2 reduction", comment: "", type: "Quantitative", methodology: "Carbon calculator", commentKey: "estReductionCmnt" },
];

/** Comments for indicator comments API (getComments) */
export const mockIndicatorComments = {
  pollContCmnt: "Pollution levels within permissible CPCB limits",
  waterPolluCmnt: "BOD levels at 12mg/L, well within norms",
  protectAreaComnt: "25 hectares designated as buffer zone",
  infoStakeComnt: "Quarterly stakeholder meetings conducted",
  cleanVehicleCmnt: "12 EVs procured for operations",
  capPlantComment: "50MW solar plant operational since Jan 2026",
  energyPrePostcmnt: "32% reduction in grid dependency",
  estReductionCmnt: "Estimated 18,500 tonnes CO2eq/year reduction",
  areaSustainCmnt: "200 acres under sustainable management",
  restorehabitCmnt: "Local habitat restoration across 15 hectares",
  annualAmountCmnt: "Annual green investment of ₹12 Cr",
  restorelandCmnt: "30 hectares degraded land restored",
  naturalLandCmnt: "Biodiversity corridor of 5 km maintained",
  sustainableComnt: "Organic farming practices on 80% of land",
  annualWaterCmnt: "Annual water consumption: 500 KL",
  reductionWatercmnt: "40% reduction via rainwater harvesting",
  numberTrgtCmnt: "8 out of 10 targets achieved",
  waterUseCmnt: "Water use efficiency improved by 35%",
  areaLandCmnt: "120 hectares under land management plan",
  annGHGComment: "Annual GHG: 1200 tCO2eq",
  co2Comment: "CO2 reduction: 18500 tCO2eq/year",
  annEnergyCmnt: "Annual energy savings: 4500 MWh",
  annLevelCmnt: "Pollution levels reduced by 45%",
};

/** Admin_c Report page - same structure, separate mock pool */
export const mockAdminReportAccounts = Array.from({ length: 10 }, (_, i) => ({
  accountNumber: `GRLN${String(8000000001 + i)}`,
  borrowerName: borrowerNames[i % borrowerNames.length],
  status: ['Approved', 'Pending at Admin', 'Approved', 'Queried By Checker', 'Approved'][i % 5],
  solID: String(3000 + rand(0, 50)),
  branchName: branchNamesAll[i % branchNamesAll.length],
}));

/** User Management mock data */
export const mockUsers = [
  { userid: 'ECN12345', empname: 'Rajesh Kumar', zone: 'Western Zone', region: 'Mumbai', role: 'maker', enable: 'Y', deleted: false, branchAlpha: 'FORT', branchSol: '1001', addedBy: 'ADMIN', addedOn: '2025-06-15' },
  { userid: 'ECN12346', empname: 'Priya Sharma', zone: 'Northern Zone', region: 'Delhi', role: 'checker', enable: 'Y', deleted: false, branchAlpha: 'CPBR', branchSol: '1002', addedBy: 'ADMIN', addedOn: '2025-07-20' },
  { userid: 'ECN12347', empname: 'Amit Patel', zone: 'Western Zone', region: 'Ahmedabad', role: 'maker', enable: 'N', deleted: false, branchAlpha: 'CGRD', branchSol: '1003', addedBy: 'ADMIN', addedOn: '2025-08-10' },
  { userid: 'ECN12348', empname: 'Sneha Iyer', zone: 'Southern Zone', region: 'Chennai', role: 'checker', enable: 'Y', deleted: false, branchAlpha: 'TNGR', branchSol: '1004', addedBy: 'ADMIN', addedOn: '2025-09-05' },
  { userid: 'ECN12349', empname: 'Vikram Singh', zone: 'Northern Zone', region: 'Lucknow', role: 'maker', enable: 'Y', deleted: false, branchAlpha: 'HZGJ', branchSol: '1005', addedBy: 'ADMIN', addedOn: '2025-10-12' },
  { userid: 'ECN12350', empname: 'Deepa Nair', zone: 'Southern Zone', region: 'Chennai', role: 'checker', enable: 'Y', deleted: false, branchAlpha: 'TNGR', branchSol: '1006', addedBy: 'ADMIN', addedOn: '2025-11-18' },
  { userid: 'ECN12351', empname: 'Suresh Reddy', zone: 'Eastern Zone', region: 'Kolkata', role: 'maker', enable: 'Y', deleted: false, branchAlpha: 'SLTL', branchSol: '1007', addedBy: 'ADMIN', addedOn: '2025-12-01' },
  { userid: 'ECN12352', empname: 'Kavita Joshi', zone: 'Central Zone', region: 'Bhopal', role: 'checker', enable: 'N', deleted: false, branchAlpha: 'MPNG', branchSol: '1008', addedBy: 'ADMIN', addedOn: '2026-01-15' },
];
