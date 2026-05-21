package com.gei.service;

import com.gei.dto.CarteiraRequest;
import com.gei.dto.CarteiraResponse;
import com.gei.entity.Carteira;
import com.gei.entity.Cliente;
import com.gei.repository.CarteiraRepository;
import com.gei.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarteiraService {

    private final CarteiraRepository carteiraRepository;
    private final ClienteRepository clienteRepository;

    public CarteiraResponse criar(CarteiraRequest request) {

        Cliente cliente = clienteRepository.findById(request.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        Carteira carteira = new Carteira();

        carteira.setNome(request.getNome());
        carteira.setPerfilRisco(request.getPerfilRisco());
        carteira.setSaldo(request.getSaldo() != null ? request.getSaldo() : 0.0);
        carteira.setCliente(cliente);

        Carteira salva = carteiraRepository.save(carteira);

        return toResponse(salva);
    }

    public List<CarteiraResponse> listarTodas() {
        return carteiraRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public CarteiraResponse buscarPorId(Long id) {
        Carteira carteira = carteiraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carteira não encontrada"));

        return toResponse(carteira);
    }

    public List<CarteiraResponse> listarPorCliente(Long clienteId) {
        return carteiraRepository.findByClienteId(clienteId)
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public CarteiraResponse atualizar(Long id, CarteiraRequest request) {

        Carteira carteira = carteiraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carteira não encontrada"));

        Cliente cliente = clienteRepository.findById(request.getClienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        carteira.setNome(request.getNome());
        carteira.setPerfilRisco(request.getPerfilRisco());
        carteira.setSaldo(request.getSaldo());
        carteira.setCliente(cliente);

        Carteira atualizada = carteiraRepository.save(carteira);

        return toResponse(atualizada);
    }

    public void deletar(Long id) {
        Carteira carteira = carteiraRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carteira não encontrada"));

        carteiraRepository.delete(carteira);
    }

    private CarteiraResponse toResponse(Carteira carteira) {
        CarteiraResponse response = new CarteiraResponse();

        response.setId(carteira.getId());
        response.setNome(carteira.getNome());
        response.setPerfilRisco(carteira.getPerfilRisco());
        response.setSaldo(carteira.getSaldo());
        response.setDataCriacao(carteira.getDataCriacao());
        response.setClienteId(carteira.getCliente().getId());
        response.setClienteNome(carteira.getCliente().getNome());

        return response;
    }
}