package com.sales.SistemaOS.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class Servicos {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 100)
    private String descricao;

    @Column
    private BigDecimal valor;

    @Column
    private String nome;

    @Column
    private String categoria;

    @Column
    private Boolean ativo;

    @Column(nullable = false, unique = true)
    private String codigo;

    @Column
    private BigDecimal custo;

    @Column
    private Integer tempoMedioMinutos;

    @Override
    public String toString() {
        return "Servicos{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", valor=" + valor +
                ", nome='" + nome + '\'' +
                ", categoria='" + categoria + '\'' +
                ", ativo=" + ativo +
                ", codigo='" + codigo + '\'' +
                ", custo=" + custo +
                ", tempoMedioMinutos=" + tempoMedioMinutos +
                '}';
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getCusto() {
        return custo;
    }

    public void setCusto(BigDecimal custo) {
        this.custo = custo;
    }

    public Integer getTempoMedioMinutos() {
        return tempoMedioMinutos;
    }

    public void setTempoMedioMinutos(Integer tempoMedioMinutos) {
        this.tempoMedioMinutos = tempoMedioMinutos;
    }
}
