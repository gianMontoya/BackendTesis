package com.tesisproject.service;

import com.tesisproject.entity.InsumoProducto;
import com.tesisproject.repository.InsumoProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class InsumoProductoService {
    @Autowired
    private InsumoProductoRepository insumoProductoRepository;

    public List<InsumoProducto> getByProductoId(Long id) {
        return insumoProductoRepository.findByFidProducto(id);
    }

    public void saveOrUpdate(InsumoProducto insumoProducto) {
        insumoProductoRepository.save(insumoProducto);
    }

    public void deleteInsumoProducto(Long id) {
        insumoProductoRepository.deleteById(id);
    }
}
