package com.tesisproject.repository;

import com.tesisproject.entity.Tiempo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TiempoRepository extends JpaRepository<Tiempo, Long> {
    Optional<Tiempo> findByAnhoAndMes(Integer anho, Integer Mes);
}
