package com.tesisproject.controller;


import com.tesisproject.entity.InsumoProducto;
import com.tesisproject.service.InsumoProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/insumo-producto")
@CrossOrigin
public class InsumoProductoController {
    @Autowired
    private InsumoProductoService insumoProductoService;

    @PostMapping
    public void saveInsumoProducto(@RequestBody List<InsumoProducto> insumosProducto) {
        if (!insumosProducto.isEmpty()) {
            Long productId = insumosProducto.getFirst().getFidProducto();
            List<InsumoProducto> actualInsumos=  insumoProductoService.getByProductoId(productId);
            for (InsumoProducto insumoProducto : actualInsumos) {
                insumoProductoService.deleteInsumoProducto(insumoProducto.getId());
            }
        }
        System.out.println(insumosProducto);
        for (InsumoProducto insumoProducto : insumosProducto) {
            insumoProductoService.saveOrUpdate(insumoProducto);
        }
    }
}
