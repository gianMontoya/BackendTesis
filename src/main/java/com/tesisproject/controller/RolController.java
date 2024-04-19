package com.tesisproject.controller;

import com.tesisproject.entity.Rol;
import com.tesisproject.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/roles")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping
    public List<Rol> getRoles() {
        return rolService.getRoles();
    }

    @GetMapping("{rolId}")
    public Optional<Rol> getRol(@PathVariable Long rolId) {
        return rolService.getRol(rolId);
    }

    @PostMapping
    public void saveOrUpdateRol(@RequestBody Rol rol) {
        rolService.saveOrUpdateRol(rol);
    }

    @DeleteMapping("{rolId}")
    public void deleteRol(@PathVariable Long rolId) {
        rolService.deleteRol(rolId);
    }
}
