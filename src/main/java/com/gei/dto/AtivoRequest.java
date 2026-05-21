package com.gei.dto;

import com.gei.entity.TipoAtivo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class AtivoRequest {

    @NotBlank
    private String nome;

    @NotBlank
    private String ticker;

    @NotNull
    private TipoAtivo tipo;

    @NotNull
    private Double precoAtual;

    private String descricao;

    @NotNull
    private Boolean ativo;

    public AtivoRequest() {
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