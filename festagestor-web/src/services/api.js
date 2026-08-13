import axios from 'axios';

export const api = axios.create({
  baseURL: 'http://localhost:8080', 
});

// Configurando o Interceptor de Requisição
api.interceptors.request.use(
  (config) => {
    // 1. Vai até o "bolso" buscar o crachá
    const token = localStorage.getItem('@Festagestor:token');
    
    // 2. Se o crachá existir, anexa no cabeçalho Authorization com o prefixo Bearer
    if (token) {
      config.headers.Authorization = `Bearer ${token}`;
    }
    
    // 3. Libera a requisição para seguir viagem para o Spring Boot
    return config;
  },
  (error) => {
    return Promise.reject(error);
  }
);