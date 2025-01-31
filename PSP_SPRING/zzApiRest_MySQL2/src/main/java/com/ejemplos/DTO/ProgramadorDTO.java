package com.ejemplos.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProgramadorDTO {
    private String codpro;
    private String nombre;
    private String telefono;
    private String direccion;
    private String ciudad;
    private Integer cp;
}
