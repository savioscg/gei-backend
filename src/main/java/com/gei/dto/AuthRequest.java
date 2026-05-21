package com.gei.dto;

public record AuthRequest(
        String email,
        String senha
) {
}