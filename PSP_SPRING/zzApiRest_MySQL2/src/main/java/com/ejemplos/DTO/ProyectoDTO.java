package com.ejemplos.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProyectoDTO {
    private Integer codproye;
    private String nombre;
    private String tecnologia;
    private String pais;
}
