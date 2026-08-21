package br.com.festagestor.domain.dashboard.service;

import br.com.festagestor.domain.aluguel.repository.AluguelRepository;
import br.com.festagestor.domain.dashboard.dto.DadosResumoDashboard;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    private final AluguelRepository aluguelRepository;

    public DashboardService(AluguelRepository aluguelRepository) {
        this.aluguelRepository = aluguelRepository;
    }

    public  DadosResumoDashboard resumo() {
        var faturamento = aluguelRepository.somarFaturamento();
        return new DadosResumoDashboard(faturamento);
    }
}
