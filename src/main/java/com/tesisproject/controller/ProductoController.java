package com.tesisproject.controller;

import com.tesisproject.entity.InsumoProducto;
import com.tesisproject.entity.Producto;
import com.tesisproject.service.InsumoProductoService;
import com.tesisproject.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import net.minidev.json.JSONObject;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/productos")
@CrossOrigin
public class ProductoController {

    @Autowired
    private ProductoService productoService;
    private final InsumoProductoService insumoProductoService;

    public ProductoController(InsumoProductoService insumoProductoService) {
        this.insumoProductoService = insumoProductoService;
    }

    @GetMapping
    public List<Producto> getProductos() {
        return productoService.getProductos();
    }

    @GetMapping("/nombre/{nombre}")
    public List<Producto> getProductosByName(@PathVariable("nombre") String nombre) {
        return productoService.getProductoByNombre(nombre);
    }

    @GetMapping("{productoId}")
    public ResponseEntity<JSONObject> getProducto(@PathVariable("productoId") Long id) {
        JSONObject finalJson = new JSONObject();
        Optional<Producto> producto = Optional.ofNullable(productoService.getProducto(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.BAD_REQUEST, "Producto no encontrado")));

        List<InsumoProducto> insumosProducto = insumoProductoService.getByProductoId(id);
        if (producto.isPresent()) {
            finalJson.put("id", producto.get().getId());
            finalJson.put("nombreProducto", producto.get().getNombreProducto());
            finalJson.put("descripcion", producto.get().getDescripcion());
            finalJson.put("pesoRollo", producto.get().getPesoRollo());
            finalJson.put("activo", producto.get().getActivo());
            finalJson.put("insumosProducto", insumosProducto);
        }

        return ResponseEntity.ok(finalJson);
    }

    @PostMapping
    public Producto saveOrUpdateProducto(@RequestBody Producto producto) {
        return productoService.saveOrUpdateProducto(producto);
    }

    @DeleteMapping("{productoId}")
    public void deleteProducto(@PathVariable("productoId") Long id) {
        productoService.deleteProducto(id);
    }
}
