package com.tesisproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "demanda_estimada")
public class DemandaEstimada {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_demanda_estimada", nullable = false)
    private Long id;

    @Column(name = "fid_producto", nullable = false)
    private Long fidProducto;

    @Column(name = "fid_ejecucion_modelo", nullable = false)
    private Long fidEjecucionModelo;

    @Column(name = "mes", nullable = false)
    private Integer mes;

    @Column(name = "anho", nullable = false)
    private Integer anho;

    @Column(name = "valor", nullable = false)
    private Float valor;

}