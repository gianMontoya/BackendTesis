package com.tesisproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "informacion_extra_ejecucion")
public class InformacionExtraEjecucion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_informacion_extra_ejecucion", nullable = false)
    private Long id;

    @Column(name = "fid_ejecucion_modelo", nullable = false)
    private Long fidEjecucionModelo;

    @Column(name = "fid_informacion_extra", nullable = false)
    private Long fidInformacionExtra;

}