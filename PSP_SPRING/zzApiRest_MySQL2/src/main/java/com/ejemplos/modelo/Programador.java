package com.ejemplos.modelo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "programador")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Programador {

    @Id
    @Column(name = "codpro", length = 10)
    private String id; // Clave primaria VARCHAR(10)

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "telefono", length = 12)
    private String telefono;

    @Column(name = "direccion", length = 50)
    private String direccion;

    @Column(name = "ciudad", length = 50)
    private String ciudad;

    @Column(name = "cp")
    private Integer cp;
}