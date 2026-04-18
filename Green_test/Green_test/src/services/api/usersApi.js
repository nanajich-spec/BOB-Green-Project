import { axiosInstance } from './axiosInstance';
import { mockUsers } from '../../config/mockData';

export const getUsers = async () => {
  try {
    // Replace with real API call: return await axiosInstance.get('/Users');
    return mockUsers;
  } catch (error) {
    throw error;
  }
};

export const getUserById = async (userId) => {
  try {
    // Replace with real API call: return await axiosInstance.get(`/Users/${userId}`);
    return mockUsers.find(user => user.id === userId);
  } catch (error) {
    throw error;
  }
};

export const searchUsers = async (query) => {
  try {
    // Replace with real API call
    return mockUsers.filter(user =>
      user.name.toLowerCase().includes(query.toLowerCase()) ||
      user.email.toLowerCase().includes(query.toLowerCase())
    );
  } catch (error) {
    throw error;
  }
};

export const createUser = async (data) => {
  try {
    // Replace with real API call: return await axiosInstance.post('/Users', data);
    return { success: true, data };
  } catch (error) {
    throw error;
  }
};

export const updateUser = async (userId, data) => {
  try {
    // Replace with real API call: return await axiosInstance.put(`/Users/${userId}`, data);
    return { success: true, data };
  } catch (error) {
    throw error;
  }
};

export const deleteUser = async (userId) => {
  try {
    // Replace with real API call: return await axiosInstance.delete(`/Users/${userId}`);
    return { success: true };
  } catch (error) {
    throw error;
  }
};
