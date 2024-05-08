package com.tesisproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", nullable = false)
    private Long id;

    @Column(name = "nombres", nullable = false, length = 80)
    private String nombres;

    @Column(name = "apellido_materno", nullable = false, length = 40)
    private String apellidoMaterno;

    @Column(name = "apellido_paterno", nullable = false, length = 40)
    private String apellidoPaterno;

    @Column(name = "correo", nullable = false, length = 100)
    private String correo;

    @Column(name = "numero_celular", length = 11)
    private String numeroCelular;

    @Column(name = "contrasena", nullable = false)
    private String contrasena;

    @Column(name = "activo")
    private Boolean activo = true;

}