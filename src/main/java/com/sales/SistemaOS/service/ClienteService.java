package com.sales.SistemaOS.service;

import com.sales.SistemaOS.model.Clientes;
import com.sales.SistemaOS.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClienteService {

    @Autowired
    private ClientesRepository clientesRepository;

    public Clientes salvarCliente(Clientes clientes){

        if(clientes.getEmail() == null || clientes.getNome().isBlank()){
            throw new IllegalArgumentException("Nome do cliente não pode ser vazio");
        }
        if(!clientes.getNome().contains("@")){
            throw new IllegalArgumentException("Email invalido");
        }
        if (clientesRepository.existsByEmail(clientes.getEmail())){
        throw new IllegalArgumentException("Não foi possivel cadastrar. " +
                "Esse email ja esta cadastrado.");
        }

        clientesRepository.save(clientes);
        return clientes;
    }

    public List<Clientes> listarCadastrado(){
      return clientesRepository.findAll();
    }

    public void deletarCliente(Clientes clientes){
        clientesRepository.delete(clientes);
    }

    public Clientes editarCliente(UUID id, Clientes dadosNovos, Clientes clientes){
        var clienteExistente = clientesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não econtrado"));


        if (clientesRepository.existsByEmail(clientes.getEmail())) {
            throw new IllegalArgumentException("Não foi possivel cadastrar. " +
                    "Esse email ja esta cadastrado.");
        }

        clienteExistente.setEmail(dadosNovos.getEmail());
        clienteExistente.setNome(dadosNovos.getNome());
        clienteExistente.setTelefone(dadosNovos.getTelefone());

        clientesRepository.save(dadosNovos);
        return dadosNovos;

    }

}
