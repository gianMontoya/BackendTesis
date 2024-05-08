package com.tesisproject.service;

import com.tesisproject.entity.Usuario;
import com.tesisproject.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService() {
        passwordEncoder = new BCryptPasswordEncoder();
    }

    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }

    public List<Usuario> getUsuariosByNombreOrApellidos(String nombre) {
        return usuarioRepository.findByNombresContainsOrApellidoPaternoContainsOrApellidoMaternoContains(nombre, nombre, nombre);
    }

    public Optional<Usuario> getUsuario(Long id) {
        return usuarioRepository.findById(id);
    }

    public Optional<Usuario> getUsuarioByCorreo(String correo) {
        return usuarioRepository.findByCorreoAndActivoIsTrue(correo);
    }

    public Usuario saveOrUpdateUsuario(Usuario usuario) {
        if (usuario.getContrasena() != null) {
            String encodedPassword = this.passwordEncoder.encode(usuario.getContrasena());
            usuario.setContrasena(encodedPassword);
        }else{
            Optional<Usuario> oldUsuario = usuarioRepository.findById(usuario.getId());
            oldUsuario.ifPresent(value -> usuario.setContrasena(value.getContrasena()));
        }
        return usuarioRepository.save(usuario);
    }

    public void changePassword(Usuario usuario) {
        String encodedPassword = this.passwordEncoder.encode(usuario.getContrasena());
        usuario.setContrasena(encodedPassword);
        usuarioRepository.save(usuario);
    }

    public void deleteUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
