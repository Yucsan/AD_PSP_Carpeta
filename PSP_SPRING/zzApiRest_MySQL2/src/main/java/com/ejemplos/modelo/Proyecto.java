package com.ejemplos.modelo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "proyecto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Proyecto {

    @Id
    @Column(name = "codproye", length = 5)
    private Integer codproye; // Clave primaria INT(5)

    @Column(name = "nombre", nullable = false, length = 32, unique = true)
    private String nombre;

    @Column(name = "tecnologia", length = 30)
    private String tecnologia;

    @Column(name = "pais", length = 20)
    private String pais;
}
