package com.tesisproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "linea_orden_venta")
public class LineaOrdenVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_linea_orden_venta", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fid_orden_venta", nullable = false)
    private OrdenVenta fidOrdenVenta;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fid_producto", nullable = false)
    private Producto fidProducto;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "fecha_entrega", nullable = false)
    private Instant fechaEntrega;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;

    @Column(name = "precio", nullable = false)
    private Float precio;

}