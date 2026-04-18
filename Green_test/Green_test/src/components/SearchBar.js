import React, { useState } from 'react';
import { Box, TextField, InputAdornment, IconButton, Tooltip } from '@mui/material';
import SearchIcon from '@mui/icons-material/Search';
import ClearIcon from '@mui/icons-material/Clear';

const SearchBar = ({ onSearch, placeholder = "Search by Account Number" }) => {
  const [searchValue, setSearchValue] = useState('');

  const handleSearch = (value) => {
    setSearchValue(value);
    onSearch(value);
  };

  const handleClear = () => {
    setSearchValue('');
    onSearch('');
  };

  return (
    <Box
      sx={{
        display: 'flex',
        gap: 2,
        mb: 3,
        p: 2,
        background: 'linear-gradient(135deg, #ecfdf3 0%, #dcfce7 100%)',
        borderRadius: 2,
        border: '1px solid rgba(34, 197, 94, 0.2)',
        boxShadow: '0 4px 12px rgba(13, 53, 32, 0.08)',
        alignItems: 'center'
      }}
    >
      <TextField
        fullWidth
        placeholder={placeholder}
        value={searchValue}
        onChange={(e) => handleSearch(e.target.value)}
        variant="outlined"
        size="small"
        InputProps={{
          startAdornment: (
            <InputAdornment position="start">
              <SearchIcon sx={{ color: '#0d3520', fontWeight: 'bold' }} />
            </InputAdornment>
          ),
          endAdornment: searchValue && (
            <InputAdornment position="end">
              <Tooltip title="Clear search">
                <IconButton
                  onClick={handleClear}
                  edge="end"
                  size="small"
                  sx={{ color: '#0d3520' }}
                >
                  <ClearIcon />
                </IconButton>
              </Tooltip>
            </InputAdornment>
          ),
        }}
        sx={{
          '& .MuiOutlinedInput-root': {
            backgroundColor: '#ffffff',
            border: '1.5px solid #22c55e',
            borderRadius: '10px',
            fontWeight: 600,
            transition: 'all 0.3s ease',
            '&:hover': {
              borderColor: '#16a34a',
              boxShadow: '0 4px 12px rgba(34, 197, 94, 0.15)',
            },
            '&.Mui-focused': {
              borderColor: '#0d3520',
              boxShadow: '0 0 0 4px rgba(34, 197, 94, 0.15)',
            },
          },
          '& .MuiOutlinedInput-input': {
            fontSize: '0.95rem',
            fontWeight: 600,
            color: '#0d3520',
            '&::placeholder': {
              color: '#9ca3af',
              opacity: 0.7,
            },
          },
        }}
      />
    </Box>
  );
};

export default SearchBar;
