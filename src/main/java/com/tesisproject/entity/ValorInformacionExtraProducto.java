package com.tesisproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "valor_informacion_extra_producto")
public class ValorInformacionExtraProducto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_valor_informacion_extra_producto", nullable = false)
    private Long id;

    @Column(name = "fid_informacion_extra", nullable = false)
    private Long fidInformacionExtra;

    @Column(name = "fid_producto", nullable = false)
    private Long fidProducto;

    @Column(name = "fid_tiempo", nullable = false)
    private Long fidTiempo;

    @Column(name = "valor", nullable = false)
    private Float valor;

}