import React, { useEffect } from 'react';
import { Outlet } from 'react-router-dom';
import { Box, useMediaQuery, useTheme } from '@mui/material';
import Header from '../Header';
import Sidebar from '../Sidebar';
import Footer from '../Footer';
import { useAppLayout } from './AppLayoutContext';

const HEADER_HEIGHT = 76;
const FOOTER_HEIGHT = 52;

const AppShell = () => {
  const theme = useTheme();
  const isMobile = useMediaQuery(theme.breakpoints.down('md'));
  const { sidebarCollapsed } = useAppLayout();

  useEffect(() => {
    document.documentElement.style.setProperty('--shell-header-height', `${HEADER_HEIGHT}px`);
    document.documentElement.style.setProperty('--shell-footer-height', `${FOOTER_HEIGHT}px`);
  }, []);

  const sidebarWidth = isMobile ? 0 : sidebarCollapsed ? 88 : 260;

  return (
    <Box className="app-shell" sx={{ display: 'flex', flexDirection: 'column', minHeight: '100vh', backgroundColor: 'var(--surface-page)' }}>
      <Header />
      <Sidebar />
      <Box
        component="main"
        className="app-main"
        sx={{
          marginTop: `${HEADER_HEIGHT}px`,
          marginBottom: `${FOOTER_HEIGHT}px`,
          marginLeft: { xs: 0, md: `${sidebarWidth}px` },
          transition: theme.transitions.create('margin-left', {
            easing: theme.transitions.easing.sharp,
            duration: theme.transitions.duration.enteringScreen
          }),
          minHeight: `calc(100vh - ${HEADER_HEIGHT}px - ${FOOTER_HEIGHT}px)`,
          backgroundColor: 'var(--surface-page)',
          overflow: 'hidden',
          overflowX: 'hidden',
        }}
      >
        <Box className="app-main-scroll" sx={{ height: `calc(100vh - ${HEADER_HEIGHT}px - ${FOOTER_HEIGHT}px)` }}>
          <Outlet />
        </Box>
      </Box>
      <Footer sidebarWidth={sidebarWidth} footerHeight={FOOTER_HEIGHT} />
    </Box>
  );
};

export default AppShell;
