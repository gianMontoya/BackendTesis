package com.tesisproject.service;

import com.tesisproject.entity.Tiempo;
import com.tesisproject.repository.TiempoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TiempoService {
    @Autowired
    private TiempoRepository tiempoRepository;

    public Optional<Tiempo> getTiempoByAnhoAndMes(Integer anho, Integer mes) {
        return tiempoRepository.findByAnhoAndMes(anho, mes);
    }
}
