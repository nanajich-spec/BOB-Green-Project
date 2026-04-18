import { axiosInstance } from './axiosInstance';
import { mockLoanData } from '../../config/mockData';

export const getLoanData = async () => {
  try {
    // Replace with real API call: return await axiosInstance.get('/LoanData');
    return mockLoanData;
  } catch (error) {
    throw error;
  }
};

export const getLoanByAccount = async (accountNumber) => {
  try {
    // Replace with real API call: return await axiosInstance.get(`/LoanData/${accountNumber}`);
    return mockLoanData.find(loan => loan.accountNumber === accountNumber);
  } catch (error) {
    throw error;
  }
};

export const searchLoans = async (query) => {
  try {
    // Replace with real API call
    return mockLoanData.filter(loan =>
      loan.accountNumber.includes(query) ||
      loan.loanType.toLowerCase().includes(query.toLowerCase())
    );
  } catch (error) {
    throw error;
  }
};

export const createLoan = async (data) => {
  try {
    // Replace with real API call: return await axiosInstance.post('/LoanData', data);
    return { success: true, data };
  } catch (error) {
    throw error;
  }
};

export const updateLoan = async (loanId, data) => {
  try {
    // Replace with real API call: return await axiosInstance.put(`/LoanData/${loanId}`, data);
    return { success: true, data };
  } catch (error) {
    throw error;
  }
};
