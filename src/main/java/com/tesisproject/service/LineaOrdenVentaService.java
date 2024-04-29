package com.tesisproject.service;

import com.tesisproject.entity.LineaOrdenVenta;
import com.tesisproject.repository.LineaOrdenVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LineaOrdenVentaService {

    @Autowired
    private LineaOrdenVentaRepository lineaOrdenVentaRepository;

    public List<LineaOrdenVenta> findAllByIdOrdenVenta(Long idOrdenVenta) {
        return lineaOrdenVentaRepository.findAllLineaOrdenVentaByFidOrdenVenta(idOrdenVenta);
    }

    public void saveLineaOrdenVenta(LineaOrdenVenta lineaOrdenVenta) {
        lineaOrdenVentaRepository.save(lineaOrdenVenta);
    }
}
