package com.gei.dto;

public class ClienteRequest {

    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private Boolean ativo;

    public ClienteRequest() {
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
}