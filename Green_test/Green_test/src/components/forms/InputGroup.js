import React from 'react';

const InputGroup = ({ label, name, type = 'text', value, onChange, required = false, disabled = false, error }) => {
  return (
    <div style={{ marginBottom: '16px' }}>
      {label && (
        <label style={{ display: 'block', marginBottom: '6px', fontWeight: 500 }}>
          {label}
          {required && <span style={{ color: '#E74C3C' }}>*</span>}
        </label>
      )}
      <input
        type={type}
        name={name}
        value={value}
        onChange={onChange}
        disabled={disabled}
        style={{
          width: '100%',
          padding: '10px 12px',
          border: error ? '1px solid #E74C3C' : '1px solid #ddd',
          borderRadius: '4px',
          fontSize: '14px',
          opacity: disabled ? 0.6 : 1
        }}
      />
      {error && <span style={{ color: '#E74C3C', fontSize: '12px', marginTop: '4px', display: 'block' }}>{error}</span>}
    </div>
  );
};

export default InputGroup;
