package com.tesisproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "proveedor")
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor", nullable = false)
    private Long id;

    @Column(name = "nombre_proveedor", nullable = false, length = 200)
    private String nombreProveedor;

    @Column(name = "correo_contacto", nullable = false, length = 100)
    private String correoContacto;

    @Column(name = "numero_contacto", length = 11)
    private String numeroContacto;

    @Column(name = "RUC", nullable = false, length = 15)
    private String ruc;

    @ColumnDefault("1")
    @Column(name = "activo", nullable = false)
    private Boolean activo = false;

}