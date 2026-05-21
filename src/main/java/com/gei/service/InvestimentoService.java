package com.gei.service;

import com.gei.dto.InvestimentoRequest;
import com.gei.dto.InvestimentoResponse;
import com.gei.entity.Ativo;
import com.gei.entity.Carteira;
import com.gei.entity.Investimento;
import com.gei.repository.AtivoRepository;
import com.gei.repository.CarteiraRepository;
import com.gei.repository.InvestimentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InvestimentoService {

    private final InvestimentoRepository investimentoRepository;
    private final CarteiraRepository carteiraRepository;
    private final AtivoRepository ativoRepository;

    public InvestimentoResponse criar(InvestimentoRequest request) {

        Carteira carteira = carteiraRepository.findById(request.carteiraId())
                .orElseThrow(() -> new RuntimeException("Carteira não encontrada"));

        Ativo ativo = ativoRepository.findById(request.ativoId())
                .orElseThrow(() -> new RuntimeException("Ativo não encontrado"));

        Investimento investimento = new Investimento();
        investimento.setQuantidade(request.quantidade());
        investimento.setPrecoCompra(request.precoCompra());
        investimento.setDataCompra(LocalDateTime.now());
        investimento.setCarteira(carteira);
        investimento.setAtivo(ativo);

        investimentoRepository.save(investimento);

        return toResponse(investimento);
    }

    public List<InvestimentoResponse> listarTodos() {
        return investimentoRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public InvestimentoResponse buscarPorId(Long id) {
        Investimento investimento = investimentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Investimento não encontrado"));

        return toResponse(investimento);
    }

    public InvestimentoResponse atualizar(Long id, InvestimentoRequest request) {

        Investimento investimento = investimentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Investimento não encontrado"));

        Carteira carteira = carteiraRepository.findById(request.carteiraId())
                .orElseThrow(() -> new RuntimeException("Carteira não encontrada"));

        Ativo ativo = ativoRepository.findById(request.ativoId())
                .orElseThrow(() -> new RuntimeException("Ativo não encontrado"));

        investimento.setQuantidade(request.quantidade());
        investimento.setPrecoCompra(request.precoCompra());
        investimento.setCarteira(carteira);
        investimento.setAtivo(ativo);

        investimentoRepository.save(investimento);

        return toResponse(investimento);
    }

    public void deletar(Long id) {
        investimentoRepository.deleteById(id);
    }

    private InvestimentoResponse toResponse(Investimento investimento) {
        return new InvestimentoResponse(
                investimento.getId(),
                investimento.getQuantidade(),
                investimento.getPrecoCompra(),
                investimento.getDataCompra(),
                investimento.getCarteira().getId(),
                investimento.getCarteira().getNome(),
                investimento.getAtivo().getId(),
                investimento.getAtivo().getNome(),
                investimento.getAtivo().getTicker()
        );
    }
}