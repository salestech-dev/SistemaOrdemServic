package com.sales.SistemaOS.service;

import com.sales.SistemaOS.dto.EditarServicosDTO;
import com.sales.SistemaOS.model.Clientes;
import com.sales.SistemaOS.model.Servicos;
import com.sales.SistemaOS.repository.ServicosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ServicoService {

    @Autowired
    private ServicosRepository servicosRepository;

    public Servicos salvarServico(Servicos servicos) {
        if(servicosRepository.existsByNome(servicos.getNome())){
            throw new RuntimeException("Esse serviço ja existe");
        }
        return servicosRepository.save(servicos);
    }

    public void deletarServico(UUID id){
       if(!servicosRepository.existsById(id)){
           throw new RuntimeException("Esse servico não foi encontrado");
       }

       servicosRepository.deleteById(id);

    }

    public List<Servicos> listarServicos(){
        return servicosRepository.findAll();
    }

    public Servicos atualizarServicos(UUID id, EditarServicosDTO editarDTO){
        Servicos servicos = servicosRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Servicos não econtrado"));

        if(servicosRepository.existsByNome(servicos.getNome())){
            throw new RuntimeException("Um servico com esse nome ja existe");
        }


        if(editarDTO.nome() != null){
            servicos.setNome(editarDTO.nome());
        }

        if(editarDTO.descricao() != null){
            servicos.setDescricao(editarDTO.descricao());
        }

        if(editarDTO.valor() != null){
            servicos.setValor(editarDTO.valor());
        }

        return servicosRepository.save(servicos);

    }
}
