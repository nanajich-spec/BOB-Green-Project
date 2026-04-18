import React from 'react';

const TablePagination = ({ currentPage = 1, pageSize = 10, total = 0, onPageChange, onPageSizeChange }) => {
  const totalPages = Math.ceil(total / pageSize) || 1;

  return (
    <div style={{ display: 'flex', justifyContent: 'space-between', alignItems: 'center', marginTop: '16px', padding: '12px', borderTop: '1px solid #e0e0e0' }}>
      <div>
        <span>Page {currentPage} of {totalPages}</span>
        <select value={pageSize} onChange={(e) => onPageSizeChange?.(parseInt(e.target.value))} style={{ marginLeft: '12px' }}>
          <option value={5}>5 per page</option>
          <option value={10}>10 per page</option>
          <option value={25}>25 per page</option>
        </select>
      </div>
      <div style={{ display: 'flex', gap: '8px' }}>
        <button
          onClick={() => onPageChange?.(currentPage - 1)}
          disabled={currentPage === 1}
          style={{
            padding: '8px 12px',
            backgroundColor: currentPage === 1 ? '#ccc' : '#0D3520',
            color: '#fff',
            border: 'none',
            borderRadius: '4px',
            cursor: currentPage === 1 ? 'default' : 'pointer'
          }}
        >
          Previous
        </button>
        <button
          onClick={() => onPageChange?.(currentPage + 1)}
          disabled={currentPage >= totalPages}
          style={{
            padding: '8px 12px',
            backgroundColor: currentPage >= totalPages ? '#ccc' : '#0D3520',
            color: '#fff',
            border: 'none',
            borderRadius: '4px',
            cursor: currentPage >= totalPages ? 'default' : 'pointer'
          }}
        >
          Next
        </button>
      </div>
    </div>
  );
};

export default TablePagination;
