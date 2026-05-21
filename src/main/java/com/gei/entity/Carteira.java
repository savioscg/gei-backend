package com.gei.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "carteiras")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Carteira {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String perfilRisco;

    private Double saldo;

    private LocalDateTime dataCriacao;

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @PrePersist
    public void prePersist() {
        this.dataCriacao = LocalDateTime.now();

        if (this.saldo == null) {
            this.saldo = 0.0;
        }
    }
}