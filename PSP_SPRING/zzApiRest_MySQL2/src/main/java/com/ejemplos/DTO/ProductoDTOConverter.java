package com.ejemplos.DTO;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ejemplos.modelo.Programador;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProductoDTOConverter {

	@Autowired
	private ModelMapper modelMapper;
	
	public ProductoDTO convertirADto(Programador producto) {
		return modelMapper.map(producto,  ProductoDTO.class);
	}
	
	public Programador convertirAProd(CreateProductoDTO createProductoDto) {
		return modelMapper.map(createProductoDto, Programador.class);
	}
	
	
}
