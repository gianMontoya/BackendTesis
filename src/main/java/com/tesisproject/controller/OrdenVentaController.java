package com.tesisproject.controller;

import com.tesisproject.entity.Cliente;
import com.tesisproject.entity.OrdenVenta;
import com.tesisproject.service.ClienteService;
import com.tesisproject.service.OrdenVentaService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/ventas")
@CrossOrigin
public class OrdenVentaController {

    @Autowired
    private OrdenVentaService ordenVentaService;
    private final ClienteService clienteService;

    public OrdenVentaController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<JSONObject> getOrdenVentas() {
        return ordenVentaService.getAllOrdenVenta();
    }

    @GetMapping("/{idVenta}")
    public JSONObject getOrdenVenta(@PathVariable Long idVenta) {
        Optional<OrdenVenta> orden = ordenVentaService.getOrdenVentaById(idVenta);
        assert orden.orElse(null) != null;
        Optional<Cliente> cliente = clienteService.getCliente(orden.get().getFidCliente());
        assert cliente.orElse(null) != null;
        JSONObject jsonVenta = new JSONObject();
        jsonVenta.put("id", orden.get().getId());
        jsonVenta.put("nombreCliente", cliente.get().getNombreCliente());
        jsonVenta.put("fidUsuario", orden.get().getFidUsuario());
        jsonVenta.put("fechaCreacion", orden.get().getFechaCreacion());
        jsonVenta.put("fechaVencimiento", orden.get().getFechaVencimiento());
        return jsonVenta;
    }

    @GetMapping("/{desde}/{hasta}")
    public List<JSONObject> getOrdenesVentaFechaCreacionEntre(@PathVariable LocalDate desde, @PathVariable  LocalDate hasta) {
        return ordenVentaService.getAllOrdenVentaByFechaCreacionEntre(desde,hasta);
    }

    @PostMapping
    public OrdenVenta saveOrUpdateOrdenVenta(@RequestBody OrdenVenta ordenVenta) {
        return ordenVentaService.saveOrUpdateOrdenVenta(ordenVenta);
    }
}
