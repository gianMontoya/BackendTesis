package com.tesisproject.service;

import com.tesisproject.entity.EjecucionModelo;
import com.tesisproject.repository.EjecucionModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EjecucionModeloService {
    @Autowired
    private EjecucionModeloRepository ejecucionModeloRepository;

    public List<EjecucionModelo> getEjecuciones() {
        return ejecucionModeloRepository.findAll();
    }

    public List<EjecucionModelo> getEjecucion(LocalDateTime fecha) {
        return ejecucionModeloRepository.findAllByFechaEjecucion(fecha);
    }
}
