package com.ejemplos.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmpresaDTO {
    private String codempre;
    private String titulo;
    private String cif;
    private Integer codproyeFK;
    private String codproFK;
}
