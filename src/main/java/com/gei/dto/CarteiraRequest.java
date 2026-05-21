package com.gei.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CarteiraRequest {

    @NotBlank(message = "Nome da carteira é obrigatório")
    private String nome;

    @NotBlank(message = "Perfil de risco é obrigatório")
    private String perfilRisco;

    private Double saldo;

    @NotNull(message = "Cliente ID é obrigatório")
    private Long clienteId;
}