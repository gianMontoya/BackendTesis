package com.tesisproject.repository;

import com.tesisproject.entity.LineaOrdenVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LineaOrdenVentaRepository extends JpaRepository<LineaOrdenVenta, Long> {
    List<LineaOrdenVenta> findAllLineaOrdenVentaByFidOrdenVenta(Long id);
    List<LineaOrdenVenta> findAllLineaOrdenVentaByFidOrdenVentaAndFidProducto(Long idOrden, Long idProducto);

}
