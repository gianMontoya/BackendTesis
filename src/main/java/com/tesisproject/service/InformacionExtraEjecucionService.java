package com.tesisproject.service;

import com.tesisproject.entity.InformacionExtraEjecucion;
import com.tesisproject.repository.InformacionExtraEjecucionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformacionExtraEjecucionService {
    @Autowired
    private InformacionExtraEjecucionRepository informacionExtraEjecucionRepository;

    public List<InformacionExtraEjecucion> getAllByEjecucionModelo(Long idEjecucionModelo){
       return informacionExtraEjecucionRepository.findAllByFidEjecucionModelo(idEjecucionModelo);
    }
}
