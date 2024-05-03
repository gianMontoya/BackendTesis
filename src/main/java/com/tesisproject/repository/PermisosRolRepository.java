package com.tesisproject.repository;

import com.tesisproject.entity.Permisosxrol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PermisosRolRepository extends JpaRepository<Permisosxrol, Long> {

    Optional<Permisosxrol> findPermisosxrolByFidUsuario(Long id);
}
