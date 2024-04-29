package com.tesisproject.controller;

import com.tesisproject.entity.OrdenCompra;
import com.tesisproject.service.OrdenCompraService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/compras")
@CrossOrigin
public class OrdenCompraController {
    @Autowired
    private OrdenCompraService ordenCompraService;

    @GetMapping
    public List<JSONObject> getOrdenCompras() {
        return ordenCompraService.getAllOrdenCompra();
    }

    @GetMapping("/{desde}/{hasta}")
    public List<JSONObject> getOrdenComprasFechaCreacionEntre(@PathVariable LocalDate desde,@PathVariable  LocalDate hasta) {
        return ordenCompraService.getAllOrdenCompraByFechaCreacionEntre(desde,hasta);
    }

    @PostMapping
    public OrdenCompra saveOrUpdateOrdenCompra(@RequestBody OrdenCompra ordenCompra) {
        return ordenCompraService.saveOrUpdateOrdenCompra(ordenCompra);
    }
}
