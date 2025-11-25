package com.sales.SistemaOS.service;

import com.sales.SistemaOS.dto.EditarClienteDTO;
import com.sales.SistemaOS.model.Clientes;
import com.sales.SistemaOS.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClienteService {

    @Autowired
    private ClientesRepository clientesRepository;

    public Clientes salvarCliente(Clientes clientes){

        if(clientes.getEmail() == null || clientes.getNome().isBlank()){
            throw new IllegalArgumentException("Nome do cliente não pode ser vazio");
        }

        if(clientesRepository.existsByTelefone(clientes.getTelefone())){
            throw new RuntimeException("Esse Telefone ja esta cadastrado");
        }
        if(clientesRepository.existsByCpf(clientes.getCpf())){
            throw new RuntimeException("Esse CPF ja esta cadastrado");
        }

        if(!clientes.getEmail().contains("@")){
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

    public void deletarCliente(UUID id) {
        Clientes cliente = clientesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        clientesRepository.delete(cliente);
    }

    public Clientes editarCliente(UUID id, EditarClienteDTO dto){
        Clientes clienteExistente = clientesRepository.findById(id).orElseThrow(()-> new RuntimeException("Cliente não existe"));

        if (dto.email() != null &&
                clientesRepository.existsByEmailAndIdNot(dto.email(), id))
        {
            throw new RuntimeException("OUTRO CLIENTE JÁ TEM ESSE EMAIL CADASTRADO");
        }

        if(dto.telefone() != null &&
                clientesRepository.existsByTelefoneAndIdNot(dto.telefone(), id))
        {
            throw new RuntimeException("OUTRO CLIENTE JA USA ESSE TELEFONE ");
        }

        clienteExistente.setNome(dto.nome());
        clienteExistente.setEmail(dto.email());
        clienteExistente.setTelefone(dto.telefone());

        return clientesRepository.save(clienteExistente);

    }
}
