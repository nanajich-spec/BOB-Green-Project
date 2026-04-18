import React, { createContext, useContext, useEffect, useMemo, useState } from 'react';
import { CssBaseline, ThemeProvider, createTheme } from '@mui/material';

const ColorModeContext = createContext({
  mode: 'light',
  toggleColorMode: () => {}
});

export const useColorMode = () => useContext(ColorModeContext);

/* ── Bank of Baroda brand palette ── */
const BOB_GREEN_PRIMARY = '#134B2A';
const BOB_GREEN_LIGHT  = '#1B6B3A';
const BOB_GREEN_DARK   = '#0D3520';
const BOB_ACCENT_BLUE  = '#1565C0';
const BOB_SUCCESS       = '#2E7D32';
const BOB_WARNING       = '#ED6C02';
const BOB_ERROR         = '#D32F2F';
const BOB_INFO          = '#0288D1';

const getDesignTokens = (mode) => ({
  palette: {
    mode,
    ...(mode === 'light'
      ? {
          primary:    { main: BOB_GREEN_PRIMARY, light: BOB_GREEN_LIGHT, dark: BOB_GREEN_DARK, contrastText: '#fff' },
          secondary:  { main: BOB_ACCENT_BLUE },
          success:    { main: BOB_SUCCESS },
          warning:    { main: BOB_WARNING },
          error:      { main: BOB_ERROR },
          info:       { main: BOB_INFO },
          background: { default: '#f0f5ef', paper: '#ffffff' },
          text:       { primary: '#1a1a1a', secondary: '#546e7a' }
        }
      : {
          primary:    { main: '#4ade80', light: '#86efac', dark: '#22c55e', contrastText: '#000' },
          secondary:  { main: '#38bdf8' },
          success:    { main: '#66bb6a' },
          warning:    { main: '#ffa726' },
          error:      { main: '#ef5350' },
          info:       { main: '#29b6f6' },
          background: { default: '#0f172a', paper: '#111827' },
          text:       { primary: '#f1f5f9', secondary: '#94a3b8' }
        })
  },
  breakpoints: {
    values: { xs: 0, sm: 600, md: 960, lg: 1280, xl: 1920 }
  },
  typography: {
    fontFamily: '"Inter", "Roboto", "Helvetica Neue", Arial, sans-serif',
    h1: { fontWeight: 800, fontSize: '2.25rem', lineHeight: 1.2 },
    h2: { fontWeight: 700, fontSize: '1.75rem', lineHeight: 1.3 },
    h3: { fontWeight: 700, fontSize: '1.5rem',  lineHeight: 1.35 },
    h4: { fontWeight: 700, fontSize: '1.25rem', lineHeight: 1.4 },
    h5: { fontWeight: 600, fontSize: '1.1rem',  lineHeight: 1.5 },
    h6: { fontWeight: 600, fontSize: '1rem',    lineHeight: 1.5 },
    subtitle1: { fontWeight: 600, fontSize: '0.95rem' },
    subtitle2: { fontWeight: 500, fontSize: '0.875rem' },
    body1: { fontSize: '0.875rem', lineHeight: 1.6 },
    body2: { fontSize: '0.8125rem', lineHeight: 1.55 },
    caption: { fontSize: '0.75rem', lineHeight: 1.5 },
    button: { fontWeight: 600, textTransform: 'none' }
  },
  shape: {
    borderRadius: 12
  },
  components: {
    MuiCard: {
      styleOverrides: {
        root: { borderRadius: 8, padding: '16px' }
      }
    },
    MuiButton: {
      styleOverrides: {
        root: {
          borderRadius: 8,
          padding: '8px 22px',
          fontWeight: 600,
          textTransform: 'none'
        },
        containedPrimary: {
          boxShadow: '0 2px 8px rgba(19,75,42,0.25)',
          '&:hover': { boxShadow: '0 4px 14px rgba(19,75,42,0.35)' }
        }
      }
    },
    MuiTextField: {
      styleOverrides: {
        root: {
          '& .MuiOutlinedInput-root': {
            borderRadius: 8,
            transition: 'box-shadow 0.2s ease',
            '&.Mui-focused': {
              boxShadow: '0 0 0 3px rgba(19,75,42,0.12)'
            }
          }
        }
      }
    },
    MuiChip: {
      styleOverrides: {
        root: { borderRadius: 6 }
      }
    },
    MuiTableCell: {
      styleOverrides: {
        root: { fontSize: '0.8125rem' }
      }
    },
    MuiCssBaseline: {
      styleOverrides: {
        body: { fontSize: '0.875rem' }
      }
    }
  }
});

const getInitialMode = () => {
  const stored = window.localStorage.getItem('green-ui-theme');
  return stored === 'dark' ? 'dark' : 'light';
};

export const AppThemeProvider = ({ children }) => {
  const [mode, setMode] = useState(getInitialMode);

  useEffect(() => {
    document.body.setAttribute('data-theme', mode);
    document.documentElement.setAttribute('data-theme', mode);
  }, [mode]);

  const colorModeValue = useMemo(
    () => ({
      mode,
      toggleColorMode: () => {
        setMode((prev) => {
          const next = prev === 'light' ? 'dark' : 'light';
          window.localStorage.setItem('green-ui-theme', next);
          return next;
        });
      }
    }),
    [mode]
  );

  const theme = useMemo(() => createTheme(getDesignTokens(mode)), [mode]);

  return (
    <ColorModeContext.Provider value={colorModeValue}>
      <ThemeProvider theme={theme}>
        <CssBaseline />
        {children}
      </ThemeProvider>
    </ColorModeContext.Provider>
  );
};
