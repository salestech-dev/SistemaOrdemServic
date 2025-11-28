package com.sales.SistemaOS.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
public class OrdemDeServico {


    @Id
    @GeneratedValue
    private UUID id;

    @Column (nullable = false)
    private LocalDate dataAbertura;

    @Column (nullable = false)
    private String observacoes;

    @Column (nullable = false)
    private EnumStatus status;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Clientes clientes;

    @ManyToOne
    @JoinColumn(name = "servico_id", nullable = false)
    private Servicos servicos;

    @Column
    private LocalDate dataConclusao;            // Quando foi finalizada
    @Column
    private LocalDate dataPrevista;           // Prazo estimado
    @Column
    private EnumPrioridade prioridade;                // "ALTA", "MEDIA", "BAIXA"
    @Column
    private BigDecimal valorTotal;            // Valor do serviço

    public LocalDate getDataConclusao() {
        return dataConclusao;
    }

    public OrdemDeServico setDataConclusao(LocalDate dataConclusao) {
        this.dataConclusao = dataConclusao;
        return this;
    }

    public LocalDate getDataPrevista() {
        return dataPrevista;
    }

    public OrdemDeServico setDataPrevista(LocalDate dataPrevista) {
        this.dataPrevista = dataPrevista;
        return this;
    }

    public EnumPrioridade getPrioridade() {
        return prioridade;
    }

    public OrdemDeServico setPrioridade(EnumPrioridade prioridade) {
        this.prioridade = prioridade;
        return this;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public OrdemDeServico setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
        return this;
    }




    @Override
    public String toString() {
        return "OrdemDeServico{" +
                "id=" + id +
                ", dataAbertura=" + dataAbertura +
                ", observacoes='" + observacoes + '\'' +
                ", status=" + status +
                ", clientes=" + clientes +
                ", servicos=" + servicos +
                ", dataConclusao=" + dataConclusao +
                ", dataPrevista=" + dataPrevista +
                ", prioridade=" + prioridade +
                ", valorTotal=" + valorTotal +
                '}';
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(LocalDate dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public EnumStatus getStatus() {
        return status;
    }

    public void setStatus(EnumStatus status) {
        this.status = status;
    }

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
    }

    public Servicos getServicos() {
        return servicos;
    }

    public void setServicos(Servicos servicos) {
        this.servicos = servicos;
    }
}
