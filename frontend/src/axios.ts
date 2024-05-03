import axios from 'axios';

const userApiUrl = import.meta.env.VITE_USER_API_URL;

export const userAxios = axios.create({
  baseURL: userApiUrl,
  timeout: 1000
});
