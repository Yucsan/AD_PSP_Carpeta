package com.ejemplos.DTO;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ejemplos.modelo.Programador;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProgramadorDTOConverter {

	@Autowired
	private ModelMapper modelMapper;
	
	public ProgramadorDTO convertirADto(Programador programador) {
		return modelMapper.map(programador,  ProgramadorDTO.class);
	}
	
	public Programador convertirAProg(CreateProgramadorDTO createProgramadorDto) {
		return modelMapper.map(createProgramadorDto, Programador.class);
	}
	
	
}
