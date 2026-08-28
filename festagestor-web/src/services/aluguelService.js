import { api } from './api';

export const atualizarStatusAluguel = async (id, novoStatus) => {
  let rota;
  switch (novoStatus) {
    case 'CONFIRMADO': rota = `/alugueis/${id}/confirmar`; break;
    case 'MONTADO': rota = `/alugueis/${id}/montagem`; break;
    case 'FINALIZADO': rota = `/alugueis/${id}/finalizar`; break;
    case 'CANCELADO': rota = `/alugueis/${id}/cancelar`; break;
    default: throw new Error('Status inválido');
  }
  const response = await api.patch(rota);
  return response.data;
};

export const listarAlugueisRecentes = async () => {
  const response = await api.get('/alugueis?sort=dataEntrega,desc');
  return response.data.content;
};