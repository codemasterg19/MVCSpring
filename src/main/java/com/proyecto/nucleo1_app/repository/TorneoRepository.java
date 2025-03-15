package com.proyecto.nucleo1_app.repository;

import com.proyecto.nucleo1_app.models.Torneo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TorneoRepository extends JpaRepository<Torneo, Long> {
}
