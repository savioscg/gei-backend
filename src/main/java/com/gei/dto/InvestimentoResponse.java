package com.gei.dto;

import java.time.LocalDateTime;

public record InvestimentoResponse(
        Long id,
        Double quantidade,
        Double precoCompra,
        LocalDateTime dataCompra,
        Long carteiraId,
        String carteiraNome,
        Long ativoId,
        String ativoNome,
        String ticker
) {
}