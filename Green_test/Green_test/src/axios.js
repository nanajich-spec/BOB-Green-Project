import axios from 'axios';


// const BASE = 'https://noncbsuat.bankofbaroda.co.in/green-project/api/v1';
const BASE = process.env.REACT_APP_API_BASE || 'http://localhost:8080/green-project/api/v1';

const axiosIns = axios.create({
    baseURL: BASE,
});

export default axiosIns;