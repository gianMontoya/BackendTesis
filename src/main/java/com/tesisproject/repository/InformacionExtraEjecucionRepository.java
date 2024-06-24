package com.tesisproject.repository;

import com.tesisproject.entity.InformacionExtraEjecucion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InformacionExtraEjecucionRepository extends JpaRepository<InformacionExtraEjecucion, Long> {
    List<InformacionExtraEjecucion> findAllByFidEjecucionModelo(Long idEjecucion);
}
