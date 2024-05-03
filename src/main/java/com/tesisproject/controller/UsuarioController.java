package com.tesisproject.controller;

import com.tesisproject.entity.Permisosxrol;
import com.tesisproject.entity.Rol;
import com.tesisproject.entity.Usuario;
import com.tesisproject.service.PermisosRolService;
import com.tesisproject.service.RolService;
import com.tesisproject.service.UsuarioService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/usuarios")
@CrossOrigin
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    private final PermisosRolService permisosRolService;
    private final RolService rolService;

    public UsuarioController(PermisosRolService permisosRolService, RolService rolService) {
        this.permisosRolService = permisosRolService;
        this.rolService = rolService;
    }


    @GetMapping
    public List<JSONObject> getUsuarios() {
        List<JSONObject> listUsuariosJson = new ArrayList<>();
        List<Usuario> listUsuarios = usuarioService.getUsuarios();

        for (Usuario usuario : listUsuarios) {
            JSONObject usuarioJson = new JSONObject();
            usuarioJson.put("id", usuario.getId());
            usuarioJson.put("nombres", usuario.getNombres());
            usuarioJson.put("apellidoPaterno", usuario.getApellidoPaterno());
            usuarioJson.put("apellidoMaterno", usuario.getApellidoMaterno());
            usuarioJson.put("correo", usuario.getCorreo());
            usuarioJson.put("activo", usuario.getActivo());
            usuarioJson.put("numeroCelular", usuario.getNumeroCelular());
            Optional<Permisosxrol> permisoxrol =  permisosRolService.getPermisosxrolByFidUsuario(usuario.getId());
            Optional<Rol> rol =  rolService.getRol(permisoxrol.orElse(new Permisosxrol()).getFidRol());
            usuarioJson.put("rol", rol.orElse(new Rol()).getNombreRol());
            listUsuariosJson.add(usuarioJson);
        }
        return listUsuariosJson;
    }

    @GetMapping("{usuarioId}")
    public JSONObject getUsuario(@PathVariable("usuarioId") Long id) {
        Optional<Usuario> usuario = usuarioService.getUsuario(id);
        JSONObject usuarioJson = new JSONObject();
        if (usuario.isPresent()) {
            usuarioJson.put("id", usuario.get().getId());
            usuarioJson.put("nombres", usuario.get().getNombres());
            usuarioJson.put("apellidoPaterno", usuario.get().getApellidoPaterno());
            usuarioJson.put("apellidoMaterno", usuario.get().getApellidoMaterno());
            usuarioJson.put("correo", usuario.get().getCorreo());
            usuarioJson.put("activo", usuario.get().getActivo());
            usuarioJson.put("numeroCelular", usuario.get().getNumeroCelular());
            Optional<Permisosxrol> permisoxrol =  permisosRolService.getPermisosxrolByFidUsuario(usuario.get().getId());
            usuarioJson.put("idRol", permisoxrol.orElse(new Permisosxrol()).getFidRol());
        }
        return usuarioJson;
    }

    @PostMapping
    public void saveOrUpdateUsuario(@RequestBody JSONObject usuarioJson) {
        Usuario usuario = new Usuario();
        if (usuarioJson.get("id")!=null) usuario.setId(Long.valueOf((String) usuarioJson.get("id")));
        usuario.setActivo((Boolean) usuarioJson.get("activo"));
        usuario.setNombres((String) usuarioJson.get("nombres"));
        usuario.setApellidoPaterno((String) usuarioJson.get("apellidoPaterno"));
        usuario.setApellidoMaterno((String) usuarioJson.get("apellidoMaterno"));
        usuario.setCorreo((String) usuarioJson.get("correo"));
        usuario.setNumeroCelular((String) usuarioJson.get("numeroCelular"));
        usuario.setContrasena((String) usuarioJson.get("contrasena"));

        usuario = usuarioService.saveOrUpdateUsuario(usuario);
        if (usuarioJson.get("id")!=null){
            Optional<Permisosxrol> permiso =  permisosRolService.getPermisosxrolByFidUsuario(Long.valueOf((String)usuarioJson.get("id")));
            if(permiso.isPresent()){
                long idRol;
                if (usuarioJson.get("idRol").getClass() == String.class) idRol = Integer.parseInt((String) usuarioJson.get("idRol"));
                else idRol = Integer.parseInt(String.valueOf(usuarioJson.get("idRol")));

                permiso.get().setFidRol(idRol);
                permisosRolService.createOrUpdatePermisosxrol(permiso.get());
            }
        }else{
            Permisosxrol permiso = new Permisosxrol();
            permiso.setFidRol((Long) usuarioJson.get("idRol"));
            permiso.setFidUsuario(usuario.getId());
            permiso.setPermiso("");
            permisosRolService.createOrUpdatePermisosxrol(permiso);
        }
    }

    @DeleteMapping("{usuarioId}")
    public void deleteUsuario(@PathVariable("usuarioId") Long id) {
        usuarioService.deleteUsuario(id);
    }
}
