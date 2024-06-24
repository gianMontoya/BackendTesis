package com.tesisproject.repository;

import com.tesisproject.entity.OrdenVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Repository
public interface OrdenVentaRepository extends JpaRepository<OrdenVenta, Long> {
    List<OrdenVenta> findAllByOrderByFechaCreacionDesc();

    List<OrdenVenta> findAllByFechaCreacionBetweenOrderByIdDesc(LocalDate from, LocalDate to);

    @Query(value = "SELECT YEAR(fecha_entrega) AS anho, MONTH(fecha_entrega) AS mes, " +
            "SUM(cantidad) AS cantidad_total_vendida " +
            "FROM Linea_Orden_Venta " +
            "WHERE fid_producto = :idProducto " +
            "GROUP BY YEAR(fecha_entrega), MONTH(fecha_entrega) " +
            "ORDER BY anho, mes", nativeQuery = true)
    List<Map<String, Object>> obtenerVentasPorMesYProducto(@Param("idProducto") Long idProducto);

}
