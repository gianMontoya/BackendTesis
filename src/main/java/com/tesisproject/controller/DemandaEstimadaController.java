package com.tesisproject.controller;

import com.tesisproject.entity.DemandaEstimada;
import com.tesisproject.service.DemandaEstimadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/demanda-estimada")
@CrossOrigin
public class DemandaEstimadaController {
    @Autowired
    private DemandaEstimadaService demandaEstimadaService;

    @GetMapping("{ejecucionId}")
    public List<DemandaEstimada> getDemandaEstimadaByEjecucion(@PathVariable("ejecucionId") Long idEjecucion){
        return demandaEstimadaService.getDemandaEstimadaByEjecucion(idEjecucion);
    }
}
