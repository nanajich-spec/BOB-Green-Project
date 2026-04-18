import React, { createContext, useState, useCallback } from 'react';

export const LayoutContext = createContext();

export const LayoutProvider = ({ children }) => {
  const [sidebarOpen, setSidebarOpen] = useState(() => {
    try {
      const saved = localStorage.getItem('sidebarOpen');
      return saved ? JSON.parse(saved) : true;
    } catch {
      return true;
    }
  });

  const [mobileMenuOpen, setMobileMenuOpen] = useState(false);

  const toggleSidebar = useCallback(() => {
    setSidebarOpen(prev => {
      const newState = !prev;
      localStorage.setItem('sidebarOpen', JSON.stringify(newState));
      return newState;
    });
  }, []);

  const closeSidebar = useCallback(() => {
    setSidebarOpen(false);
    localStorage.setItem('sidebarOpen', JSON.stringify(false));
  }, []);

  const openSidebar = useCallback(() => {
    setSidebarOpen(true);
    localStorage.setItem('sidebarOpen', JSON.stringify(true));
  }, []);

  const toggleMobileMenu = useCallback(() => {
    setMobileMenuOpen(prev => !prev);
  }, []);

  const closeMobileMenu = useCallback(() => {
    setMobileMenuOpen(false);
  }, []);

  const value = {
    sidebarOpen,
    mobileMenuOpen,
    toggleSidebar,
    closeSidebar,
    openSidebar,
    toggleMobileMenu,
    closeMobileMenu
  };

  return (
    <LayoutContext.Provider value={value}>
      {children}
    </LayoutContext.Provider>
  );
};
