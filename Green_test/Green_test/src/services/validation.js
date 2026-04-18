export const validateEmail = (email) => {
  const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  return emailRegex.test(email);
};

export const validatePassword = (password) => {
  // At least 8 characters, 1 uppercase, 1 lowercase, 1 number, 1 special char
  const passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
  return passwordRegex.test(password);
};

export const validatePhone = (phone) => {
  const phoneRegex = /^[\d\s\-\(\)\+]{10,}$/;
  return phoneRegex.test(phone);
};

export const validateAmount = (amount) => {
  const num = parseFloat(amount);
  return !isNaN(num) && num > 0;
};

export const validateAccountNumber = (accountNumber) => {
  // Basic validation - adjust based on your requirements
  return accountNumber && accountNumber.length >= 10;
};

export const validateFormData = (data, schema) => {
  const errors = {};

  Object.keys(schema).forEach(field => {
    const rule = schema[field];
    const value = data[field];

    if (rule.required && (!value || (typeof value === 'string' && !value.trim()))) {
      errors[field] = `${field} is required`;
    }

    if (value && rule.type === 'email' && !validateEmail(value)) {
      errors[field] = 'Invalid email address';
    }

    if (value && rule.type === 'phone' && !validatePhone(value)) {
      errors[field] = 'Invalid phone number';
    }

    if (value && rule.type === 'amount' && !validateAmount(value)) {
      errors[field] = 'Invalid amount';
    }

    if (rule.minLength && value && value.length < rule.minLength) {
      errors[field] = `Minimum ${rule.minLength} characters required`;
    }

    if (rule.maxLength && value && value.length > rule.maxLength) {
      errors[field] = `Maximum ${rule.maxLength} characters allowed`;
    }

    if (rule.pattern && value && !rule.pattern.test(value)) {
      errors[field] = rule.message || `Invalid ${field}`;
    }
  });

  return {
    isValid: Object.keys(errors).length === 0,
    errors
  };
};
