package br.com.festagestor.domain.dashboard.controller;

import br.com.festagestor.domain.dashboard.dto.DadosResumoDashboard;
import br.com.festagestor.domain.dashboard.service.DashboardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    private final DashboardService service;

    public DashboardController(DashboardService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<DadosResumoDashboard> resumo() {
        return ResponseEntity.ok(service.resumo());
    }
}
