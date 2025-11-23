package com.sales.SistemaOS.repository;

import com.sales.SistemaOS.model.OrdemDeServico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrdemDeServicosRepository extends JpaRepository<OrdemDeServico, UUID> {
}
