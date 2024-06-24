package com.tesisproject.repository;

import com.tesisproject.entity.ValorInformacionExtraGeneral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ValorInformacionExtraGeneralRepository extends JpaRepository<ValorInformacionExtraGeneral, Long> {
    List<ValorInformacionExtraGeneral> findValorInformacionExtraGeneralByFidInformacionExtraOrderByFidTiempoAsc(Long idInformacion);
}
