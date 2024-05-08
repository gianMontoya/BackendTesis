package com.tesisproject.repository;

import com.tesisproject.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository  extends JpaRepository<Cliente, Long> {
    List<Cliente> findByNombreClienteContains(String nombre);
}
