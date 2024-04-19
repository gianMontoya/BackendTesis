package com.tesisproject.service;

import com.tesisproject.entity.Proveedor;
import com.tesisproject.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    public List<Proveedor> getProveedores() {
        return proveedorRepository.findAll();
    }

    public Optional<Proveedor> getProveedor(Long id) {
        return proveedorRepository.findById(id);
    }

    public void saveOrUpdateProveedor(Proveedor proveedor) {
        proveedorRepository.save(proveedor);
    }

    public void deleteProveedor(Long id) {
        proveedorRepository.deleteById(id);
    }
}
