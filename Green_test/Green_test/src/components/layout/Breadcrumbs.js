import React from 'react';
import { useNavigate } from 'react-router-dom';

const Breadcrumbs = ({ items = [] }) => {
  const navigate = useNavigate();

  if (!items || items.length === 0) return null;

  return (
    <nav style={{ marginBottom: '20px' }}>
      <ol style={{ display: 'flex', listStyle: 'none', padding: 0, margin: 0 }}>
        {items.map((item, index) => (
          <li key={index} style={{ display: 'flex', alignItems: 'center' }}>
            {item.href ? (
              <>
                <a
                  href={item.href}
                  onClick={(e) => {
                    e.preventDefault();
                    navigate(item.href);
                  }}
                  style={{ color: '#0D3520', textDecoration: 'none', marginRight: '8px' }}
                >
                  {item.label}
                </a>
                {index < items.length - 1 && <span style={{ marginRight: '8px', color: '#999' }}>/</span>}
              </>
            ) : (
              <>
                <span style={{ color: '#666', marginRight: '8px' }}>{item.label}</span>
                {index < items.length - 1 && <span style={{ marginRight: '8px', color: '#999' }}>/</span>}
              </>
            )}
          </li>
        ))}
      </ol>
    </nav>
  );
};

export default Breadcrumbs;
