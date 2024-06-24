package com.tesisproject.controller;

import com.tesisproject.entity.InformacionExtra;
import com.tesisproject.entity.InformacionExtraEjecucion;
import com.tesisproject.service.InformacionExtraEjecucionService;
import com.tesisproject.service.InformacionExtraService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/info-extra-ejecucion")
@CrossOrigin
public class InformacionExtraEjecucionController {
    @Autowired
    private InformacionExtraEjecucionService informacionExtraEjecucionService;
    private final InformacionExtraService informacionExtraService;

    public InformacionExtraEjecucionController(InformacionExtraService informacionExtraService) {
        this.informacionExtraService = informacionExtraService;
    }

    @GetMapping("{idEjecucion}")
    public List<JSONObject> getAllByEjecucionModelo(@PathVariable("idEjecucion") Long id){
        List<JSONObject> listJson = new ArrayList<>();
        List<InformacionExtraEjecucion> listInformacion =  informacionExtraEjecucionService.getAllByEjecucionModelo(id);
        for(InformacionExtraEjecucion inf: listInformacion){
            JSONObject json = new JSONObject();
            Optional<InformacionExtra> informacionExtra =  informacionExtraService.getInformacionExtra(inf.getFidInformacionExtra());
            informacionExtra.ifPresent(extra -> json.put("cabeceraInformacion", extra.getCabeceraInformacionExtra()));
            listJson.add(json);
        }
        return listJson;
    }
}
