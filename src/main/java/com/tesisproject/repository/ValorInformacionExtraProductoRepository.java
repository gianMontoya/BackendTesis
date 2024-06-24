package com.tesisproject.repository;

import com.tesisproject.entity.ValorInformacionExtraProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ValorInformacionExtraProductoRepository extends JpaRepository<ValorInformacionExtraProducto, Long> {
    List<ValorInformacionExtraProducto> findValorInformacionExtraProductoByFidInformacionExtraOrderByFidTiempoAsc(Long idInformacion);
}
