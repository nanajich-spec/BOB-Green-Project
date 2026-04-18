import React, { useEffect, useMemo, useState } from 'react';
import {
  Box,
  Collapse,
  Divider,
  Drawer,
  IconButton,
  List,
  ListItemButton,
  ListItemIcon,
  ListItemText,
  Tooltip,
  Typography,
  useMediaQuery,
  useTheme
} from '@mui/material';
import DashboardOutlinedIcon from '@mui/icons-material/DashboardOutlined';
import PlaylistAddCheckCircleOutlinedIcon from '@mui/icons-material/PlaylistAddCheckCircleOutlined';
import AccountBalanceOutlinedIcon from '@mui/icons-material/AccountBalanceOutlined';
import FactCheckOutlinedIcon from '@mui/icons-material/FactCheckOutlined';
import GroupOutlinedIcon from '@mui/icons-material/GroupOutlined';
import DescriptionOutlinedIcon from '@mui/icons-material/DescriptionOutlined';
import AssessmentOutlinedIcon from '@mui/icons-material/AssessmentOutlined';
import ChevronRightOutlinedIcon from '@mui/icons-material/ChevronRightOutlined';
import ChevronLeftOutlinedIcon from '@mui/icons-material/ChevronLeftOutlined';
import ExpandMoreOutlinedIcon from '@mui/icons-material/ExpandMoreOutlined';
import { useLocation, useNavigate } from 'react-router-dom';
import { useAppLayout } from '../../layout/AppLayoutContext';
import { ROUTES } from '../../config/routes';

const FULL_WIDTH = 260;
const COLLAPSED_WIDTH = 88;

const Sidebar = ({ onFilterChange }) => {
  const [storedUser, setStoredUser] = useState(null);
  const [isExistingRecordsOpen, setIsExistingRecordsOpen] = useState(true);
  const theme = useTheme();
  const isMobile = useMediaQuery(theme.breakpoints.down('md'));
  const location = useLocation();
  const navigate = useNavigate();
  const { sidebarCollapsed, mobileOpen, closeMobileSidebar, toggleSidebarCollapsed } = useAppLayout();

  useEffect(() => {
    const user = JSON.parse(window.sessionStorage.getItem('userDet') || 'null');
    setStoredUser(user);
  }, []);

  const normalizedRole = (storedUser?.userRole || '').toLowerCase();

  const width = isMobile ? FULL_WIDTH : sidebarCollapsed ? COLLAPSED_WIDTH : FULL_WIDTH;

  useEffect(() => {
    document.documentElement.style.setProperty('--shell-sidebar-width', `${width}px`);
  }, [width]);

  const goTo = (path, options = {}) => {
    navigate(path);
    if (options.filter && onFilterChange) {
      onFilterChange(options.filter);
    }
    if (isMobile) {
      closeMobileSidebar();
    }
  };

  const menuItems = useMemo(() => {
    if (normalizedRole === 'maker') {
      return [
        { label: 'New Record', icon: <PlaylistAddCheckCircleOutlinedIcon />, path: ROUTES.MAKER_NEW },
        {
          label: 'Existing Records',
          icon: <DescriptionOutlinedIcon />,
          children: [
            { label: 'Return from Checker', path: '/datatable' },
            { label: 'Return from Admin', path: '/returnfromadmin' }
          ]
        }
      ];
    }

    if (normalizedRole === 'checker') {
      return [
        { label: 'Pending', icon: <FactCheckOutlinedIcon />, path: ROUTES.CHECKER_PENDING, filter: 'PENDING' },
        { label: 'Verified', icon: <FactCheckOutlinedIcon />, path: ROUTES.CHECKER_VERIFIED, filter: 'VERIFIED' }
      ];
    }

    return [
      { label: 'Pending', icon: <FactCheckOutlinedIcon />, path: ROUTES.ADMIN_PENDING },
      { label: 'User Management', icon: <GroupOutlinedIcon />, path: ROUTES.USER_MANAGEMENT },
      { label: 'Report', icon: <DescriptionOutlinedIcon />, path: ROUTES.ADMIN_REPORT },
      { label: 'Dashboard', icon: <DashboardOutlinedIcon />, path: ROUTES.LOAN_DATA },
      { label: 'Dashboard Charts', icon: <DashboardOutlinedIcon />, path: ROUTES.ADMIN_RISK_ASSESSMENT },
      { label: 'Green Deposit Position', icon: <AccountBalanceOutlinedIcon />, path: ROUTES.DEPOSIT_DATA }
    ];
  }, [normalizedRole]);

  const drawerContent = (
    <Box sx={{ height: '100%', display: 'flex', flexDirection: 'column' }}>
      <Box sx={{ px: 2, py: 2, minHeight: 72, display: 'flex', alignItems: 'center', justifyContent: 'space-between' }}>
        {!sidebarCollapsed || isMobile ? (
          <Typography variant="subtitle1" sx={{ fontWeight: 700, color: '#e2fbe8' }}>
            Navigation
          </Typography>
        ) : (
          <Typography variant="subtitle2" sx={{ fontWeight: 700, color: '#e2fbe8' }}>
            NAV
          </Typography>
        )}
        {!isMobile && (
          <Tooltip title={sidebarCollapsed ? 'Expand sidebar' : 'Collapse sidebar'}>
            <IconButton
              size="small"
              onClick={toggleSidebarCollapsed}
              sx={{ color: '#e2fbe8', '&:hover': { bgcolor: 'rgba(255,255,255,0.12)' } }}
            >
              {sidebarCollapsed ? <ChevronRightOutlinedIcon /> : <ChevronLeftOutlinedIcon />}
            </IconButton>
          </Tooltip>
        )}
      </Box>
      <Divider sx={{ borderColor: 'rgba(255,255,255,0.16)' }} />
      <List sx={{ pt: 1 }}>
        {menuItems.map((item) => {
          if (item.children) {
            return (
              <Box key={item.label}>
                <Tooltip title={sidebarCollapsed && !isMobile ? item.label : ''} placement="right">
                  <ListItemButton
                    onClick={() => setIsExistingRecordsOpen((prev) => !prev)}
                    sx={{
                      mx: 1,
                      mb: 0.5,
                      borderRadius: 2,
                      color: '#f8fffa',
                      '&:hover': { bgcolor: 'rgba(255,255,255,0.12)' }
                    }}
                  >
                    <ListItemIcon sx={{ minWidth: 40, color: 'inherit' }}>{item.icon}</ListItemIcon>
                    {(!sidebarCollapsed || isMobile) && <ListItemText primary={item.label} />}
                    {!sidebarCollapsed || isMobile ? (
                      isExistingRecordsOpen ? <ExpandMoreOutlinedIcon /> : <ChevronRightOutlinedIcon />
                    ) : null}
                  </ListItemButton>
                </Tooltip>
                <Collapse in={isExistingRecordsOpen && (!sidebarCollapsed || isMobile)} timeout="auto" unmountOnExit>
                  <List component="div" disablePadding>
                    {item.children.map((child) => (
                      <ListItemButton
                        key={child.label}
                        sx={{
                          pl: 5,
                          mx: 1,
                          mb: 0.5,
                          borderRadius: 2,
                          color: '#f8fffa',
                          '&.Mui-selected': {
                            bgcolor: 'rgba(255,255,255,0.2)',
                            color: '#ffffff'
                          },
                          '&.Mui-selected:hover': { bgcolor: 'rgba(255,255,255,0.24)' },
                          '&:hover': { bgcolor: 'rgba(255,255,255,0.12)' }
                        }}
                        selected={location.pathname.toLowerCase() === child.path.toLowerCase()}
                        onClick={() => goTo(child.path)}
                      >
                        <ListItemText primary={child.label} />
                      </ListItemButton>
                    ))}
                  </List>
                </Collapse>
              </Box>
            );
          }

          const selected = location.pathname.toLowerCase() === item.path.toLowerCase();
          return (
            <Tooltip key={item.label} title={sidebarCollapsed && !isMobile ? item.label : ''} placement="right">
              <ListItemButton
                selected={selected}
                onClick={() => goTo(item.path, { filter: item.filter })}
                sx={{
                  mx: 1,
                  mb: 0.5,
                  borderRadius: 2,
                  color: '#f8fffa',
                  '& .MuiListItemIcon-root': { color: 'inherit' },
                  '&.Mui-selected': {
                    bgcolor: 'rgba(255,255,255,0.2)',
                    color: '#ffffff'
                  },
                  '&.Mui-selected:hover': { bgcolor: 'rgba(255,255,255,0.24)' },
                  '&:hover': { bgcolor: 'rgba(255,255,255,0.12)' }
                }}
              >
                <ListItemIcon sx={{ minWidth: 40 }}>{item.icon}</ListItemIcon>
                {(!sidebarCollapsed || isMobile) && <ListItemText primary={item.label} />}
              </ListItemButton>
            </Tooltip>
          );
        })}
      </List>
    </Box>
  );

  return (
    <>
      <Drawer
        variant={isMobile ? 'temporary' : 'permanent'}
        open={isMobile ? mobileOpen : true}
        onClose={closeMobileSidebar}
        ModalProps={{ keepMounted: true }}
        sx={{
          '& .MuiDrawer-paper': {
            top: isMobile ? 0 : 'var(--shell-header-height, 76px)',
            height: isMobile
              ? '100%'
              : 'calc(100% - var(--shell-header-height, 76px) - var(--shell-footer-height, 52px))',
            width,
            transition: theme.transitions.create('width', {
              easing: theme.transitions.easing.sharp,
              duration: theme.transitions.duration.enteringScreen
            }),
            borderRight: '1px solid rgba(19, 75, 42, 0.2)',
            backgroundImage: theme.palette.mode === 'dark'
              ? 'linear-gradient(180deg, #1a4d2e 0%, #134b2a 100%)'
              : 'linear-gradient(180deg, #0D3520 0%, #134B2A 100%)',
            boxShadow: '0 2px 8px rgba(0, 0, 0, 0.1)'
          }
        }}
      >
        {drawerContent}
      </Drawer>
    </>
  );
};

export default Sidebar;
