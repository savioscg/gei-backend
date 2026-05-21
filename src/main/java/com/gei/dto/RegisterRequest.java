package com.gei.dto;

import com.gei.entity.Role;

public record RegisterRequest(
        String nome,
        String email,
        String senha,
        Role role
) {
}