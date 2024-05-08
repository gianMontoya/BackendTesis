package com.tesisproject.controller;

import com.tesisproject.entity.Insumo;
import com.tesisproject.service.InsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/insumos")
@CrossOrigin
public class InsumoController {

    @Autowired
    private InsumoService insumoService;

    @GetMapping
    public List<Insumo> getInsumos() {
        return insumoService.getInsumos();
    }

    @GetMapping("/activos")
    public List<Insumo> getInsumosActivos() {
        return insumoService.getInsumosActivos();
    }

    @GetMapping("{insumoId}")
    public Optional<Insumo> getInsumo(@PathVariable("insumoId") Long id) {
        return insumoService.getInsumo(id);
    }

    @GetMapping("/nombre/{nombre}")
    public List<Insumo> getInsumosByName(@PathVariable("nombre") String nombre) {
        return insumoService.getInsumosByNombre(nombre);
    }

    @PostMapping
    public void saveOrUpdateInsumo(@RequestBody Insumo insumo) {
        insumoService.saveOrUpdateInsumo(insumo);
    }

    @DeleteMapping("{insumoId}")
    public void deleteInsumo(@PathVariable("insumoId") Long id) {
        insumoService.deleteInsumo(id);
    }
}
