package com.tesisproject.service;

import com.tesisproject.entity.LineaOrdenCompra;
import com.tesisproject.repository.LineaOrdenCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LineaOrdenCompraService {
    @Autowired
    private LineaOrdenCompraRepository lineaOrdenCompraRepository;

    public List<LineaOrdenCompra> findAllByIdOrdenCompra(Long idOrdenCompra) {
        return lineaOrdenCompraRepository.findAllLineaOrdenCompraByFidOrdenCompra(idOrdenCompra);
    }

    public void saveLineaOrdenCompra(LineaOrdenCompra lineaOrdenCompra) {
        lineaOrdenCompraRepository.save(lineaOrdenCompra);
    }
}
