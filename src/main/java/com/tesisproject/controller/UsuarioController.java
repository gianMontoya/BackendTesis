package com.tesisproject.controller;

import com.tesisproject.entity.Usuario;
import com.tesisproject.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> getUsuarios() {
        return usuarioService.getUsuarios();
    }

    @GetMapping("{usuarioId}")
    public Optional<Usuario> getUsuario(@PathVariable("usuarioId") Long id) {
        return usuarioService.getUsuario(id);
    }

    @PostMapping
    public void saveOrUpdateUsuario(@RequestBody Usuario usuario) {
        usuarioService.saveOrUpdateUsuario(usuario);
    }

    @DeleteMapping("{usuarioId}")
    public void deleteUsuario(@PathVariable("usuarioId") Long id) {
        usuarioService.deleteUsuario(id);
    }
}
