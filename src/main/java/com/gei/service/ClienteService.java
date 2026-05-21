package com.gei.service;

import com.gei.dto.ClienteRequest;
import com.gei.dto.ClienteResponse;
import com.gei.entity.Cliente;
import com.gei.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteResponse criar(ClienteRequest request) {

        if (clienteRepository.findByCpf(request.getCpf().trim()).isPresent()) {
            throw new RuntimeException("CPF já cadastrado");
        }

        if (clienteRepository.findByEmail(request.getEmail().trim()).isPresent()) {
            throw new RuntimeException("Email já cadastrado");
        }

        Cliente cliente = new Cliente();

        cliente.setNome(request.getNome());
        cliente.setCpf(request.getCpf());
        cliente.setEmail(request.getEmail());
        cliente.setTelefone(request.getTelefone());
        cliente.setAtivo(request.getAtivo() != null ? request.getAtivo() : true);
        cliente.setDataCadastro(LocalDateTime.now());

        Cliente salvo = clienteRepository.save(cliente);

        return toResponse(salvo);
    }

    public List<ClienteResponse> listarTodos() {
        return clienteRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public ClienteResponse buscarPorId(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        return toResponse(cliente);
    }

    public ClienteResponse atualizar(Long id, ClienteRequest request) {

        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        cliente.setNome(request.getNome());
        cliente.setCpf(request.getCpf());
        cliente.setEmail(request.getEmail());
        cliente.setTelefone(request.getTelefone());
        cliente.setAtivo(request.getAtivo());

        Cliente atualizado = clienteRepository.save(cliente);

        return toResponse(atualizado);
    }

    public void deletar(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        clienteRepository.delete(cliente);
    }

    private ClienteResponse toResponse(Cliente cliente) {
        return new ClienteResponse(
                cliente.getId(),
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getEmail(),
                cliente.getTelefone(),
                cliente.getDataCadastro(),
                cliente.getAtivo()
        );
    }
}