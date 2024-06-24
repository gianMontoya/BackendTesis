package com.tesisproject.repository;

import com.tesisproject.entity.DemandaEstimada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemandaEstimadaRepository extends JpaRepository<DemandaEstimada, Long> {
    List<DemandaEstimada> findAllByFidEjecucionModelo(Long idEjecucionModelo);
}
