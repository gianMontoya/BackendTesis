package com.tesisproject.service;

import com.tesisproject.entity.*;
import com.tesisproject.repository.ClienteRepository;
import com.tesisproject.repository.LineaOrdenVentaRepository;
import com.tesisproject.repository.OrdenVentaRepository;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrdenVentaService {

    @Autowired
    private OrdenVentaRepository ordenVentaRepository;
    private final ClienteRepository clienteRepository;
    private final LineaOrdenVentaRepository lineaOrdenVentaRepository;


    public OrdenVentaService(ClienteRepository clienteRepository, LineaOrdenVentaRepository lineaOrdenVentaRepository) {
        this.clienteRepository = clienteRepository;
        this.lineaOrdenVentaRepository = lineaOrdenVentaRepository;
    }

    public List<JSONObject> getAllOrdenVenta() {
        List<OrdenVenta> ordenesVenta = ordenVentaRepository.findAllByOrderByIdDesc();
        return getJsonAllOrdenVenta(ordenesVenta);
    }

    public List<JSONObject> getAllOrdenVentaByFechaCreacionEntre(LocalDate desde, LocalDate hasta) {
        List<OrdenVenta> ordenesVenta = ordenVentaRepository.findAllByFechaCreacionBetweenOrderByIdDesc(desde, hasta);
        return getJsonAllOrdenVenta(ordenesVenta);
    }

    public OrdenVenta saveOrUpdateOrdenVenta(OrdenVenta ordenVenta) {
        return ordenVentaRepository.save(ordenVenta);
    }

    public Optional<OrdenVenta> getOrdenVentaById(Long id) {
        return ordenVentaRepository.findById(id);
    }

    private List<JSONObject> getJsonAllOrdenVenta(List<OrdenVenta> ordenesVenta) {
        List<JSONObject> jsonOrdenVenta = new ArrayList<>();
        for (OrdenVenta orden : ordenesVenta) {
            JSONObject ordenJson = new JSONObject();
            ordenJson.put("id", orden.getId());
            ordenJson.put("fecha", orden.getFechaCreacion());

            Optional<Cliente> cliente =  clienteRepository.findById(orden.getFidCliente());
            cliente.ifPresent(value -> ordenJson.put("nombreCliente", value.getNombreCliente()));

            List<LineaOrdenVenta> lineaOrdenVentas = lineaOrdenVentaRepository.findAllLineaOrdenVentaByFidOrdenVenta(orden.getId());

            float total = 0;
            for (LineaOrdenVenta lineaOrdenVenta : lineaOrdenVentas) {
                total+=lineaOrdenVenta.getCantidad()*lineaOrdenVenta.getPrecio();
            }
            ordenJson.put("ventaTotal", total);
            jsonOrdenVenta.add(ordenJson);
        }
        return jsonOrdenVenta;
    }
}
