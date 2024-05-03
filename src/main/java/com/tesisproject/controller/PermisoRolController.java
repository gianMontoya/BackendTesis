package com.tesisproject.controller;

import com.tesisproject.entity.Permisosxrol;
import com.tesisproject.service.PermisosRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/permisos")
@CrossOrigin
public class PermisoRolController {
    @Autowired
    private PermisosRolService permisosRolService;

    @PostMapping
    public void createOrUpdatePermisoRol(@RequestBody Permisosxrol permisosxrol){
        permisosRolService.createOrUpdatePermisosxrol(permisosxrol);
    }
//
//    @GetMapping("/{fidUsuario}")
//    public JSONObject getPermisosxrolByFidUsuario(@PathVariable Long fidUsuario){
//        JSONObject jsonObject = new JSONObject();
//
//        Optional<Permisosxrol> permiso = permisosRolService.getPermisosxrolByFidUsuario(fidUsuario);
//        permiso.ifPresent(permisosxrol -> jsonObject.put("idRol", permisosxrol.getFidRol()));
//        Optional<Rol> rol = Optional.empty();
//        if (permiso.isPresent()) rol = rolService.getRol(permiso.get().getFidRol());
//        rol.ifPresent(value -> jsonObject.put("nombreRol", value.getNombreRol()));
//
//        return jsonObject;
//    }
}
