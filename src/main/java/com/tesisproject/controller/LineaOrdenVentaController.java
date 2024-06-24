package com.tesisproject.controller;


import com.tesisproject.entity.LineaOrdenVenta;
import com.tesisproject.entity.Producto;
import com.tesisproject.service.LineaOrdenVentaService;
import com.tesisproject.service.ProductoService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/linea-orden-venta")
@CrossOrigin
public class LineaOrdenVentaController {

    @Autowired
    private LineaOrdenVentaService lineaOrdenVentaService;
    private final ProductoService productoService;

    public LineaOrdenVentaController(ProductoService productoService) {
        this.productoService = productoService;
    }


    @PostMapping
    public void saveLineaOrdenVenta(@RequestBody List<LineaOrdenVenta> lineasOrdenVenta) {
        for (LineaOrdenVenta lineaOrdenVenta : lineasOrdenVenta) {
            lineaOrdenVentaService.saveLineaOrdenVenta(lineaOrdenVenta);
        }
    }

    @GetMapping("/{idVenta}")
    public List<JSONObject> obtenerLineasOrdenVenta(@PathVariable Long idVenta) {
        List<JSONObject> listJsonLineasOrdenes = new ArrayList<>();

        List<LineaOrdenVenta> listLineasOrdenVenta =  lineaOrdenVentaService.findAllByIdOrdenVenta(idVenta);

        for (LineaOrdenVenta lineaOrdenVenta : listLineasOrdenVenta) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", lineaOrdenVenta.getId());
            jsonObject.put("cantidad", lineaOrdenVenta.getCantidad());
            jsonObject.put("precio", lineaOrdenVenta.getPrecio());
            jsonObject.put("fechaEntrega", lineaOrdenVenta.getFechaEntrega());
            Optional<Producto> producto = productoService.getProducto(lineaOrdenVenta.getFidProducto());
            producto.ifPresent(value -> jsonObject.put("nombreProducto", value.getNombreProducto()));
            producto.ifPresent(value -> jsonObject.put("pesoTotal", value.getPesoRollo()*lineaOrdenVenta.getCantidad()));
            listJsonLineasOrdenes.add(jsonObject);
        }

        return listJsonLineasOrdenes;
    }
}
