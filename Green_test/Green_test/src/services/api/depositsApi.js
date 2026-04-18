import { axiosInstance } from './axiosInstance';
import { mockDepositData } from '../../config/mockData';

export const getDepositData = async () => {
  try {
    // Replace with real API call: return await axiosInstance.get('/DepositData');
    return mockDepositData;
  } catch (error) {
    throw error;
  }
};

export const getDepositByAccount = async (accountNumber) => {
  try {
    // Replace with real API call: return await axiosInstance.get(`/DepositData/${accountNumber}`);
    return mockDepositData.filter(deposit => deposit.accountNumber === accountNumber);
  } catch (error) {
    throw error;
  }
};

export const searchDeposits = async (query) => {
  try {
    // Replace with real API call
    return mockDepositData.filter(deposit =>
      deposit.accountNumber.includes(query) ||
      deposit.depositZone.toLowerCase().includes(query.toLowerCase())
    );
  } catch (error) {
    throw error;
  }
};

export const createDeposit = async (data) => {
  try {
    // Replace with real API call: return await axiosInstance.post('/DepositData', data);
    return { success: true, data };
  } catch (error) {
    throw error;
  }
};

export const updateDeposit = async (depositId, data) => {
  try {
    // Replace with real API call: return await axiosInstance.put(`/DepositData/${depositId}`, data);
    return { success: true, data };
  } catch (error) {
    throw error;
  }
};
