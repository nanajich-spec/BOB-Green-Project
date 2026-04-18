import React from 'react';

const DataTableWrapper = ({ columns = [], data = [], title, searchable = false, pagination = true, onSearch, loading = false }) => {
  // Wrapper component for DataTable - delegates to existing DataTable implementation
  if (loading) return <div>Loading table data...</div>;
  if (!data || data.length === 0) return <div>No data available</div>;

  return (
    <div style={{ padding: '20px' }}>
      {title && <h3>{title}</h3>}
      <div style={{ overflowX: 'auto' }}>
        <table style={{ width: '100%', borderCollapse: 'collapse' }}>
          <thead>
            <tr style={{ backgroundColor: '#134B2A', color: '#fff' }}>
              {columns.map(col => (
                <th key={col.field} style={{ padding: '12px', textAlign: 'left' }}>
                  {col.label}
                </th>
              ))}
            </tr>
          </thead>
          <tbody>
            {data.map((row, idx) => (
              <tr key={idx} style={{ borderBottom: '1px solid #e0e0e0', hover: { backgroundColor: '#f5f5f5' } }}>
                {columns.map(col => (
                  <td key={col.field} style={{ padding: '12px' }}>
                    {row[col.field]}
                  </td>
                ))}
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default DataTableWrapper;
