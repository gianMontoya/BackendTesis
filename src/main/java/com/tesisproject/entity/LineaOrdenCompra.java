package com.tesisproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "linea_orden_compra")
public class LineaOrdenCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_linea_orden_compra", nullable = false)
    private Long id;

    @JoinColumn(name = "fid_orden_compra", nullable = false)
    private Long fidOrdenCompra;

    @JoinColumn(name = "fid_insumo", nullable = false)
    private Long fidInsumo;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "precio", nullable = false)
    private Float precio;

}