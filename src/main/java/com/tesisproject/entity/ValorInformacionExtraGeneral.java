package com.tesisproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "valor_informacion_extra_general")
public class ValorInformacionExtraGeneral {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_valor_informacion_extra_general", nullable = false)
    private Long id;

    @Column(name = "fid_informacion_extra", nullable = false)
    private Long fidInformacionExtra;

    @Column(name = "fid_tiempo", nullable = false)
    private Long fidTiempo;

    @Column(name = "valor", nullable = false)
    private Float valor;

}