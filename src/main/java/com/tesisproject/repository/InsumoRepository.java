package com.tesisproject.repository;

import com.tesisproject.entity.Insumo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InsumoRepository extends JpaRepository<Insumo, Long> {

    List<Insumo> findAllByActivoIsTrue();

    List<Insumo> findAllByNombreInsumoContains(String name);
}
