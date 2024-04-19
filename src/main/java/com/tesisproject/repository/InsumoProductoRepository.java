package com.tesisproject.repository;

import com.tesisproject.entity.InsumoProducto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InsumoProductoRepository extends JpaRepository<InsumoProducto, Long> {
    List<InsumoProducto> findByFidProducto(Long id);
}
