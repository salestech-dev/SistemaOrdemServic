package com.sales.SistemaOS.repository;

import com.sales.SistemaOS.model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientesRepository extends JpaRepository<Clientes, UUID> {
    boolean existsByEmail(String email);
    boolean existsById(Clientes id);
}
