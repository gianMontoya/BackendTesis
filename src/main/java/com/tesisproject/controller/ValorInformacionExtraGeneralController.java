package com.tesisproject.controller;

import com.tesisproject.entity.Tiempo;
import com.tesisproject.entity.ValorInformacionExtraGeneral;
import com.tesisproject.service.TiempoService;
import com.tesisproject.service.ValorInformacionExtraGeneralService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/valores-extra-general")
@CrossOrigin
public class ValorInformacionExtraGeneralController {
    @Autowired
    private ValorInformacionExtraGeneralService valorInformacionExtraGeneralService;
    private final TiempoService tiempoService;

    public ValorInformacionExtraGeneralController(TiempoService tiempoService) {
        this.tiempoService = tiempoService;
    }

    @GetMapping
    public List<ValorInformacionExtraGeneral> getValoresInformacionExtraGeneral() {
        return valorInformacionExtraGeneralService.getValoresInformacionExtraGeneral();
    }

    @GetMapping("{informacionId}")
    public List<JSONObject> getValoresInformacionExtraGeneralByIdInformacion(@PathVariable("informacionId") Long idInformacion) {
        return valorInformacionExtraGeneralService.findValorInformacionExtraGeneralByIdInformacion(idInformacion);
    }

    @PostMapping
    public void saveOrUpdateValoresInformacionExtraGeneral(@RequestBody JSONObject valorInformacionExtraGeneral) {

        Optional<Tiempo> tiempo = tiempoService.getTiempoByAnhoAndMes( (Integer) valorInformacionExtraGeneral.get("year"), (Integer) valorInformacionExtraGeneral.get("month"));
        ValorInformacionExtraGeneral valor = new ValorInformacionExtraGeneral();

        Integer idInformacionInt = (Integer) valorInformacionExtraGeneral.get("idInformacion");
        Long idInformacion = Long.valueOf(idInformacionInt);
        float valorDato;
        if (valorInformacionExtraGeneral.get("valor") instanceof Integer){
            valorDato = Float.valueOf((Integer) valorInformacionExtraGeneral.get("valor"));
        }else{
            double valorDatoDouble = (double) valorInformacionExtraGeneral.get("valor");
            valorDato = (float) valorDatoDouble;
        }

        valor.setFidInformacionExtra(idInformacion);
        valor.setValor(valorDato);
        tiempo.ifPresent(value -> valor.setFidTiempo(value.getId()));

        valorInformacionExtraGeneralService.saveOrUpdateValorInformacionExtraGeneral(valor);
    }

    @PostMapping("delete/{idInformacion}")
    public void deleteAllValoresInformacionExtra(@PathVariable("idInformacion") Long idInformacion){
        List<JSONObject> listJson =  valorInformacionExtraGeneralService.findValorInformacionExtraGeneralByIdInformacion(idInformacion);
        for (JSONObject valor : listJson){
            valorInformacionExtraGeneralService.deleteValorInformacionExtraGeneral((Long) valor.get("id"));
        }
    }
}
