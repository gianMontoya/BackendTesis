package com.tesisproject.controller;

import com.tesisproject.entity.InformacionExtra;
import com.tesisproject.service.InformacionExtraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/informacion")
@CrossOrigin
public class InformacionExtraController {
    @Autowired
    private InformacionExtraService informacionExtraService;

    @GetMapping
    public List<InformacionExtra> getInformaciones() {
        return  informacionExtraService.getInformacionesExtra();
    }

    @GetMapping("{informacionId}")
    public Optional<InformacionExtra> getInformacion(@PathVariable("informacionId") Long id) {
        return  informacionExtraService.getInformacionExtra(id);
    }

    @PostMapping
    public InformacionExtra saveOrUpdate(@RequestBody InformacionExtra informacionExtra) {
        return informacionExtraService.saveOrUpdate(informacionExtra);

    }
}

