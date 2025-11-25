package com.sales.SistemaOS.service;

import com.sales.SistemaOS.model.Clientes;
import com.sales.SistemaOS.model.EnumStatus;
import com.sales.SistemaOS.model.OrdemDeServico;
import com.sales.SistemaOS.model.Servicos;
import com.sales.SistemaOS.repository.ClientesRepository;
import com.sales.SistemaOS.repository.OrdemDeServicosRepository;
import com.sales.SistemaOS.repository.ServicosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class OrdemDeServicosService {

    @Autowired
    private OrdemDeServicosRepository ordemRepository;

    @Autowired
    private ServicosRepository servicosRepository;

    @Autowired
    private ClientesRepository clientesRepository;

    public Clientes buscarClientesPorId(UUID id){
        return clientesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    public Servicos buscarServicosPorId(UUID id){
        return servicosRepository.findById(id).orElseThrow(() -> new RuntimeException("Servico não econtrado"));

    }

    public OrdemDeServico criarNovaOrdem(String observacoes, UUID idClientes, UUID idServicos){
        Clientes cliente = buscarClientesPorId(idClientes);
        Servicos servico = buscarServicosPorId(idServicos);

        OrdemDeServico novaOrdem = new OrdemDeServico();
        novaOrdem.setClientes(cliente);
        novaOrdem.setServicos(servico);
        novaOrdem.setStatus(EnumStatus.ABERTA);
        novaOrdem.setObservacoes(observacoes);
        novaOrdem.setDataAbertura(LocalDate.now());

        ordemRepository.save(novaOrdem);
        return novaOrdem;
    }

}
