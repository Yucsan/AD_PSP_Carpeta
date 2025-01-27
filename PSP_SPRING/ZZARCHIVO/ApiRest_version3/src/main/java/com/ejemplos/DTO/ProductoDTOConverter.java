package com.ejemplos.DTO;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ejemplos.modelo.Categoria;
import com.ejemplos.modelo.Producto;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor

public class ProductoDTOConverter {

    @Autowired
    private ModelMapper modelMapper;
    
    public ProductoDTO convertirADto(Producto producto) {
		return modelMapper.map(producto,  ProductoDTO.class);
	}
    
    public Producto convertirAProd(CreateProductoDTO createProductoDto) {
        Producto producto = modelMapper.map(createProductoDto, Producto.class);
        producto.setId(null); // Asegúrate de que el ID esté vacío

        // Asocia la categoría al producto
        Categoria categoria = new Categoria();
        categoria.setId(createProductoDto.getCategoriaId());
        producto.setCategoria(categoria);

        return producto;
    }

    
    
/*
public class ProductoDTOConverter {

	@Autowired
	private ModelMapper modelMapper;
	
	public ProductoDTO convertirADto(Producto producto) {
		return modelMapper.map(producto,  ProductoDTO.class);
	}
	public Producto convertirAProd(CreateProductoDTO createProductoDto) {
		return modelMapper.map(createProductoDto, Producto.class);
	}
*/	
	
	
	
	
}
