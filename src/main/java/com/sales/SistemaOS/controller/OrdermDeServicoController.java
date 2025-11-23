package com.sales.SistemaOS.controller;

import com.sales.SistemaOS.dto.CriarOrdemDTO;
import com.sales.SistemaOS.model.Clientes;
import com.sales.SistemaOS.model.OrdemDeServico;
import com.sales.SistemaOS.model.Servicos;
import com.sales.SistemaOS.service.OrdemDeServicosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class OrdermDeServicoController {

    @Autowired
    private OrdemDeServicosService ordemDeServicosService;



    @PostMapping
    public OrdemDeServico criarOrdem(@RequestBody CriarOrdemDTO dto) {
        return ordemDeServicosService.salvarNovaOrdem(
                dto.getIdCliente(),
                dto.getIdServico(),
                dto.getObservacoes()
        );
    }

    @GetMapping
    public List<OrdemDeServico> listar(){
         return ordemDeServicosService.listar();
    }

    @GetMapping("/{id}")
    public OrdemDeServico buscarPorId(@PathVariable("id") UUID uuid){
        return ordemDeServicosService.buscarPorId(uuid);
    }







}
