package com.gei.controller;

import com.gei.dto.CarteiraRequest;
import com.gei.dto.CarteiraResponse;
import com.gei.service.CarteiraService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carteiras")
@RequiredArgsConstructor
public class CarteiraController {

    private final CarteiraService carteiraService;

    @PostMapping
    public CarteiraResponse criar(@RequestBody CarteiraRequest request) {
        return carteiraService.criar(request);
    }

    @GetMapping
    public List<CarteiraResponse> listarTodas() {
        return carteiraService.listarTodas();
    }

    @GetMapping("/{id}")
    public CarteiraResponse buscarPorId(@PathVariable Long id) {
        return carteiraService.buscarPorId(id);
    }

    @GetMapping("/cliente/{clienteId}")
    public List<CarteiraResponse> listarPorCliente(@PathVariable Long clienteId) {
        return carteiraService.listarPorCliente(clienteId);
    }

    @PutMapping("/{id}")
    public CarteiraResponse atualizar(
            @PathVariable Long id,
            @RequestBody CarteiraRequest request
    ) {
        return carteiraService.atualizar(id, request);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        carteiraService.deletar(id);
    }
}