package com.julianoseus.demo_park_api.repository;

import com.julianoseus.demo_park_api.entity.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VagaRepository extends JpaRepository<Vaga, Long> {

    Optional<Vaga> findbyCodigo(String codigo);
}
