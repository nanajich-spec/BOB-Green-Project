import React from 'react';

const FormSection = ({ title, children, editable = false, onEdit, onSave, onCancel }) => {
  const [isEditing, setIsEditing] = React.useState(false);

  const handleEdit = () => {
    setIsEditing(true);
    onEdit?.();
  };

  const handleSave = () => {
    setIsEditing(false);
    onSave?.();
  };

  return (
    <div style={{ marginBottom: '24px', padding: '16px', border: '1px solid #e0e0e0', borderRadius: '8px' }}>
      <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginBottom: '16px' }}>
        <h3>{title}</h3>
        {editable && (
          <button
            onClick={isEditing ? handleSave : handleEdit}
            style={{
              padding: '8px 16px',
              backgroundColor: isEditing ? '#27AE60' : '#0D3520',
              color: '#fff',
              border: 'none',
              borderRadius: '4px',
              cursor: 'pointer'
            }}
          >
            {isEditing ? 'Save' : 'Edit'}
          </button>
        )}
      </div>
      <div style={{ opacity: isEditing ? 1 : 0.7 }}>
        {children}
      </div>
    </div>
  );
};

export default FormSection;
