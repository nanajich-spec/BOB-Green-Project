export const formatDate = (date, format = 'DD/MM/YYYY') => {
  try {
    const d = new Date(date);
    if (isNaN(d.getTime())) return '';

    const day = String(d.getDate()).padStart(2, '0');
    const month = String(d.getMonth() + 1).padStart(2, '0');
    const year = d.getFullYear();
    const hours = String(d.getHours()).padStart(2, '0');
    const minutes = String(d.getMinutes()).padStart(2, '0');
    const seconds = String(d.getSeconds()).padStart(2, '0');

    const formatMap = {
      'DD/MM/YYYY': `${day}/${month}/${year}`,
      'YYYY-MM-DD': `${year}-${month}-${day}`,
      'MM/DD/YYYY': `${month}/${day}/${year}`,
      'DD MMM YYYY': `${day} ${getMonthName(d.getMonth())} ${year}`,
      'DD/MM/YYYY HH:MM': `${day}/${month}/${year} ${hours}:${minutes}`,
      'DD/MM/YYYY HH:MM:SS': `${day}/${month}/${year} ${hours}:${minutes}:${seconds}`
    };

    return formatMap[format] || formatMap['DD/MM/YYYY'];
  } catch {
    return '';
  }
};

export const formatTime = (date, format = 'HH:MM') => {
  try {
    const d = new Date(date);
    if (isNaN(d.getTime())) return '';

    const hours = String(d.getHours()).padStart(2, '0');
    const minutes = String(d.getMinutes()).padStart(2, '0');
    const seconds = String(d.getSeconds()).padStart(2, '0');

    const formatMap = {
      'HH:MM': `${hours}:${minutes}`,
      'HH:MM:SS': `${hours}:${minutes}:${seconds}`,
      'h:MM A': `${d.getHours() % 12 || 12}:${minutes} ${d.getHours() >= 12 ? 'PM' : 'AM'}`
    };

    return formatMap[format] || formatMap['HH:MM'];
  } catch {
    return '';
  }
};

export const getMonthName = (monthIndex) => {
  const months = [
    'January', 'February', 'March', 'April', 'May', 'June',
    'July', 'August', 'September', 'October', 'November', 'December'
  ];
  return months[monthIndex] || '';
};

export const getDayName = (date) => {
  const days = ['Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday'];
  const d = new Date(date);
  return days[d.getDay()];
};

export const getRelativeTime = (date) => {
  const now = new Date();
  const diff = now - new Date(date);
  
  const seconds = Math.floor(diff / 1000);
  const minutes = Math.floor(seconds / 60);
  const hours = Math.floor(minutes / 60);
  const days = Math.floor(hours / 24);

  if (seconds < 60) return 'Just now';
  if (minutes < 60) return `${minutes} minute${minutes > 1 ? 's' : ''} ago`;
  if (hours < 24) return `${hours} hour${hours > 1 ? 's' : ''} ago`;
  if (days < 30) return `${days} day${days > 1 ? 's' : ''} ago`;
  
  return formatDate(date);
};
