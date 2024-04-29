package com.tesisproject.service;

import com.tesisproject.entity.LineaOrdenCompra;
import com.tesisproject.entity.OrdenCompra;
import com.tesisproject.entity.Proveedor;
import com.tesisproject.repository.LineaOrdenCompraRepository;
import com.tesisproject.repository.OrdenCompraRepository;
import com.tesisproject.repository.ProveedorRepository;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrdenCompraService {
    @Autowired
    private OrdenCompraRepository ordenCompraRepository;
    private final ProveedorRepository proveedorRepository;
    private final LineaOrdenCompraRepository lineaOrdenCompraRepository;

    public OrdenCompraService(ProveedorRepository proveedorRepository, LineaOrdenCompraRepository lineaOrdenCompraRepository) {
        this.proveedorRepository = proveedorRepository;
        this.lineaOrdenCompraRepository = lineaOrdenCompraRepository;
    }

    public List<JSONObject> getAllOrdenCompra() {
        List<OrdenCompra> ordenesCompra = ordenCompraRepository.findAllByOrderByIdDesc();
        return getJsonAllOrdenCompra(ordenesCompra);
    }

    public OrdenCompra saveOrUpdateOrdenCompra(OrdenCompra ordenCompra) {
        return ordenCompraRepository.save(ordenCompra);
    }

    public List<JSONObject> getAllOrdenCompraByFechaCreacionEntre(LocalDate desde, LocalDate hasta) {
        List<OrdenCompra> ordenesCompra = ordenCompraRepository.findAllByFechaCreacionBetweenOrderByIdDesc(desde, hasta);
        return getJsonAllOrdenCompra(ordenesCompra);
    }

    private List<JSONObject> getJsonAllOrdenCompra(List<OrdenCompra> ordenCompra) {
        List<JSONObject> jsonOrdenCompra = new ArrayList<>();
        for (OrdenCompra orden : ordenCompra) {
            JSONObject ordenJson = new JSONObject();
            ordenJson.put("id", orden.getId());
            ordenJson.put("fecha", orden.getFechaCreacion());

            Optional<Proveedor> proveedor =  proveedorRepository.findById(orden.getFidProveedor());
            proveedor.ifPresent(value -> ordenJson.put("nombreProveedor", value.getNombreProveedor()));

            List<LineaOrdenCompra> lineaOrdenCompras = lineaOrdenCompraRepository.findAllLineaOrdenCompraByFidOrdenCompra(orden.getId());

            float total = 0;
            for (LineaOrdenCompra lineaOrdenCompra : lineaOrdenCompras) {
                total+=lineaOrdenCompra.getCantidad()*lineaOrdenCompra.getPrecio();
            }
            ordenJson.put("costoTotal", total);
            jsonOrdenCompra.add(ordenJson);
        }
        return jsonOrdenCompra;
    }

    public Optional<OrdenCompra> getOrdenCompraById(Long id) {
        return ordenCompraRepository.findById(id);
    }
}
