import React, { createContext, useContext, useMemo, useState } from 'react';

const AppLayoutContext = createContext({
  sidebarCollapsed: false,
  mobileOpen: false,
  toggleSidebarCollapsed: () => {},
  toggleMobileSidebar: () => {},
  closeMobileSidebar: () => {}
});

export const useAppLayout = () => useContext(AppLayoutContext);

export const AppLayoutProvider = ({ children }) => {
  const [sidebarCollapsed, setSidebarCollapsed] = useState(false);
  const [mobileOpen, setMobileOpen] = useState(false);

  const value = useMemo(
    () => ({
      sidebarCollapsed,
      mobileOpen,
      toggleSidebarCollapsed: () => setSidebarCollapsed((prev) => !prev),
      toggleMobileSidebar: () => setMobileOpen((prev) => !prev),
      closeMobileSidebar: () => setMobileOpen(false)
    }),
    [mobileOpen, sidebarCollapsed]
  );

  return <AppLayoutContext.Provider value={value}>{children}</AppLayoutContext.Provider>;
};
