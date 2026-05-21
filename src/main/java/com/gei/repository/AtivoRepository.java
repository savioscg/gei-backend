package com.gei.repository;

import com.gei.entity.Ativo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AtivoRepository extends JpaRepository<Ativo, Long> {

    Optional<Ativo> findByTicker(String ticker);

    boolean existsByTicker(String ticker);
}