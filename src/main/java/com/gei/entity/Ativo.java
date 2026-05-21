package com.gei.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ativos")
@Getter
@Setter
@NoArgsConstructor
public class Ativo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true, nullable = false)
    private String ticker;

    @Enumerated(EnumType.STRING)
    private TipoAtivo tipo;

    private Double precoAtual;

    private String descricao;

    private Boolean ativo;
}