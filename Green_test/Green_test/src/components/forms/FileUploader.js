import React from 'react';

const FileUploader = ({ label, onFileSelect, accept = '.pdf,.doc,.docx' }) => {
  const [fileName, setFileName] = React.useState('');

  const handleChange = (e) => {
    const file = e.target.files?.[0];
    if (file) {
      setFileName(file.name);
      onFileSelect?.(file);
    }
  };

  return (
    <div style={{ marginBottom: '16px' }}>
      {label && <label style={{ display: 'block', marginBottom: '6px', fontWeight: 500 }}>{label}</label>}
      <div style={{ display: 'flex', gap: '12px', alignItems: 'center' }}>
        <input
          type="file"
          accept={accept}
          onChange={handleChange}
          style={{ flex: 1 }}
        />
        {fileName && <span style={{ color: '#27AE60', fontSize: '14px' }}>✓ {fileName}</span>}
      </div>
    </div>
  );
};

export default FileUploader;
