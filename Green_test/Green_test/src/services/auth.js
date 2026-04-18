import { axiosInstance } from './api/axiosInstance';

export const login = async (email, password) => {
  try {
    // Replace with real API call
    // const response = await axiosInstance.post('/auth/login', { email, password });
    // return response.data;
    
    return {
      success: true,
      user: {
        id: 'U001',
        name: 'Admin User',
        email,
        role: 'ADMIN',
        token: 'mock-token-' + Date.now()
      }
    };
  } catch (error) {
    throw error;
  }
};

export const logout = async () => {
  try {
    // Replace with real API call: return await axiosInstance.post('/auth/logout');
    localStorage.removeItem('user');
    localStorage.removeItem('token');
    return { success: true };
  } catch (error) {
    throw error;
  }
};

export const validateToken = async (token) => {
  try {
    // Replace with real API call
    // return await axiosInstance.post('/auth/validate-token', { token });
    return { valid: true };
  } catch (error) {
    return { valid: false };
  }
};

export const refreshToken = async () => {
  try {
    // Replace with real API call
    // const response = await axiosInstance.post('/auth/refresh-token');
    // return response.data;
    return { token: 'mock-token-' + Date.now() };
  } catch (error) {
    throw error;
  }
};
