package com.tesisproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tiempo")
public class Tiempo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tiempo", nullable = false)
    private Long id;

    @Column(name = "mes", nullable = false)
    private Integer mes;

    @Column(name = "anho", nullable = false)
    private Integer anho;

}