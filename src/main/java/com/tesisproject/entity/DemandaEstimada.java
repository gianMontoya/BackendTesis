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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fid_producto", nullable = false)
    private Producto fidProducto;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fid_ejecucion_modelo", nullable = false)
    private EjecucionModelo fidEjecucionModelo;

    @Column(name = "mes", nullable = false)
    private Integer mes;

    @Column(name = "anho", nullable = false)
    private Integer anho;

    @Column(name = "valor", nullable = false)
    private Float valor;

}