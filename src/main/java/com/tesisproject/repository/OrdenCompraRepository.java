package com.tesisproject.repository;

import com.tesisproject.entity.OrdenCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrdenCompraRepository extends JpaRepository<OrdenCompra, Long> {
    List<OrdenCompra> findAllByOrderByIdDesc();

    List<OrdenCompra> findAllByFechaCreacionBetweenOrderByIdDesc(LocalDate from, LocalDate to);

}
