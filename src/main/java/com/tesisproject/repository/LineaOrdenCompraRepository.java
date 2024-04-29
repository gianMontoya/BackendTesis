package com.tesisproject.repository;

import com.tesisproject.entity.LineaOrdenCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LineaOrdenCompraRepository extends JpaRepository<LineaOrdenCompra, Long> {
    List<LineaOrdenCompra> findAllLineaOrdenCompraByFidOrdenCompra(Long id);
}
