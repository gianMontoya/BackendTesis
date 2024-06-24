package com.tesisproject.service;

import com.tesisproject.entity.ValorInformacionExtraProducto;
import com.tesisproject.repository.ValorInformacionExtraProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ValorInformacionExtraProductoService {
    @Autowired
    private ValorInformacionExtraProductoRepository valorInformacionExtraProductoRepository;

    public List<ValorInformacionExtraProducto> getValoresInformacionExtraProducto() {
        return valorInformacionExtraProductoRepository.findAll();
    }

    public List<ValorInformacionExtraProducto> findValorInformacionExtraProductoByIdInformacion(Long id) {
        return valorInformacionExtraProductoRepository.findValorInformacionExtraProductoByFidInformacionExtraOrderByFidTiempoAsc(id);
    }

    public void saveOrUpdateValorInformacionExtraProducto(ValorInformacionExtraProducto valorInformacionExtraProducto) {
        valorInformacionExtraProductoRepository.save(valorInformacionExtraProducto);
    }
}
