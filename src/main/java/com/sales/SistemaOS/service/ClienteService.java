package com.sales.SistemaOS.service;

import com.sales.SistemaOS.dto.EditarClienteDTO;
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

        if(clientesRepository.existsByCpf(clientes.getCpf())){
            throw new RuntimeException("Esse CPF ja esta cadastrado");
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

    public Clientes editarCliente(UUID id, EditarClienteDTO editarClienteDTO) {

        Clientes clienteExistente = clientesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não econtrado"));

        if (clientesRepository.existsByEmail(clienteExistente.getEmail())) {
            throw new RuntimeException("Um cliente com esse email ja existe");
        }

        if (clientesRepository.existsByCpf(clienteExistente.getCpf())) {
            throw new RuntimeException("Um cliente com esse CPF ja existe");
        }

        if (clientesRepository.existsByTelefone(clienteExistente.getTelefone())) {
            throw new RuntimeException("Um cliente ja tem esse numero cadastrado");
        }


        clienteExistente.setNome(editarClienteDTO.nome());
        clienteExistente.setEmail(editarClienteDTO.email());
        clienteExistente.setTelefone(editarClienteDTO.telefone());
        clienteExistente.setCpf(editarClienteDTO.cpf());

        clientesRepository.save(clienteExistente);

        return clienteExistente;
    }
}
