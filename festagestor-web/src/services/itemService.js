import { api } from './api';

export const itemService = {
    listar: async () => {
        const response = await api.get('/itens')
        return response.data;
    },

    cadastrar: async (dadosItem) => {
        const response = await api.post('/itens', dadosItem);
        return response.data;
    },

    deletar: async (id) => {
        const response = await api.delete(`/itens/${id}`);
        return response.data;
    },

    atualizar: async (id, dadosAtualizacaoItem) => {
        const response = await api.put(`/itens/${id}`, dadosAtualizacaoItem);
        return response.data;
    },

    manutencao: async (id) => {
        const response = await api.patch(`/itens/${id}/manutencao`);
        return response.data;
    }
}
