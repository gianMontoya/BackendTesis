package com.tesisproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "ejecucion_modelo")
public class EjecucionModelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ejecucion_modelo", nullable = false)
    private Long id;

    @Column(name = "fecha_ejecucion", nullable = false)
    private LocalDateTime fechaEjecucion;

    @Column(name = "rmse", nullable = false)
    private Float rmse;

    @Column(name = "error_promedio", nullable = false)
    private Float errorPromedio;

    @Column(name = "ajuste_modelo", nullable = false)
    private Float ajusteModelo;

}