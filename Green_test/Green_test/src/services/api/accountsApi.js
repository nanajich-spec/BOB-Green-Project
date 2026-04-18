import { axiosInstance } from './axiosInstance';
import { mockAdminAccounts } from '../../config/mockData';

export const getAdminAccounts = async () => {
  try {
    // Replace with real API call: return await axiosInstance.get('/ViewDetailsAdmin');
    return mockAdminAccounts;
  } catch (error) {
    throw error;
  }
};

export const getAccountDetails = async (accountId) => {
  try {
    // Replace with real API call: return await axiosInstance.get(`/ViewDetailsAdmin/${accountId}`);
    return mockAdminAccounts.find(acc => acc.id === accountId);
  } catch (error) {
    throw error;
  }
};

export const searchAccounts = async (query) => {
  try {
    // Replace with real API call
    return mockAdminAccounts.filter(acc =>
      acc.accountNumber.includes(query) || 
      acc.holderName.toLowerCase().includes(query.toLowerCase())
    );
  } catch (error) {
    throw error;
  }
};

export const updateAccount = async (accountId, data) => {
  try {
    // Replace with real API call: return await axiosInstance.put(`/UpdateAccount/${accountId}`, data);
    return { success: true, data };
  } catch (error) {
    throw error;
  }
};

export const createAccount = async (data) => {
  try {
    // Replace with real API call: return await axiosInstance.post('/CreateAccount', data);
    return { success: true, data };
  } catch (error) {
    throw error;
  }
};
