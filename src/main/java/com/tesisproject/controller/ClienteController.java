package com.tesisproject.controller;

import com.tesisproject.entity.Cliente;
import com.tesisproject.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> getClientes() {
        return clienteService.getClientes();
    }

    @GetMapping("{clienteId}")
    public Optional<Cliente> getCliente(@PathVariable("clienteId") Long id) {
        return clienteService.getCliente(id);
    }

    @PostMapping
    public void saveOrUpdateCliente(@RequestBody Cliente cliente) {
        clienteService.saveOrUpdate(cliente);
    }

    @DeleteMapping("{clienteId}")
    public void deleteCliente(@PathVariable("clienteId") Long id) {
        clienteService.deleteCliente(id);
    }
}

