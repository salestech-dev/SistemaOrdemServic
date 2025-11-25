package com.sales.SistemaOS.repository;

import com.sales.SistemaOS.model.Servicos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ServicosRepository extends JpaRepository<Servicos, UUID> {
    boolean existsByNome(String nome);
    List<Servicos> findByNomeContainingIgnoreCase(String nome);
    List<Servicos> findByAtivoTrue();
    boolean existsByCodigo(String codigo);
}
