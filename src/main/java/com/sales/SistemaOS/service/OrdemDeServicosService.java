package com.sales.SistemaOS.service;

import com.sales.SistemaOS.dto.CriarOrdemDTO;
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

    public OrdemDeServico criarNovaOrdem(CriarOrdemDTO dto){
        Clientes cliente = buscarClientesPorId(dto.getClienteId());
        Servicos servico = buscarServicosPorId(dto.getServicoId());

        OrdemDeServico novaOrdem = new OrdemDeServico();
        novaOrdem.setClientes(cliente);
        novaOrdem.setServicos(servico);
        novaOrdem.setStatus(EnumStatus.ABERTA);
        novaOrdem.setObservacoes(dto.getObservacoes());
        novaOrdem.setDataAbertura(LocalDate.now());
        novaOrdem.setDataPrevista(dto.getDataPrevista());
        novaOrdem.setPrioridade(dto.getPrioridade());
        novaOrdem.setValorTotal(dto.getValorTotal());

        ordemRepository.save(novaOrdem);
        return novaOrdem;
    }

    public long contarOS(){
        return ordemRepository.count();
    }
}
