package com.tesisproject.controller;

import com.tesisproject.entity.Cliente;
import com.tesisproject.entity.LineaOrdenVenta;
import com.tesisproject.entity.OrdenVenta;
import com.tesisproject.entity.Producto;
import com.tesisproject.service.ClienteService;
import com.tesisproject.service.LineaOrdenVentaService;
import com.tesisproject.service.OrdenVentaService;
import com.tesisproject.service.ProductoService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/ventas")
@CrossOrigin
public class OrdenVentaController {

    @Autowired
    private OrdenVentaService ordenVentaService;
    private final ClienteService clienteService;
    @Autowired
    private LineaOrdenVentaService lineaOrdenVentaService;
    @Autowired
    private ProductoService productoService;

    public OrdenVentaController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<JSONObject> getOrdenVentas() {
        return ordenVentaService.getAllOrdenVenta();
    }

    @GetMapping("/estimacion")
    public List<JSONObject> getOrdenVentasEstimacion() {
        List<Producto> productos = productoService.getProductos();
        List<JSONObject> finalJsonList = new ArrayList<>();
        for (Producto producto : productos) {
            List<JSONObject> ordenes =  ordenVentaService.getAllOrdenVenta();
            Integer cantidadTotalMes=0;
            int mesActualOrden;
            int anhoActualOrden ;
            int mesAnteriorOrden  = 0;
            int anhoAnteriorOrden = 0;

            for(JSONObject orden : ordenes) {
                mesActualOrden = Integer.parseInt(orden.get("fecha").toString().split("-")[1]);
                anhoActualOrden = Integer.parseInt(orden.get("fecha").toString().split("-")[0]);
                if (mesActualOrden<mesAnteriorOrden && anhoActualOrden==anhoAnteriorOrden || anhoActualOrden<anhoAnteriorOrden) {
                    JSONObject json = new JSONObject();
                    json.put("idProducto",producto.getId());
                    json.put("MesVenta",mesAnteriorOrden);
                    json.put("AnhoVenta",anhoAnteriorOrden);
                    json.put("Cantidad",cantidadTotalMes);
                    finalJsonList.add(json);
                    cantidadTotalMes=0;
                }
                List<LineaOrdenVenta> lineas= lineaOrdenVentaService.findAllByIdOrdenVentaAndIdProducto((Long) orden.get("id"), producto.getId());
                for(LineaOrdenVenta linea : lineas) {
                    cantidadTotalMes += linea.getCantidad();
                }
                mesAnteriorOrden  = Integer.parseInt(orden.get("fecha").toString().split("-")[1]);
                anhoAnteriorOrden = Integer.parseInt(orden.get("fecha").toString().split("-")[0]);
            }

        }
        return finalJsonList;
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

    @GetMapping("/mensual/{idProducto}")
    public List<JSONObject> getVentasMensualesPorProducto(@PathVariable Long idProducto){
        List<JSONObject> finalJsonList = new ArrayList<>();
        List<Map<String, Object>> list =  ordenVentaService.obtenerVentasMensualesPorProducto(idProducto);
        for (Map<String, Object> value : list){
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("anho", value.get("anho"));
            jsonObject.put("mes", value.get("mes"));
            jsonObject.put("cantidad_total_vendida", value.get("cantidad_total_vendida"));
            finalJsonList.add(jsonObject);
        }
        return finalJsonList;
    }
}
