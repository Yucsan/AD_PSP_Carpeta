package com.ejemplos.DTO;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ejemplos.modelo.Categoria;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CategoriaDTOConverter {

	@Autowired
	private ModelMapper modelMapper;
	
	public CategoriaDTO convertirADto(Categoria categoria) {
		return modelMapper.map(categoria,  CategoriaDTO.class);
	}
	
	public Categoria convertirAProd(CreateCategoriaDTO createProductoDto) {
		return modelMapper.map(createProductoDto, Categoria.class);
	}
	
	
}
