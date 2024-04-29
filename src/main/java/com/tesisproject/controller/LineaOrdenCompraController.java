package com.tesisproject.controller;

import com.tesisproject.entity.LineaOrdenCompra;
import com.tesisproject.service.LineaOrdenCompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/linea-orden-compra")
@CrossOrigin
public class LineaOrdenCompraController {
    @Autowired
    private LineaOrdenCompraService lineaOrdenCompraService;

    @PostMapping
    public void saveLineaOrdenCompra(@RequestBody List<LineaOrdenCompra> lineasOrdenCompra) {
        for (LineaOrdenCompra lineaOrdenCompra : lineasOrdenCompra) {
            lineaOrdenCompraService.saveLineaOrdenCompra(lineaOrdenCompra);
        }
    }
}
