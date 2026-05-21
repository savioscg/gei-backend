package com.gei.dto;

public record InvestimentoRequest(
        Double quantidade,
        Double precoCompra,
        Long carteiraId,
        Long ativoId
) {
}