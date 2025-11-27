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
@RequestMapping("/api/os")
public class OrdermDeServicoController {

    @Autowired
    private OrdemDeServicosService ordemDeServicosService;









}
