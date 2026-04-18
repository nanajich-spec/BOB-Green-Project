import React from 'react';

const SearchBar = ({ placeholder = 'Search...', onSearch, onChange, clearable = true }) => {
  const [value, setValue] = React.useState('');

  const handleChange = (e) => {
    const newValue = e.target.value;
    setValue(newValue);
    onChange?.(newValue);
    onSearch?.(newValue);
  };

  const handleClear = () => {
    setValue('');
    onChange?.('');
    onSearch?.('');
  };

  return (
    <div style={{ display: 'flex', gap: '8px', marginBottom: '16px' }}>
      <input
        type="text"
        placeholder={placeholder}
        value={value}
        onChange={handleChange}
        style={{
          flex: 1,
          padding: '10px 12px',
          border: '1px solid #ddd',
          borderRadius: '4px',
          fontSize: '14px'
        }}
      />
      {clearable && value && (
        <button
          onClick={handleClear}
          style={{
            padding: '10px 16px',
            backgroundColor: '#0D3520',
            color: '#fff',
            border: 'none',
            borderRadius: '4px',
            cursor: 'pointer'
          }}
        >
          Clear
        </button>
      )}
    </div>
  );
};

export default SearchBar;
