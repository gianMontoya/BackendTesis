package com.tesisproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
@Table(name = "informacion_extra")
public class InformacionExtra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_informacion_extra", nullable = false)
    private Long id;

    @Column(name = "cabecera_informacion_extra", nullable = false, length = 200)
    private String cabeceraInformacionExtra;

    @ColumnDefault("1")
    @Column(name = "exclusiva_producto", nullable = false)
    private Boolean exclusivaProducto = false;

    @ColumnDefault("1")
    @Column(name = "activo", nullable = false)
    private Boolean activo = false;

}