package com.tesisproject.repository;

import com.tesisproject.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByCorreoAndActivoIsTrue(String correo);
    List<Usuario> findByNombresContainsOrApellidoPaternoContainsOrApellidoMaternoContains(String nombres, String apellidoPaterno, String apellidoMaterno);
}
