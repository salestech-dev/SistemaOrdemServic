package com.sales.SistemaOS.controller;

import com.sales.SistemaOS.dto.EditarServicosDTO;
import com.sales.SistemaOS.model.Servicos;
import com.sales.SistemaOS.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/servicos")
public class ServicosController {

    @Autowired
    private ServicoService servicoService;

    @PostMapping
    public ResponseEntity<Servicos> criar(@RequestBody Servicos servicos){
        return ResponseEntity.ok(servicoService.salvarServico(servicos));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Servicos> atualizar(
            @RequestBody EditarServicosDTO editarDTO,
            @PathVariable UUID id
            ){
        return ResponseEntity.ok(servicoService.atualizarServicos(id,editarDTO));
    }

    @GetMapping
    public List<Servicos> listarServicos(){
        return servicoService.listarServicos();
    }

    @DeleteMapping("/{id}")
    public void deletarSevico(@PathVariable UUID id){
        servicoService.deletarServico(id);
    }

}
