import { api } from './api';

export const obterResumoDashboard = async () => {
    const response = await api.get('/dashboard');
    return response.data;
}