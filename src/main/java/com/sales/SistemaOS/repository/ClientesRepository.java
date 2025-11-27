package com.sales.SistemaOS.repository;

import com.sales.SistemaOS.model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ClientesRepository extends JpaRepository<Clientes, UUID> {
    boolean existsByEmail(String email);
    boolean existsById(UUID id);
    boolean existsByCpf(String cpf);
    boolean existsByTelefoneAndIdNot(String telefone, UUID id);
    boolean existsByEmailAndIdNot(String email, UUID id);
    boolean existsByTelefone(String telefone);
    List<Clientes> findByNomeContainingIgnoreCase(String nome);
}
