import React from 'react';
import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom';
import './App.css';
import {
  AdminPending,
  AdminReport,
  AdminDetails,
  AdminRiskAssessment,
  CheckerPending,
  CheckerDetails,
  CheckerVerified,
  MakerNew,
  MakerExisting,
  MakerDetails,
  LoanDashboard,
  DepositPosition,
  ProjectSpecificIndicator,
  UserManagement,
  Login
} from './pages';
import PDFDocument from './PDFDocument.js';
import ReturnFromAdminDataTable from './DataTable1.js';
import { AppThemeProvider } from './theme/AppThemeProvider.js';
import { AppLayoutProvider } from './layout/AppLayoutContext.js';
import AppShell from './layout/AppShell.js';
import { ROUTES } from './config/routes';
import { AuthProvider } from './context/AuthContext';
import { ThemeProvider as UiThemeProvider } from './context/ThemeContext';
import { LayoutProvider } from './context/LayoutContext';
import { NotificationProvider } from './context/NotificationContext';
import './ModernLayout.css';

function App() {
  return (
    <AppThemeProvider>
      <UiThemeProvider>
        <AuthProvider>
          <LayoutProvider>
            <NotificationProvider>
              <AppLayoutProvider>
                <div className="App">
                  <BrowserRouter basename='/greenfinance'>
                    <Routes>
                      <Route path={ROUTES.LOGIN} element={<Login />} />

                      <Route element={<AppShell />}>
                        <Route path={ROUTES.ADMIN_PENDING} element={<AdminPending />} />
                        <Route path={ROUTES.ADMIN_REPORT} element={<AdminReport />} />
                        <Route path={ROUTES.ADMIN_RISK_ASSESSMENT} element={<AdminRiskAssessment />} />
                        <Route path={ROUTES.PROJECT_SPECIFIC} element={<ProjectSpecificIndicator />} />
                        <Route path={ROUTES.LOAN_DATA} element={<LoanDashboard />} />
                        <Route path={ROUTES.DEPOSIT_DATA} element={<DepositPosition />} />
                        <Route path={ROUTES.USER_MANAGEMENT} element={<UserManagement />} />

                        <Route path={ROUTES.CHECKER_PENDING} element={<CheckerPending />} />
                        <Route path={ROUTES.CHECKER_VERIFIED} element={<CheckerVerified />} />
                        <Route path={ROUTES.CHECKER_DETAILS} element={<CheckerDetails />} />

                        <Route path={ROUTES.MAKER_NEW} element={<MakerNew />} />
                        <Route path={ROUTES.MAKER_EXISTING} element={<MakerExisting />} />
                        <Route path={ROUTES.MAKER_DETAILS} element={<MakerDetails />} />

                        <Route path='/existingrecords' element={<MakerExisting />} />
                        <Route path='/datatable' element={<MakerDetails />} />
                        <Route path='/returnfromadmin' element={<ReturnFromAdminDataTable />} />
                        <Route path='/Maker' element={<MakerNew />} />
                        <Route path='/checker' element={<CheckerPending />} />
                        <Route path='/checker1' element={<CheckerDetails />} />
                        <Route path='/Verified' element={<CheckerVerified />} />
                        <Route path='/verify' element={<CheckerPending />} />
                        <Route path='/admin1' element={<AdminDetails />} />
                        <Route path='/admin2' element={<AdminDetails />} />
                        <Route path='/admin/:accountNumber' element={<AdminPending />} />
                        <Route path='/pdfdownload/:accountNumber' element={<PDFDocument/>}/>
                      </Route>

                      <Route path="*" element={<Navigate to={ROUTES.LOGIN} replace />} />
                    </Routes>
                  </BrowserRouter>
                </div>
              </AppLayoutProvider>
            </NotificationProvider>
          </LayoutProvider>
        </AuthProvider>
      </UiThemeProvider>
    </AppThemeProvider>
  );
}

export default App;