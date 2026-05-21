package com.gei.service;

import com.gei.dto.AtivoRequest;
import com.gei.dto.AtivoResponse;
import com.gei.entity.Ativo;
import com.gei.repository.AtivoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AtivoService {

    private final AtivoRepository ativoRepository;

    public AtivoResponse criar(AtivoRequest request) {

        if (ativoRepository.existsByTicker(request.getTicker())) {
            throw new RuntimeException("Ticker já cadastrado");
        }

        Ativo ativo = new Ativo();
        ativo.setNome(request.getNome());
        ativo.setTicker(request.getTicker().toUpperCase());
        ativo.setTipo(request.getTipo());
        ativo.setPrecoAtual(request.getPrecoAtual());
        ativo.setDescricao(request.getDescricao());
        ativo.setAtivo(request.getAtivo());

        Ativo salvo = ativoRepository.save(ativo);

        return toResponse(salvo);
    }

    public List<AtivoResponse> listarTodos() {
        return ativoRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public AtivoResponse buscarPorId(Long id) {
        Ativo ativo = ativoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ativo não encontrado"));

        return toResponse(ativo);
    }

    public AtivoResponse atualizar(Long id, AtivoRequest request) {

        Ativo ativo = ativoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ativo não encontrado"));

        ativo.setNome(request.getNome());
        ativo.setTicker(request.getTicker().toUpperCase());
        ativo.setTipo(request.getTipo());
        ativo.setPrecoAtual(request.getPrecoAtual());
        ativo.setDescricao(request.getDescricao());
        ativo.setAtivo(request.getAtivo());

        Ativo atualizado = ativoRepository.save(ativo);

        return toResponse(atualizado);
    }

    public void deletar(Long id) {
        Ativo ativo = ativoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ativo não encontrado"));

        ativoRepository.delete(ativo);
    }

    private AtivoResponse toResponse(Ativo ativo) {
        return new AtivoResponse(
                ativo.getId(),
                ativo.getNome(),
                ativo.getTicker(),
                ativo.getTipo(),
                ativo.getPrecoAtual(),
                ativo.getDescricao(),
                ativo.getAtivo()
        );
    }
}