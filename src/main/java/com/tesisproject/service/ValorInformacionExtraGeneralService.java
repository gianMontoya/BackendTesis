package com.tesisproject.service;

import com.tesisproject.entity.Tiempo;
import com.tesisproject.entity.ValorInformacionExtraGeneral;
import com.tesisproject.repository.TiempoRepository;
import com.tesisproject.repository.ValorInformacionExtraGeneralRepository;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ValorInformacionExtraGeneralService {
    @Autowired
    private ValorInformacionExtraGeneralRepository valorInformacionExtraGeneralRepository;
    private final TiempoRepository tiempoRepository;

    public ValorInformacionExtraGeneralService(TiempoRepository tiempoRepository) {
        this.tiempoRepository = tiempoRepository;
    }

    public List<ValorInformacionExtraGeneral> getValoresInformacionExtraGeneral() {
        return valorInformacionExtraGeneralRepository.findAll();
    }

    public List<JSONObject> findValorInformacionExtraGeneralByIdInformacion(Long id) {
        List<JSONObject> listFinal  = new ArrayList<>();
        List<ValorInformacionExtraGeneral> listValores = valorInformacionExtraGeneralRepository.findValorInformacionExtraGeneralByFidInformacionExtraOrderByFidTiempoAsc(id);
        for (ValorInformacionExtraGeneral valor : listValores){
            JSONObject json = new JSONObject();
            Optional<Tiempo> tiempo = tiempoRepository.findById(valor.getFidTiempo());
            if (tiempo.isPresent()){
                json.put("month", tiempo.get().getMes());
                json.put("year", tiempo.get().getAnho());
            }
            json.put("valor", valor.getValor());
            json.put("id", valor.getId());
            listFinal.add(json);
        }
        return listFinal;
    }

    public void saveOrUpdateValorInformacionExtraGeneral(ValorInformacionExtraGeneral valorInformacionExtraGeneral) {
        valorInformacionExtraGeneralRepository.save(valorInformacionExtraGeneral);
    }

    public void deleteValorInformacionExtraGeneral(Long id){
        valorInformacionExtraGeneralRepository.deleteById(id);
    }
}
