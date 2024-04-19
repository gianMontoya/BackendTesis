package com.tesisproject.service;

import com.tesisproject.entity.Rol;
import com.tesisproject.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolService {
    @Autowired
    private RolRepository rolRepository;

    public List<Rol> getRoles() {
        return rolRepository.findAll();
    }

    public Optional<Rol> getRol(Long id) {
        return rolRepository.findById(id);
    }

    public void saveOrUpdateRol(Rol rol) {
        rolRepository.save(rol);
    }

    public void deleteRol(Long id) {
        rolRepository.deleteById(id);
    }
}
