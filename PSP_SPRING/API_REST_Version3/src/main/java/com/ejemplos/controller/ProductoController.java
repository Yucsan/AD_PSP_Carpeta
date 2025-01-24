package com.ejemplos.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ejemplos.DTO.CreateProductoDTO;
import com.ejemplos.DTO.ProductoDTO;
import com.ejemplos.DTO.ProductoDTOConverter;
import com.ejemplos.modelo.Categoria;
import com.ejemplos.modelo.CategoriaRepositorio;
import com.ejemplos.modelo.Producto;
import com.ejemplos.modelo.ProductoRepositorio;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor

public class ProductoController {
	
	
	@Autowired
	private final ProductoRepositorio productoRepositorio; // se declara como final pq no se va a modificar este
															// repositorio
	// se inyecta solo al crear el bean controlador
	// Dentro de la carpeta resources está data.sql
	@Autowired
	private ProductoDTOConverter productoDTOConverter;
	
	@Autowired
	private CategoriaRepositorio categoriaRepositorio;

	/**
	 * Obtenemos todos los productos
	 * 
	 * @return
	 */

	@GetMapping("/producto")
	public ResponseEntity<?> obtenerTodos() {
		List<Producto> result = productoRepositorio.findAll();
		
		if(result.isEmpty()) {
			return ResponseEntity.notFound().build();
		}else {
			List<ProductoDTO>dtoList=result.stream().map(productoDTOConverter::convertirADto).collect(Collectors.toList());
			return ResponseEntity.ok(dtoList);
		}
	}

	/**
	 * Obtenemos un producto en base a su ID
	 * 
	 * @param id
	 * @return Null si no encuentra el producto
	 */
	// @PathVariable : permite inyectar un fragmento de la URL en una variable, es
	// decir, pasa el valor
	// del id de la URL al método como parámetro donde esté @PathVariable

	@GetMapping("/producto/{id}")
	public ResponseEntity<?> obtenerUno(@PathVariable Long id) {
	    Producto producto = productoRepositorio.findById(id).orElse(null);

	    if (producto == null) {
	        return ResponseEntity.notFound().build();
	    } else {
	        ProductoDTO productoDto=productoDTOConverter.convertirADto(producto);
	        return ResponseEntity.ok(productoDto);
	    }
	}


	/**
	 * Insertamos un nuevo producto
	 * 
	 * @param nuevo
	 * @return producto insertado
	 */
	// @RequestBody Permite inyectar el cuerpo de la petición en un objeto
	@PostMapping("/producto")
	public ResponseEntity<?> nuevoProducto(@RequestBody CreateProductoDTO nuevo) {
		/*Producto nuevoProducto=new Producto();
	    nuevoProducto.setNombre(nuevo.getNombre());
	    nuevoProducto.setPrecio(nuevo.getPrecio());
	    Categoria cat=categoriaRepositorio.findById(nuevo.getCategoriaId()).orElse(null);
	    nuevoProducto.setCategoria(cat);
	    return ResponseEntity.status(HttpStatus.CREATED).body(productoRepositorio.save(nuevoProducto));*/
		Producto n=productoDTOConverter.convertirAProd(nuevo);
		return ResponseEntity.status(HttpStatus.CREATED).body(productoRepositorio.save(n));
	}


	/**
	 * @param editar
	 * @param id
	 * @return 200 ok si la edicion tiene exito, 404 si no
	 */
	@PutMapping("/producto/{id}")
	public ResponseEntity<?> editarProducto(@RequestBody CreateProductoDTO editar, @PathVariable Long id) {
	    if (productoRepositorio.existsById(id)) {
	        Producto p=productoDTOConverter.convertirAProd(editar);
	        p.setId(id);
	        if(editar.getCategoriaId()==null) {
	        	p.setCategoria(productoRepositorio.findById(id).get().getCategoria());
	        }
	        if(editar.getNombre()==null) {
	        	p.setNombre(productoRepositorio.findById(id).get().getNombre());
	        }
	        if(editar.getPrecio()==0.0) {
	        	p.setPrecio(productoRepositorio.findById(id).get().getPrecio());
	        }
	        return ResponseEntity.ok(productoRepositorio.save(p));
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}


	/**
	 * Borra un producto del catálogo en base a su id
	 * 
	 * @param id
	 * @return
	 */

	@DeleteMapping("/producto/{id}")
	public ResponseEntity<?> borrarProducto(@PathVariable Long id) {
	    if (productoRepositorio.existsById(id)) {
	        Producto productoABorrar = productoRepositorio.findById(id).get();
	        productoRepositorio.deleteById(id);
	        return ResponseEntity.noContent().build();
	    } else {
	        return ResponseEntity.notFound().build();
	        
	    }
	}


}
