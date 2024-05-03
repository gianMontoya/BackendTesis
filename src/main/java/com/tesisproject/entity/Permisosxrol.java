package com.tesisproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "permisosxrol")
public class Permisosxrol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_permiso_rol", nullable = false)
    private Long id;

    @JoinColumn(name = "fid_usuario", nullable = false)
    private Long fidUsuario;

    @JoinColumn(name = "fid_rol", nullable = false)
    private Long fidRol;

    @Column(name = "permiso", nullable = false, length = 200)
    private String permiso;

}