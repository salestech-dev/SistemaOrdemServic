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

    public OrdemDeServico salvarNovaOrdem(UUID idCliente, UUID idServico, String observacoes){

        Clientes cliente = buscarClientesPorId(idCliente);
        Servicos servico = buscarServicosPorId(idServico);

        OrdemDeServico ordem = new OrdemDeServico();
        ordem.setDataAbertura(LocalDate.now());
        ordem.setObservacoes(observacoes);
        ordem.setStatus(EnumStatus.ABERTA);
        ordem.setClientes(cliente);
        ordem.setServicos(servico);

        return ordemRepository.save(ordem);
    }

    public List<OrdemDeServico> listar(){
       return ordemRepository.findAll();
    }

    public void deletarOrdem(UUID id){
        if(!ordemRepository.existsById(id)){
            throw new RuntimeException("Ordem não encontrada");
        }
        ordemRepository.deleteById(id);
    }

    public OrdemDeServico buscarPorId(UUID uuid){
        var ordemEcontrada = ordemRepository.findById(uuid).orElseThrow(()-> new RuntimeException("Não econtrado"));
        OrdemDeServico ordemDeServico = ordemEcontrada;
        return ordemDeServico;

    }
}
