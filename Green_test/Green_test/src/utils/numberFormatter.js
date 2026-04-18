export const formatCurrency = (value, currency = 'INR') => {
  try {
    const num = parseFloat(value);
    if (isNaN(num)) return '₹0.00';
    
    return new Intl.NumberFormat('en-IN', {
      style: 'currency',
      currency: currency,
      minimumFractionDigits: 2,
      maximumFractionDigits: 2
    }).format(num);
  } catch {
    return '₹0.00';
  }
};

export const formatNumber = (value, decimals = 0) => {
  try {
    const num = parseFloat(value);
    if (isNaN(num)) return '0';
    
    return new Intl.NumberFormat('en-IN', {
      minimumFractionDigits: decimals,
      maximumFractionDigits: decimals
    }).format(num);
  } catch {
    return '0';
  }
};

export const formatPercentage = (value, decimals = 2) => {
  try {
    const num = parseFloat(value);
    if (isNaN(num)) return '0%';
    
    return new Intl.NumberFormat('en-IN', {
      style: 'percent',
      minimumFractionDigits: decimals,
      maximumFractionDigits: decimals
    }).format(num / 100);
  } catch {
    return '0%';
  }
};
