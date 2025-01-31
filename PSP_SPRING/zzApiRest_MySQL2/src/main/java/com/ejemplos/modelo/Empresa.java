package com.ejemplos.modelo;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "empresa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Empresa {

    @Id
    @Column(name = "codempre", length = 6)
    private String codempre; // Clave primaria VARCHAR(6)

    @Column(name = "titulo", nullable = false, length = 80)
    private String titulo;

    @Column(name = "cif", length = 12)
    private String cif;

    @ManyToOne
    @JoinColumn(name = "codproye_FK", referencedColumnName = "codproye")
    private Proyecto proyecto; // Relación con Proyecto

    @ManyToOne
    @JoinColumn(name = "codpro_FK", referencedColumnName = "codpro")
    private Programador programador; // Relación con Programador
}
