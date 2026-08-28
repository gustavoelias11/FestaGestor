package br.com.festagestor.domain.dashboard.service;

import br.com.festagestor.domain.aluguel.repository.AluguelRepository;
import br.com.festagestor.domain.cliente.repository.ClienteRepository;
import br.com.festagestor.domain.dashboard.dto.DadosResumoDashboard;
import br.com.festagestor.domain.item.repository.ItemRepository;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    private final AluguelRepository aluguelRepository;
    private final ItemRepository itemRepository;
    private final ClienteRepository clienteRepository;

    public DashboardService(AluguelRepository aluguelRepository, ItemRepository itemRepository, ClienteRepository clienteRepository) {
        this.aluguelRepository = aluguelRepository;
        this.itemRepository = itemRepository;
        this.clienteRepository = clienteRepository;
    }

    public  DadosResumoDashboard resumo() {
        var contadorItens = itemRepository.contaItens();
        var aluguelMes = aluguelRepository.aluguelMes();
        var contadorClientes = clienteRepository.contaClientes();
        var faturamento = aluguelRepository.somarFaturamento();
        return new DadosResumoDashboard(contadorItens, aluguelMes, contadorClientes, faturamento);
    }
}
