package com.gei.repository;

import com.gei.entity.Carteira;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarteiraRepository extends JpaRepository<Carteira, Long> {

    List<Carteira> findByClienteId(Long clienteId);
}