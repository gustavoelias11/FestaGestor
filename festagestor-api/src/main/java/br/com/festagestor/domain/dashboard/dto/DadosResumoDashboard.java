package br.com.festagestor.domain.dashboard.dto;

import java.math.BigDecimal;

public record DadosResumoDashboard(
        Long itensCadastrados,
        Long alugueisMes,
        Long clientesAtivos,
        BigDecimal faturamento
) {}
