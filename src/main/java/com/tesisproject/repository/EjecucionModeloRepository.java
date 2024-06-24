package com.tesisproject.repository;

import com.tesisproject.entity.EjecucionModelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EjecucionModeloRepository extends JpaRepository<EjecucionModelo, Long> {
    List<EjecucionModelo> findAllByFechaEjecucion(LocalDateTime fecha);
}
