package com.tesisproject.service;

import com.tesisproject.entity.InformacionExtra;
import com.tesisproject.repository.InformacionExtraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InformacionExtraService {
    @Autowired
    private InformacionExtraRepository informacionExtraRepository;

    public List<InformacionExtra> getInformacionesExtra() {
        return informacionExtraRepository.findAll();
    }

//    public List<InformacionExtra> getClientesByName(String name) {
//        return informacionExtraRepository.findByNombreClienteContains(name);
//    }

    public Optional<InformacionExtra> getInformacionExtra(Long id) {
        return informacionExtraRepository.findById(id);
    }

    public InformacionExtra saveOrUpdate(InformacionExtra informacion) {
        return informacionExtraRepository.save(informacion);
    }

//    public void deleteCliente(Long id) {
//        clienteRepository.deleteById(id);
//    }
}
