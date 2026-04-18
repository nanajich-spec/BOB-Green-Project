import React, { useMemo, useState } from 'react';
import {
  Avatar,
  Box,
  Button,
  Card,
  CardActionArea,
  CardContent,
  Checkbox,
  Divider,
  Fade,
  FormControlLabel,
  IconButton,
  Link,
  Stack,
  TextField,
  Tooltip,
  Typography,
  useMediaQuery,
  useTheme,
  Paper,
  InputAdornment,
  CircularProgress
} from '@mui/material';
import { keyframes } from '@emotion/react';
import ManageAccountsOutlinedIcon from '@mui/icons-material/ManageAccountsOutlined';
import AccountTreeOutlinedIcon from '@mui/icons-material/AccountTreeOutlined';
import AssignmentTurnedInOutlinedIcon from '@mui/icons-material/AssignmentTurnedInOutlined';
import BoltIcon from '@mui/icons-material/Bolt';
import AccountBalanceIcon from '@mui/icons-material/AccountBalance';
import DescriptionOutlinedIcon from '@mui/icons-material/DescriptionOutlined';
import TrendingUpIcon from '@mui/icons-material/TrendingUp';
import SecurityOutlinedIcon from '@mui/icons-material/SecurityOutlined';
import PieChartOutlinedIcon from '@mui/icons-material/PieChartOutlined';
import TwitterIcon from '@mui/icons-material/Twitter';
import FacebookIcon from '@mui/icons-material/Facebook';
import InstagramIcon from '@mui/icons-material/Instagram';
import LinkedInIcon from '@mui/icons-material/LinkedIn';
import VisibilityIcon from '@mui/icons-material/Visibility';
import VisibilityOffIcon from '@mui/icons-material/VisibilityOff';
import LockIcon from '@mui/icons-material/Lock';
import PersonIcon from '@mui/icons-material/Person';
import { useNavigate } from 'react-router-dom';
import logo from './bob_logo.png';

/* ── keyframes ── */
const float = keyframes`
  0%,100% { transform: translateY(0) }
  50%     { transform: translateY(-10px) }
`;
const pulse = keyframes`
  0%,100% { opacity: .65 }
  50%     { opacity: 1 }
`;
const glow = keyframes`
  0%,100% { box-shadow: 0 0 18px 4px rgba(76,175,80,.25) }
  50%     { box-shadow: 0 0 32px 8px rgba(76,175,80,.45) }
`;

/* ── role config ── */
const ROLE_CONFIG = {
  Maker: {
    route: '/Maker',
    helper: 'Create and maintain new green finance records.',
    icon: <AccountTreeOutlinedIcon />
  },
  Checker: {
    route: '/verify',
    helper: 'Review submissions and validate pending records.',
    icon: <AssignmentTurnedInOutlinedIcon />
  },
  Admin: {
    route: '/admin',
    helper: 'Approve workflows and manage users/reports.',
    icon: <ManageAccountsOutlinedIcon />
  }
};

/* ── decorative sidebar icons ── */
const SIDEBAR_ICONS = [
  { Icon: SecurityOutlinedIcon,    top: '14%', left: '12%', size: 28, delay: 0 },
  { Icon: DescriptionOutlinedIcon, top: '10%', left: '55%', size: 24, delay: 0.8 },
  { Icon: PieChartOutlinedIcon,    top: '28%', left: '38%', size: 22, delay: 1.6 },
  { Icon: TrendingUpIcon,          top: '24%', left: '72%', size: 26, delay: 0.4 },
  { Icon: AccountBalanceIcon,      top: '50%', left: '10%', size: 22, delay: 1.2 },
];

/* ====================================================================== */
const Login = () => {
  const navigate  = useNavigate();
  const theme     = useTheme();
  const isDesktop = useMediaQuery(theme.breakpoints.up('md'));

  const [userId, setUserId]         = useState('');
  const [password, setPassword]     = useState('');
  const [showPassword, setShowPassword] = useState(false);
  const [rememberMe, setRememberMe] = useState(false);
  const [errors, setErrors]         = useState({});
  const [selectedRole, setSelectedRole] = useState('Maker');
  const [isLoading, setIsLoading] = useState(false);

  const upperUserId = useMemo(() => userId.toUpperCase(), [userId]);

  /* ── handlers ── */
  const handleUseridChange = (e) => {
    const v = e.target.value;
    if (v.length <= 8) { setUserId(v); setErrors((p) => ({ ...p, userId: '' })); }
  };

  const validate = () => {
    const e = {};
    if (!upperUserId.trim()) e.userId = 'Domain ID is required';
    if (!password.trim()) e.password = 'Password is required';
    setErrors(e);
    return Object.keys(e).length === 0;
  };

  const handleRoleLogin = (role, skipValidation = false) => {
    if (!skipValidation && !validate()) return;
    const route = ROLE_CONFIG[role]?.route;
    if (!route) return;
    window.sessionStorage.setItem(
      'userDet',
      JSON.stringify({ userId: upperUserId || 'GUEST', userRole: role })
    );
    navigate(route);
  };

  /* ================================================================== */
  /*                      DECORATIVE LEFT SIDEBAR                       */
  /* ================================================================== */
  const sidebar = (
    <Box
      aria-hidden="true"
      sx={{
        position: 'relative',
        width: { md: '42%' },
        minHeight: '100vh',
        background: `linear-gradient(160deg, #0D3520 0%, #134B2A 40%, #1B6B3A 75%, #0ea5e9 100%)`,
        display: 'flex',
        flexDirection: 'column',
        alignItems: 'center',
        justifyContent: 'center',
        overflow: 'hidden',
        p: 4,
      }}
    >
      {/* floating icons */}
      {SIDEBAR_ICONS.map(({ Icon, top, left, size, delay }, i) => (
        <Box
          key={i}
          sx={{
            position: 'absolute', top, left,
            color: 'rgba(255,255,255,0.35)',
            animation: `${float} 4s ease-in-out ${delay}s infinite`,
            '@media (prefers-reduced-motion: reduce)': { animation: 'none' }
          }}
        >
          <Icon sx={{ fontSize: size }} />
        </Box>
      ))}

      {/* central hero emblem */}
      <Box
        sx={{
          width: 130, height: 130,
          borderRadius: '50%',
          background: 'radial-gradient(circle, rgba(76,175,80,0.4) 0%, rgba(76,175,80,0.05) 70%)',
          display: 'flex', alignItems: 'center', justifyContent: 'center',
          animation: `${glow} 3s ease-in-out infinite`,
          mb: 4,
          '@media (prefers-reduced-motion: reduce)': { animation: 'none' }
        }}
      >
        <Box
          sx={{
            width: 80, height: 80,
            borderRadius: '50%',
            bgcolor: 'rgba(255,255,255,0.12)',
            display: 'flex', alignItems: 'center', justifyContent: 'center',
            border: '2px solid rgba(255,255,255,0.18)',
          }}
        >
          <BoltIcon sx={{ fontSize: 44, color: '#4caf50' }} />
        </Box>
      </Box>

      {/* tagline */}
      <Typography variant="h5" sx={{ color: '#fff', fontWeight: 700, textAlign: 'center', mb: 1, letterSpacing: 0.5 }}>
        Green Finance Portal
      </Typography>
      <Typography variant="body2" sx={{ color: 'rgba(255,255,255,0.7)', textAlign: 'center', maxWidth: 260, lineHeight: 1.6 }}>
        Powering sustainable growth with eco-friendly financial instruments
      </Typography>

      {/* footer */}
      <Typography variant="caption" sx={{ color: 'rgba(255,255,255,0.4)', position: 'absolute', bottom: 24 }}>
        © Bank of Baroda {new Date().getFullYear()}
      </Typography>
    </Box>
  );

  /* ================================================================== */
  /*                        RIGHT CONTENT PANEL                         */
  /* ================================================================== */
  const content = (
    <Box
      component="main"
      sx={{
        flex: 1,
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'center',
        minHeight: '100vh',
        bgcolor: 'background.default',
        overflow: 'auto',
        py: { xs: 3, sm: 5 },
        px: { xs: 2, sm: 4, md: 6 },
      }}
    >
      <Box sx={{ width: '100%', maxWidth: 460 }}>
        {/* ── Logo ── */}
        <Stack alignItems="center" sx={{ mb: 3 }}>
          <Box
            sx={{
              px: 2.5, py: 1.2,
              borderRadius: 2,
              border: '1px solid',
              borderColor: 'divider',
              bgcolor: 'background.paper',
              display: 'inline-flex',
              alignItems: 'center',
              justifyContent: 'center',
              boxShadow: '0 1px 4px rgba(0,0,0,0.06)',
            }}
          >
            <Box
              component="img"
              src={logo}
              alt="Bank of Baroda Logo"
              sx={{ width: 200, maxHeight: 56, objectFit: 'contain' }}
            />
          </Box>
        </Stack>

        {/* ── Heading ── */}
        <Box sx={{ textAlign: 'center', mb: 3 }}>
          <Typography
            variant="h4"
            component="h1"
            sx={{
              color: 'primary.main',
              fontWeight: 800,
              textDecoration: 'underline',
              textUnderlineOffset: 5,
              textDecorationColor: 'rgba(19,75,42,0.35)',
              mb: 0.5,
            }}
          >
            Green Project
          </Typography>
          <Typography variant="body2" color="text.secondary">
            Secure access for Maker, Checker and Admin roles
          </Typography>
        </Box>

        {/* ── Login Form with Advanced Layout ── */}
        <Paper
          elevation={0}
          sx={{
            p: 2.5,
            mb: 2.5,
            border: '1px solid',
            borderColor: 'divider',
            borderRadius: 2,
            background: 'linear-gradient(135deg, rgba(19,75,42,0.04) 0%, rgba(21,101,192,0.04) 100%)',
            backdropFilter: 'blur(10px)',
          }}
        >
          <Box component="form" noValidate autoComplete="off" sx={{ mb: 0 }}>
            <Stack spacing={2}>
              {/* Domain ID/Email Field with Icon */}
              <TextField
                fullWidth
                label="Domain ID / Email"
                placeholder="Enter your domain id"
                value={upperUserId}
                onChange={handleUseridChange}
                inputProps={{ maxLength: 8, 'aria-label': 'Domain ID' }}
                error={!!errors.userId}
                helperText={errors.userId}
                aria-invalid={!!errors.userId}
                InputProps={{
                  startAdornment: (
                    <InputAdornment position="start">
                      <PersonIcon sx={{ color: 'primary.main', mr: 0.5 }} />
                    </InputAdornment>
                  ),
                }}
                sx={{
                  '& .MuiOutlinedInput-root': {
                    transition: 'all 0.3s ease',
                    '&:hover': {
                      boxShadow: '0 2px 8px rgba(19,75,42,0.1)',
                    },
                    '&.Mui-focused': {
                      boxShadow: '0 4px 16px rgba(19,75,42,0.15)',
                    }
                  }
                }}
              />
              
              {/* Password Field with Show/Hide Toggle */}
              <TextField
                fullWidth
                type={showPassword ? 'text' : 'password'}
                label="Password"
                placeholder="Enter your secure password"
                value={password}
                onChange={(e) => { setPassword(e.target.value); setErrors((p) => ({ ...p, password: '' })); }}
                error={!!errors.password}
                helperText={errors.password}
                inputProps={{ 'aria-label': 'Password' }}
                aria-invalid={!!errors.password}
                InputProps={{
                  startAdornment: (
                    <InputAdornment position="start">
                      <LockIcon sx={{ color: 'primary.main', mr: 0.5 }} />
                    </InputAdornment>
                  ),
                  endAdornment: (
                    <InputAdornment position="end">
                      <IconButton
                        onClick={() => setShowPassword(!showPassword)}
                        edge="end"
                        size="small"
                        sx={{ color: 'action.active' }}
                      >
                        {showPassword ? <VisibilityOffIcon fontSize="small" /> : <VisibilityIcon fontSize="small" />}
                      </IconButton>
                    </InputAdornment>
                  ),
                }}
                sx={{
                  '& .MuiOutlinedInput-root': {
                    transition: 'all 0.3s ease',
                    '&:hover': {
                      boxShadow: '0 2px 8px rgba(19,75,42,0.1)',
                    },
                    '&.Mui-focused': {
                      boxShadow: '0 4px 16px rgba(19,75,42,0.15)',
                    }
                  }
                }}
              />
            </Stack>
          </Box>
        </Paper>

        {/* ── Security Features & Remember Me ── */}
        <Stack direction={{ xs: 'column', sm: 'row' }} alignItems={{ xs: 'flex-start', sm: 'center' }} justifyContent="space-between" sx={{ mb: 2.5, gap: 1.5 }}>
          <FormControlLabel
            control={
              <Checkbox
                size="small"
                checked={rememberMe}
                onChange={(e) => setRememberMe(e.target.checked)}
                sx={{ color: 'primary.main', '&.Mui-checked': { color: 'primary.main' } }}
              />
            }
            label={<Typography variant="body2" sx={{ fontWeight: 500 }}>Remember me on this device</Typography>}
          />
          <Link
            href="#"
            underline="hover"
            variant="body2"
            sx={{ color: 'secondary.main', fontWeight: 600, cursor: 'pointer', whiteSpace: 'nowrap' }}
            onClick={(e) => e.preventDefault()}
          >
            Forgot password?
          </Link>
        </Stack>

        {/* ── Login Button with Loading State ── */}
        <Button
          fullWidth
          variant="contained"
          color="primary"
          size="large"
          onClick={() => { 
            setIsLoading(true);
            setTimeout(() => handleRoleLogin(selectedRole), 400);
          }}
          disabled={isLoading}
          sx={{
            py: 1.5,
            fontSize: '1rem',
            fontWeight: 700,
            borderRadius: 2,
            mb: 3,
            position: 'relative',
            transition: 'all 0.3s ease',
            background: (theme) =>
              theme.palette.mode === 'dark'
                ? 'linear-gradient(135deg, #134B2A 0%, #0D3520 100%)'
                : 'linear-gradient(135deg, #0D3520 0%, #1B6B3A 100%)',
            '&:hover:not(:disabled)': {
              transform: 'translateY(-2px)',
              boxShadow: '0 8px 24px rgba(19,75,42,0.25)',
            },
            '&:disabled': {
              opacity: 0.7,
            }
          }}
        >
          {isLoading ? (
            <Stack direction="row" alignItems="center" spacing={1}>
              <CircularProgress size={20} sx={{ color: '#fff' }} />
              <span>Signing in...</span>
            </Stack>
          ) : (
            'Sign In'
          )}
        </Button>

        {/* ── Role Selection Cards ── */}
        <Box component="section" sx={{ mb: 3 }}>
          <Typography variant="subtitle1" sx={{ fontWeight: 700, mb: 1.5, color: 'text.primary' }}>
            Select your role
          </Typography>

          <Stack spacing={1.5}>
            {Object.entries(ROLE_CONFIG).map(([role, cfg]) => {
              const isActive = selectedRole === role;
              return (
                <Card
                  key={role}
                  elevation={isActive ? 4 : 1}
                  sx={{
                    border: '1px solid',
                    borderColor: isActive ? 'primary.main' : 'divider',
                    transition: 'all 0.25s ease',
                    transform: isActive ? 'scale(1.015)' : 'scale(1)',
                    '&:hover': {
                      elevation: 4,
                      transform: 'scale(1.02)',
                      borderColor: 'primary.light',
                      boxShadow: '0 4px 20px rgba(19,75,42,0.12)',
                    },
                    '@media (prefers-reduced-motion: reduce)': {
                      transition: 'none', transform: 'none'
                    }
                  }}
                >
                  <CardActionArea
                    onClick={() => setSelectedRole(role)}
                    sx={{ p: 0 }}
                  >
                    <CardContent sx={{ py: 1.5, px: 2 }}>
                      <Stack direction="row" spacing={1.5} alignItems="center">
                        <Avatar
                          sx={{
                            width: 38, height: 38,
                            bgcolor: isActive ? 'primary.main' : 'action.hover',
                            color: isActive ? '#fff' : 'primary.main',
                            transition: 'all 0.25s ease',
                            animation: isActive ? `${pulse} 2s ease-in-out infinite` : 'none',
                            '@media (prefers-reduced-motion: reduce)': { animation: 'none' }
                          }}
                        >
                          {cfg.icon}
                        </Avatar>
                        <Box sx={{ flex: 1, minWidth: 0 }}>
                          <Typography variant="subtitle2" sx={{ fontWeight: 700 }}>{role}</Typography>
                          <Typography variant="caption" color="text.secondary" noWrap>{cfg.helper}</Typography>
                        </Box>
                        <Button
                          size="small"
                          variant={isActive ? 'contained' : 'outlined'}
                          color="success"
                          onClick={(e) => { e.stopPropagation(); handleRoleLogin(role, true); }}
                          sx={{ minWidth: 90, fontWeight: 700, borderRadius: 2, textTransform: 'none' }}
                        >
                          Login {role}
                        </Button>
                      </Stack>
                    </CardContent>
                  </CardActionArea>
                </Card>
              );
            })}
          </Stack>
        </Box>

        {/* ── Social footer ── */}
        <Stack direction="row" justifyContent="center" spacing={1} sx={{ mb: 1 }}>
          {[
            { Icon: TwitterIcon,   href: 'https://twitter.com/bankaboroda' },
            { Icon: FacebookIcon,  href: 'https://facebook.com/bankofbaroda' },
            { Icon: InstagramIcon, href: 'https://instagram.com/bankofbaroda' },
            { Icon: LinkedInIcon,  href: 'https://linkedin.com/company/bank-of-baroda' },
          ].map(({ Icon, href }) => (
            <IconButton
              key={href}
              component="a"
              href={href}
              target="_blank"
              rel="noopener noreferrer"
              size="small"
              sx={{ color: 'text.secondary', '&:hover': { color: 'primary.main' } }}
              aria-label={`Visit ${href.split('/').pop()}`}
            >
              <Icon fontSize="small" />
            </IconButton>
          ))}
        </Stack>

        <Typography variant="caption" align="center" display="block" color="text.secondary">
          Copyright © {new Date().getFullYear()} Bank of Baroda. All rights reserved.
        </Typography>
      </Box>
    </Box>
  );

  /* ================================================================== */
  /*                          PAGE RENDER                               */
  /* ================================================================== */
  return (
    <Fade in timeout={600}>
      <Box
        sx={{
          display: 'flex',
          minHeight: '100vh',
          bgcolor: 'background.default',
          '@media (prefers-reduced-motion: reduce)': { transition: 'none' }
        }}
      >
        {isDesktop && sidebar}
        {content}
      </Box>
    </Fade>
  );
};

export default Login;