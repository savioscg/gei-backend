package com.gei.controller;

import com.gei.dto.AtivoRequest;
import com.gei.dto.AtivoResponse;
import com.gei.service.AtivoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ativos")
@RequiredArgsConstructor
public class AtivoController {

    private final AtivoService ativoService;

    @PostMapping
    public AtivoResponse criar(@RequestBody @Valid AtivoRequest request) {
        return ativoService.criar(request);
    }

    @GetMapping
    public List<AtivoResponse> listarTodos() {
        return ativoService.listarTodos();
    }

    @GetMapping("/{id}")
    public AtivoResponse buscarPorId(@PathVariable Long id) {
        return ativoService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public AtivoResponse atualizar(
            @PathVariable Long id,
            @RequestBody @Valid AtivoRequest request
    ) {
        return ativoService.atualizar(id, request);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        ativoService.deletar(id);
    }
}