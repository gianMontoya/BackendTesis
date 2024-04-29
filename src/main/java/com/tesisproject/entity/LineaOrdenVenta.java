package com.tesisproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "linea_orden_venta")
public class LineaOrdenVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_linea_orden_venta", nullable = false)
    private Long id;

    @JoinColumn(name = "fid_orden_venta", nullable = false)
    private Long fidOrdenVenta;

    @JoinColumn(name = "fid_producto", nullable = false)
    private Long fidProducto;

    @Column(name = "fecha_entrega", nullable = false)
    private LocalDate fechaEntrega;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "precio", nullable = false)
    private Float precio;

}