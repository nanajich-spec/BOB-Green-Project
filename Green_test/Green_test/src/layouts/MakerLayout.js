import React from 'react';
import { Header } from '../components';
import { Sidebar } from '../components';
import { Footer } from '../components';
import { Breadcrumbs } from '../components';

const MakerLayout = ({ children, title, breadcrumbs }) => {
  return (
    <div style={{ display: 'flex', flexDirection: 'column', minHeight: '100vh' }}>
      <Header />
      <div style={{ display: 'flex', flex: 1 }}>
        <Sidebar />
        <main style={{ flex: 1, padding: '20px', overflow: 'auto' }}>
          {breadcrumbs && <Breadcrumbs items={breadcrumbs} />}
          {title && <h1 style={{ marginBottom: '20px', fontSize: '1.25rem' }}>{title}</h1>}
          <div>
            {children}
          </div>
        </main>
      </div>
      <Footer />
    </div>
  );
};

export default MakerLayout;
