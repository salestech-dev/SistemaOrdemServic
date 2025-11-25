package com.sales.SistemaOS.controller;

import com.sales.SistemaOS.dto.EditarClienteDTO;
import com.sales.SistemaOS.model.Clientes;
import com.sales.SistemaOS.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Clientes> salvarCliente(@RequestBody Clientes clientes){
       Clientes clientes1 = clienteService.salvarCliente(clientes);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientes1);
    }

    @GetMapping
    public ResponseEntity<List<Clientes>> buscarTodos(){
        List<Clientes> lista = clienteService.listarCadastrado();
        return  ResponseEntity.ok(lista);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Clientes> atualizarCliente(@PathVariable("id") UUID id,
                                                     @RequestBody EditarClienteDTO dto){
            Clientes clientesAtualizado = clienteService.editarCliente(id,dto);
            return ResponseEntity.ok(clientesAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Clientes>deletarCliente(@PathVariable("id") UUID id){
        clienteService.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }

}
