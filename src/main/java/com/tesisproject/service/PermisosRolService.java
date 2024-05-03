package com.tesisproject.service;

import com.tesisproject.entity.Permisosxrol;
import com.tesisproject.repository.PermisosRolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PermisosRolService{

    @Autowired
    private PermisosRolRepository permisosRolRepository;

    public Optional<Permisosxrol> getPermisosxrolByFidUsuario(Long id){
        return permisosRolRepository.findPermisosxrolByFidUsuario(id);
    }

    public void createOrUpdatePermisosxrol(Permisosxrol permisosxrol){
        permisosRolRepository.save(permisosxrol);
    }
}
