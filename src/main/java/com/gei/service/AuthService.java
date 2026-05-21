package com.gei.service;

import com.gei.dto.AuthRequest;
import com.gei.dto.AuthResponse;
import com.gei.dto.RegisterRequest;
import com.gei.entity.Usuario;
import com.gei.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthResponse register(RegisterRequest request) {

        Usuario usuario = new Usuario();

        usuario.setNome(request.nome());
        usuario.setEmail(request.email());
        usuario.setSenha(passwordEncoder.encode(request.senha()));
        usuario.setRole(request.role());

        usuarioRepository.save(usuario);

        String token = jwtService.generateToken(usuario.getEmail());

        return new AuthResponse(token);
    }

    public AuthResponse login(AuthRequest request) {

        Usuario usuario = usuarioRepository.findByEmail(request.email())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        if (!passwordEncoder.matches(request.senha(), usuario.getSenha())) {
            throw new RuntimeException("Senha inválida");
        }

        String token = jwtService.generateToken(usuario.getEmail());

        return new AuthResponse(token);
    }
}