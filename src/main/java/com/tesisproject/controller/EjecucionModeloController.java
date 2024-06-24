package com.tesisproject.controller;

import com.tesisproject.entity.EjecucionModelo;
import com.tesisproject.service.EjecucionModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api/v1/ejecuciones")
@CrossOrigin
public class EjecucionModeloController{
    @Autowired
    private EjecucionModeloService ejecucionModeloService;

    @GetMapping
    public List<EjecucionModelo> getEjecuciones(){
        return ejecucionModeloService.getEjecuciones();
    }

    @GetMapping("{fecha}")
    public List<EjecucionModelo> getEjecucion(@PathVariable("fecha") LocalDateTime fecha){
        return ejecucionModeloService.getEjecucion(fecha);
    }

}
