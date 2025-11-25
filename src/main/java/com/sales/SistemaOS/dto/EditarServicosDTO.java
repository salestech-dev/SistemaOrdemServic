package com.sales.SistemaOS.dto;

import java.math.BigDecimal;

public record EditarServicosDTO(
        String nome,
        String descricao,
        BigDecimal valor,
        Integer tempoMedioMinutos,
        boolean ativo) {

}
