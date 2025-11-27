package com.sales.SistemaOS.controller;

import com.sales.SistemaOS.service.ClienteService;
import com.sales.SistemaOS.service.OrdemDeServicosService;
import com.sales.SistemaOS.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ServicoService servicoService;

    @Autowired
    private OrdemDeServicosService osService;

    @GetMapping
    public Map<String, Object> getEstatisticas() {
        Map<String, Object> stats = new HashMap<>();

        stats.put("totalClientes", clienteService.contarClientes());
        stats.put("totalServicos", servicoService.contarServicosAtivos());
        stats.put("totalOrdensServico", osService.contarOS());
        stats.put("sistemaAtivo", true);

        return stats;
    }
}