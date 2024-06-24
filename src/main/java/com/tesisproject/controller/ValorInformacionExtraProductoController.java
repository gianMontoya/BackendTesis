package com.tesisproject.controller;

import com.tesisproject.entity.ValorInformacionExtraProducto;
import com.tesisproject.service.ValorInformacionExtraProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/valores-extra-producto")
@CrossOrigin
public class ValorInformacionExtraProductoController {

    @Autowired
    private ValorInformacionExtraProductoService valorInformacionExtraProductoService;

    @GetMapping
    public List<ValorInformacionExtraProducto> getValoresInformacionExtraGeneral() {
        return valorInformacionExtraProductoService.getValoresInformacionExtraProducto();
    }

    @GetMapping("{informacionId}")
    public List<ValorInformacionExtraProducto> getValoresInformacionExtraGeneralByIdInformacion(@PathVariable("informacionId") Long idInformacion) {
        return valorInformacionExtraProductoService.findValorInformacionExtraProductoByIdInformacion(idInformacion);
    }

    @PostMapping
    public void saveOrUpdateValoresInformacionExtraProducto(@RequestBody ValorInformacionExtraProducto valorInformacionExtraProducto) {
        valorInformacionExtraProductoService.saveOrUpdateValorInformacionExtraProducto(valorInformacionExtraProducto);
    }
}
