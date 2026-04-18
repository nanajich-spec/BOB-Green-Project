import axios from 'axios';
import { getMockResponse } from './mockApiData';

const API_BASE = process.env.REACT_APP_API_BASE || 'http://localhost:8080/green-project/api/v1';
const ENABLE_MOCK = process.env.REACT_APP_ENABLE_MOCK !== 'false';
const API_MARKER = '/green-project/api/v1';

const normalizeApiPath = (url = '') => {
  const markerIndex = url.indexOf(API_MARKER);
  if (markerIndex >= 0) {
    const rest = url.substring(markerIndex + API_MARKER.length);
    return rest.startsWith('/') ? rest : `/${rest}`;
  }

  if (url.startsWith('http://') || url.startsWith('https://')) {
    try {
      return new URL(url).pathname;
    } catch (error) {
      return url;
    }
  }

  return url;
};

axios.defaults.baseURL = API_BASE;

axios.interceptors.request.use((config) => {
  const nextConfig = { ...config };

  if (typeof nextConfig.url === 'string') {
    const normalized = normalizeApiPath(nextConfig.url);
    if (normalized && normalized !== nextConfig.url) {
      nextConfig.url = normalized;
      nextConfig.baseURL = API_BASE;
    }
  }

  return nextConfig;
});

axios.interceptors.response.use(
  (response) => response,
  (error) => {
    if (!ENABLE_MOCK || !error || !error.config) {
      return Promise.reject(error);
    }

    const mockData = getMockResponse(error.config);

    return Promise.resolve({
      data: mockData,
      status: 200,
      statusText: 'OK',
      headers: {},
      config: error.config,
      request: {}
    });
  }
);
