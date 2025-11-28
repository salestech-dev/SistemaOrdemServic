package com.sales.SistemaOS.dto;

import com.sales.SistemaOS.model.EnumPrioridade;
import com.sales.SistemaOS.model.EnumStatus;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;
public class CriarOrdemDTO {
    private String observacoes;      // ✅ Usuário envia
    private UUID clienteId;          // ✅ Usuário envia
    private UUID servicoId;          // ✅ Usuário envia
    private LocalDate dataPrevista;  // ✅ Usuário envia
    private EnumPrioridade prioridade;   // ✅ Usuário envia
    private BigDecimal valorTotal;

    LocalDate dataAbertura = LocalDate.now();  // ✅ Sistema
    EnumStatus status = EnumStatus.ABERTA;


    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public CriarOrdemDTO setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
        return this;
    }

    public EnumStatus getStatus() {
        return status;
    }

    public CriarOrdemDTO setStatus(EnumStatus status) {
        this.status = status;
        return this;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public CriarOrdemDTO setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
        return this;
    }

    public EnumPrioridade getPrioridade() {
        return prioridade;
    }

    public CriarOrdemDTO setPrioridade(EnumPrioridade prioridade) {
        this.prioridade = prioridade;
        return this;
    }

    public LocalDate getDataPrevista() {
        return dataPrevista;
    }

    public CriarOrdemDTO setDataPrevista(LocalDate dataPrevista) {
        this.dataPrevista = dataPrevista;
        return this;
    }

    public UUID getServicoId() {
        return servicoId;
    }

    public CriarOrdemDTO setServicoId(UUID servicoId) {
        this.servicoId = servicoId;
        return this;
    }

    public UUID getClienteId() {
        return clienteId;
    }

    public CriarOrdemDTO setClienteId(UUID clienteId) {
        this.clienteId = clienteId;
        return this;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public CriarOrdemDTO setObservacoes(String observacoes) {
        this.observacoes = observacoes;
        return this;
    }


}