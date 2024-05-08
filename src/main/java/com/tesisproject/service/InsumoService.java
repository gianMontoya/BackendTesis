package com.tesisproject.service;

import com.tesisproject.entity.Insumo;
import com.tesisproject.repository.InsumoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InsumoService {
    @Autowired
    private InsumoRepository insumoRepository;

    public List<Insumo> getInsumos(){
        return insumoRepository.findAll();
    }

    public List<Insumo> getInsumosByNombre(String nombre){
        return insumoRepository.findAllByNombreInsumoContains(nombre);
    }

    public List<Insumo> getInsumosActivos(){
        return insumoRepository.findAllByActivoIsTrue();
    }

    public Optional<Insumo> getInsumo(Long id){
        return insumoRepository.findById(id);
    }

    public void saveOrUpdateInsumo(Insumo insumo){
        insumoRepository.save(insumo);
    }

    public void deleteInsumo(Long id){
        /*Luego agregar la validación para que verifique en las Ordenes de compra*/
        insumoRepository.deleteById(id);
    }
}
