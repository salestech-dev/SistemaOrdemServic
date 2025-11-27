package com.sales.SistemaOS.service;

import com.sales.SistemaOS.dto.EditarServicosDTO;
import com.sales.SistemaOS.model.Servicos;
import com.sales.SistemaOS.repository.ServicosRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

        if(servicosRepository.existsByCodigo(servicos.getCodigo())){
            throw new RuntimeException("Um serviço com esse codigo ja existe");
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
        if(editarDTO.tempoMedioMinutos() != null){
            servicos.setTempoMedioMinutos(editarDTO.tempoMedioMinutos());
        }
        servicos.setAtivo(editarDTO.ativo());



        return servicosRepository.save(servicos);

    }

    public List<Servicos> buscarPorNome(String nome){
       if(!servicosRepository.existsByNome(nome)){
          throw new RuntimeException("Não existe nenhuma ordem com esse nome");
       }

        List<Servicos> lista = servicosRepository.findByNomeContainingIgnoreCase(nome);
        return lista;
    }

    public List<Servicos> buscarPorAtivoTrue(){
        List<Servicos> lista = servicosRepository.findByAtivoTrue();
        return lista;
    }

    public Servicos desativarServico(UUID id){
    Servicos servicos = servicosRepository.findById(id)
            .orElseThrow(()-> new RuntimeException("Esse servico não foi econtrado"));
    //Seta servico como falso.
     servicos.setAtivo(false);
        return servicosRepository.save(servicos);
    }

    public List<Servicos> contarServicosAtivos(){
        return servicosRepository.findByAtivoTrue();
    }


}
