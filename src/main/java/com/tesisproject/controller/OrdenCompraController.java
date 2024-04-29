package com.tesisproject.controller;

import com.tesisproject.entity.OrdenCompra;
import com.tesisproject.entity.Proveedor;
import com.tesisproject.service.OrdenCompraService;
import com.tesisproject.service.ProveedorService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/compras")
@CrossOrigin
public class OrdenCompraController {
    @Autowired
    private OrdenCompraService ordenCompraService;
    private final ProveedorService proveedorService;

    public OrdenCompraController(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    @GetMapping
    public List<JSONObject> getOrdenCompras() {
        return ordenCompraService.getAllOrdenCompra();
    }

    @GetMapping("/{desde}/{hasta}")
    public List<JSONObject> getOrdenComprasFechaCreacionEntre(@PathVariable LocalDate desde,@PathVariable  LocalDate hasta) {
        return ordenCompraService.getAllOrdenCompraByFechaCreacionEntre(desde,hasta);
    }

    @GetMapping("/{idCompra}")
    public JSONObject getOrdenCompra(@PathVariable Long idCompra) {
        Optional<OrdenCompra> orden = ordenCompraService.getOrdenCompraById(idCompra);
        assert orden.orElse(null) != null;
        Optional<Proveedor> proveedor = proveedorService.getProveedor(orden.get().getFidProveedor());
        assert proveedor.orElse(null) != null;
        JSONObject jsonCompra = new JSONObject();
        jsonCompra.put("id", orden.get().getId());
        jsonCompra.put("nombreProveedor", proveedor.get().getNombreProveedor());
        jsonCompra.put("fidUsuario", orden.get().getFidUsuario());
        jsonCompra.put("fechaCreacion", orden.get().getFechaCreacion());
        jsonCompra.put("fechaEntrega", orden.get().getFechaEntrega());
        return jsonCompra;
    }


    @PostMapping
    public OrdenCompra saveOrUpdateOrdenCompra(@RequestBody OrdenCompra ordenCompra) {
        return ordenCompraService.saveOrUpdateOrdenCompra(ordenCompra);
    }
}
