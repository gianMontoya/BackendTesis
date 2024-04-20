package com.tesisproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "insumo")
public class Insumo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_insumo", nullable = false)
    private Long id;

    @Column(name = "nombre_insumo", nullable = false, length = 100)
    private String nombreInsumo;

    @Column(name = "descripcion", nullable = false, length = 400)
    private String descripcion;

    @Column(name = "peso_paquete", nullable = false)
    private Float pesoPaquete;

    @ColumnDefault("1")
    @Column(name = "activo", nullable = false)
    private Boolean activo=false;

}