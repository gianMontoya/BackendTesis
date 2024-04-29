package com.tesisproject.controller;

import com.tesisproject.entity.Insumo;
import com.tesisproject.entity.LineaOrdenCompra;
import com.tesisproject.service.InsumoService;
import com.tesisproject.service.LineaOrdenCompraService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/linea-orden-compra")
@CrossOrigin
public class LineaOrdenCompraController {
    @Autowired
    private LineaOrdenCompraService lineaOrdenCompraService;
    private final InsumoService insumoService;

    public LineaOrdenCompraController(InsumoService insumoService) {
        this.insumoService = insumoService;
    }

    @PostMapping
    public void saveLineaOrdenCompra(@RequestBody List<LineaOrdenCompra> lineasOrdenCompra) {
        for (LineaOrdenCompra lineaOrdenCompra : lineasOrdenCompra) {
            lineaOrdenCompraService.saveLineaOrdenCompra(lineaOrdenCompra);
        }
    }

    @GetMapping("/{idCompra}")
    public List<JSONObject> obtenerLineasOrdenCompra(@PathVariable Long idCompra) {
        List<JSONObject> listJsonLineasOrdenes = new ArrayList<>();

        List<LineaOrdenCompra> listLineasOrdenCompra =  lineaOrdenCompraService.findAllByIdOrdenCompra(idCompra);

        for (LineaOrdenCompra lineaOrdenCompra : listLineasOrdenCompra) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", lineaOrdenCompra.getId());
            jsonObject.put("cantidad", lineaOrdenCompra.getCantidad());
            jsonObject.put("precio", lineaOrdenCompra.getPrecio());
            Optional<Insumo> insumo = insumoService.getInsumo(lineaOrdenCompra.getFidInsumo());
            insumo.ifPresent(value -> jsonObject.put("nombreInsumo", value.getNombreInsumo()));
            insumo.ifPresent(value -> jsonObject.put("pesoTotal", value.getPesoPaquete()*lineaOrdenCompra.getCantidad()));
            listJsonLineasOrdenes.add(jsonObject);
        }

        return listJsonLineasOrdenes;
    }
}
