package com.sales.SistemaOS.repository;

import com.sales.SistemaOS.model.Servicos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ServicosRepository extends JpaRepository<Servicos, UUID> {
    boolean existsById(Servicos id);

    boolean existsByNome(String nome);
}
