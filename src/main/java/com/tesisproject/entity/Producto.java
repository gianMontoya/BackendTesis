package com.tesisproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto", nullable = false)
    private Long id;

    @Column(name = "nombre_producto", nullable = false, length = 100)
    private String nombreProducto;

    @Column(name = "descripcion", nullable = false, length = 400)
    private String descripcion;

    @Column(name = "peso_rollo", nullable = false)
    private Float pesoRollo;

    @ColumnDefault("1")
    @Column(name = "activo", nullable = false)
    private Boolean activo = false;

}