import { api } from '../api';

export const authService = {
  // Função que encapsula a lógica de ir até o Spring Boot e tentar logar
  login: async (username, password) => {
    const response = await api.post('/login', {
      login: username,
      senha: password
    });
    
    // Retorna apenas o token para quem chamou a função
    return response.data.token; 
  },
};