package com.ejemplos.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateProgramadorDTO {
	
	private String nombre;
	private String telefono;
	private String direccion;
	private String ciudad;
	private Integer cp;
	
}
