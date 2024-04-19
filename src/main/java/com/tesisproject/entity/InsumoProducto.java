package com.tesisproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "insumo_producto")
public class InsumoProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_insumo_producto", nullable = false)
    private Long id;

    @Column(name = "fid_producto", nullable = false)
    private Long fidProducto;

    @Column(name = "fid_insumo", nullable = false)
    private Long fidInsumo;

    @Column(name = "cantidad_1Kilo", nullable = false)
    private Float cantidad1kilo;

}