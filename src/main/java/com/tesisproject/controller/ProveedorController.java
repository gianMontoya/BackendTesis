package com.tesisproject.controller;


import com.tesisproject.entity.Proveedor;
import com.tesisproject.service.ProveedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/proveedores")
@CrossOrigin
public class ProveedorController {
    @Autowired
    private ProveedorService proveedorService;

    @GetMapping
    public List<Proveedor> getProveedores() {
        return proveedorService.getProveedores();
    }

    @GetMapping("/nombre/{nombre}")
    public List<Proveedor> getProveedoresByNombre(@PathVariable String nombre) {
        return proveedorService.getProveedoresByNombre(nombre);
    }

    @GetMapping("/activos")
    public List<Proveedor> getProveedoresActivos() {
        return proveedorService.getProveedoresActivos();
    }

    @GetMapping("{proveedorId}")
    public Optional<Proveedor> getProveedor(@PathVariable("proveedorId") Long id) {
        return proveedorService.getProveedor(id);
    }

    @PostMapping
    public void saveOrUpdateProveedor(@RequestBody Proveedor proveedor) {
        proveedorService.saveOrUpdateProveedor(proveedor);
    }

    @DeleteMapping("{proveedorId}")
    public void deleteProveedor(@PathVariable("proveedorId") Long id) {
        proveedorService.deleteProveedor(id);
    }
}
