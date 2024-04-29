package com.tesisproject.repository;

import com.tesisproject.entity.OrdenVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrdenVentaRepository extends JpaRepository<OrdenVenta, Long> {
    List<OrdenVenta> findAllByOrderByIdDesc();

    List<OrdenVenta> findAllByFechaCreacionBetweenOrderByIdDesc(LocalDate from, LocalDate to);
}
