import React from 'react';
import {
  AppBar,
  Avatar,
  Box,
  Chip,
  IconButton,
  Stack,
  Toolbar,
  Tooltip,
  Typography,
  useMediaQuery,
  useTheme
} from '@mui/material';
import MenuIcon from '@mui/icons-material/Menu';
import DarkModeOutlinedIcon from '@mui/icons-material/DarkModeOutlined';
import LightModeOutlinedIcon from '@mui/icons-material/LightModeOutlined';
import LogoutIcon from '@mui/icons-material/Logout';

import { useNavigate } from 'react-router-dom';
import logo from '../../bob_logo.png';
import { useColorMode } from '../../theme/AppThemeProvider';
import { useAppLayout } from '../../layout/AppLayoutContext';

const Header = () => {
  const navigate = useNavigate();
  const theme = useTheme();
  const isMobile = useMediaQuery(theme.breakpoints.down('md'));
  const { mode, toggleColorMode } = useColorMode();
  const { toggleMobileSidebar } = useAppLayout();
  const storedUser = JSON.parse(window.sessionStorage.getItem('userDet') || 'null');

  const roleLabel = storedUser?.userRole || 'User';
  const userId = storedUser?.userId || 'Guest';

  const handleLogout = () => {
    window.sessionStorage.removeItem('userDet');
    window.localStorage.removeItem('user');
    navigate('/login');
  };

  return (
    <AppBar
      position="fixed"
      elevation={0}
      sx={{
        zIndex: (muiTheme) => muiTheme.zIndex.drawer + 1,
        borderBottom: '1px solid rgba(19, 75, 42, 0.2)',
        backgroundImage: (muiTheme) => 
          muiTheme.palette.mode === 'dark'
            ? 'linear-gradient(180deg, #1a4d2e 0%, #134b2a 100%)'
            : 'linear-gradient(180deg, #0D3520 0%, #134B2A 100%)',
        color: '#ffffff',
        boxShadow: '0 2px 8px rgba(0, 0, 0, 0.1)'
      }}
    >
      <Toolbar sx={{ minHeight: '76px !important', px: 0, display: 'flex', alignItems: 'center', justifyContent: 'space-between', width: '100%' }}>
        <Box sx={{ display: 'flex', alignItems: 'center', width: { xs: 'auto', md: '260px' }, px: { xs: 1, sm: 2 } }}>
          {isMobile && (
            <Tooltip title="Open navigation">
              <IconButton
                color="inherit"
                onClick={toggleMobileSidebar}
                edge="start"
                sx={{ mr: 1, bgcolor: mode === 'dark' ? 'rgba(148,163,184,0.16)' : 'rgba(20,83,45,0.12)' }}
              >
                <MenuIcon />
              </IconButton>
            </Tooltip>
          )}
          <Box
            sx={{
              width: { xs: 140, sm: 160 },
              height: { xs: 52, sm: 64 },
              display: 'flex',
              alignItems: 'center',
              justifyContent: 'center',
              p: 0,
              flexShrink: 0
            }}
          >
            <Box component="img" src={logo} alt="Bank of Baroda" sx={{ width: '100%', height: '100%', objectFit: 'contain' }} />
          </Box>
        </Box>

        <Box sx={{ flex: 1, display: 'flex', justifyContent: 'center' }}>
          <Box sx={{ textAlign: 'center' }}>
            <Typography variant="h5" sx={{ fontWeight: 800, lineHeight: 1.2 }}>
              BOB Green Finance Portal
            </Typography>
            <Typography variant="caption" color="text.secondary" sx={{ display: { xs: 'none', sm: 'block' } }}>
              Empowering sustainable banking
            </Typography>
          </Box>
        </Box>

        <Box>
          <Stack direction="row" alignItems="center" spacing={1}>
            <Tooltip title={mode === 'dark' ? 'Switch to light mode' : 'Switch to dark mode'}>
              <IconButton color="inherit" onClick={toggleColorMode}>
                {mode === 'dark' ? <LightModeOutlinedIcon /> : <DarkModeOutlinedIcon />}
              </IconButton>
            </Tooltip>
            <Chip
              avatar={<Avatar>{(userId || 'G').charAt(0)}</Avatar>}
              label={`${userId} • ${roleLabel}`}
              variant="outlined"
              sx={{ maxWidth: { xs: 132, sm: 240 } }}
            />
            <Tooltip title="Logout">
              <IconButton color="error" onClick={handleLogout}>
                <LogoutIcon />
              </IconButton>
            </Tooltip>
          </Stack>
        </Box>
      </Toolbar>
    </AppBar>
  );
};

export default Header;
