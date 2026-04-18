import React from 'react';
import { Box, Typography } from '@mui/material';

const Footer = ({ sidebarWidth = 0, footerHeight = 52 }) => {
  return (
    <Box
      component="footer"
      sx={{
        position: 'fixed',
        left: 0,
        right: 0,
        bottom: 0,
        zIndex: (theme) => theme.zIndex.appBar - 1,
        height: `${footerHeight}px`,
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'center',
        px: 2,
        borderTop: '1px solid rgba(19, 75, 42, 0.2)',
        backgroundImage: (theme) => 
          theme.palette.mode === 'dark'
            ? 'linear-gradient(180deg, #1a4d2e 0%, #134b2a 100%)'
            : 'linear-gradient(180deg, #0D3520 0%, #134B2A 100%)',
        color: '#ffffff',
        boxShadow: '0 -2px 8px rgba(0, 0, 0, 0.1)'
      }}
    >
      <Typography variant="body2" sx={{ color: '#ffffff'}} align="center">
        Copyright © {new Date().getFullYear()} Bank of Baroda. All rights reserved.
      </Typography>
    </Box>
  );
};

export default Footer;
