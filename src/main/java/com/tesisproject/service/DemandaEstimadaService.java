package com.tesisproject.service;

import com.tesisproject.entity.DemandaEstimada;
import com.tesisproject.repository.DemandaEstimadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemandaEstimadaService {
    @Autowired
    private DemandaEstimadaRepository demandaEstimadaRepository;

    public List<DemandaEstimada> getDemandaEstimadaByEjecucion(Long idEjecucion){
        return demandaEstimadaRepository.findAllByFidEjecucionModelo(idEjecucion);
    }
}
