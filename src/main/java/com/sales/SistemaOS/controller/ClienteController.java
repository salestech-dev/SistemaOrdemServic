package com.sales.SistemaOS.controller;

import com.sales.SistemaOS.dto.EditarClienteDTO;
import com.sales.SistemaOS.model.Clientes;
import com.sales.SistemaOS.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clientes")
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

    @PutMapping
    public ResponseEntity<Clientes> atualizarCliente(@RequestBody EditarClienteDTO editarClienteDTO){

    }

}
