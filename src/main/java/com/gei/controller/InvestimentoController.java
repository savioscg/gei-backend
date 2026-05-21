package com.gei.controller;

import com.gei.dto.InvestimentoRequest;
import com.gei.dto.InvestimentoResponse;
import com.gei.service.InvestimentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/investimentos")
@RequiredArgsConstructor
public class InvestimentoController {

    private final InvestimentoService investimentoService;

    @PostMapping
    public InvestimentoResponse criar(@RequestBody InvestimentoRequest request) {
        return investimentoService.criar(request);
    }

    @GetMapping
    public List<InvestimentoResponse> listarTodos() {
        return investimentoService.listarTodos();
    }

    @GetMapping("/{id}")
    public InvestimentoResponse buscarPorId(@PathVariable Long id) {
        return investimentoService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public InvestimentoResponse atualizar(
            @PathVariable Long id,
            @RequestBody InvestimentoRequest request
    ) {
        return investimentoService.atualizar(id, request);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        investimentoService.deletar(id);
    }
}