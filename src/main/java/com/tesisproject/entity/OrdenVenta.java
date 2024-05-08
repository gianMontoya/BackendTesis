package com.tesisproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;

@Getter
@Setter
@Entity
@Table(name = "orden_venta")
public class OrdenVenta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_orden_venta", nullable = false)
    private Long id;

    @JoinColumn(name = "fid_cliente", nullable = false)
    private Long fidCliente;

    @JoinColumn(name = "fid_usuario", nullable = false)
    private Long fidUsuario;

    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;

    @Column(name = "fecha_vencimiento", nullable = false)
    private LocalDate fechaVencimiento;

    @Transient
    private ArrayList<LineaOrdenVenta> lineasOrdenVenta;
}