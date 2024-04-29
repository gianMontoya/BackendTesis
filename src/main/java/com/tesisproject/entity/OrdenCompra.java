package com.tesisproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@Entity
@Table(name = "orden_compra")
public class OrdenCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_orden_compra", nullable = false)
    private Long id;

    @JoinColumn(name = "fid_proveedor", nullable = false)
    private Long fidProveedor;

    @JoinColumn(name = "fid_usuario", nullable = false)
    private Long fidUsuario;

    @Column(name = "fecha_creacion")
    private LocalDate fechaCreacion;

    @Column(name = "fecha_entrega", nullable = false)
    private LocalDate fechaEntrega;
}