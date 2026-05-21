package com.gei.dto;

import java.time.LocalDateTime;

public class CarteiraResponse {

    private Long id;
    private String nome;
    private String perfilRisco;
    private Double saldo;
    private LocalDateTime dataCriacao;
    private Long clienteId;
    private String clienteNome;

    public CarteiraResponse() {
    }

    public CarteiraResponse(
            Long id,
            String nome,
            String perfilRisco,
            Double saldo,
            LocalDateTime dataCriacao,
            Long clienteId,
            String clienteNome
    ) {
        this.id = id;
        this.nome = nome;
        this.perfilRisco = perfilRisco;
        this.saldo = saldo;
        this.dataCriacao = dataCriacao;
        this.clienteId = clienteId;
        this.clienteNome = clienteNome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getPerfilRisco() {
        return perfilRisco;
    }

    public Double getSaldo() {
        return saldo;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public String getClienteNome() {
        return clienteNome;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPerfilRisco(String perfilRisco) {
        this.perfilRisco = perfilRisco;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public void setClienteNome(String clienteNome) {
        this.clienteNome = clienteNome;
    }
}