package com.tesisproject.repository;

import com.tesisproject.entity.Proveedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {
    List<Proveedor> findAllByActivoIsTrue();
    List<Proveedor> findAllByNombreProveedorContains(String nombre);
}
