package com.gei.dto;

import com.gei.entity.TipoAtivo;

public class AtivoResponse {

    private Long id;
    private String nome;
    private String ticker;
    private TipoAtivo tipo;
    private Double precoAtual;
    private String descricao;
    private Boolean ativo;

    public AtivoResponse() {
    }

    public AtivoResponse(
            Long id,
            String nome,
            String ticker,
            TipoAtivo tipo,
            Double precoAtual,
            String descricao,
            Boolean ativo
    ) {
        this.id = id;
        this.nome = nome;
        this.ticker = ticker;
        this.tipo = tipo;
        this.precoAtual = precoAtual;
        this.descricao = descricao;
        this.ativo = ativo;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTicker() {
        return ticker;
    }

    public TipoAtivo getTipo() {
        return tipo;
    }

    public Double getPrecoAtual() {
        return precoAtual;
    }

    public String getDescricao() {
        return descricao;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public void setTipo(TipoAtivo tipo) {
        this.tipo = tipo;
    }

    public void setPrecoAtual(Double precoAtual) {
        this.precoAtual = precoAtual;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}