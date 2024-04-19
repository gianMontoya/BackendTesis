package com.tesisproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "valores_informacion_extra")
public class ValoresInformacionExtra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_valores_informacion_extra", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fid_informacion_extra", nullable = false)
    private InformacionExtra fidInformacionExtra;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fid_producto", nullable = false)
    private Producto fidProducto;

    @Column(name = "mes", nullable = false)
    private Integer mes;

    @Column(name = "anho", nullable = false)
    private Integer anho;

    @Column(name = "valor", nullable = false)
    private Float valor;

}