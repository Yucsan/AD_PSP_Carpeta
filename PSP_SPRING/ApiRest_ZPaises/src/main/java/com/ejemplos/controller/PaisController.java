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

import com.ejemplos.DTO.CreatePaisDTO;
import com.ejemplos.DTO.PaisDTO;
import com.ejemplos.DTO.PaisDTOConverter;
import com.ejemplos.modelo.Pais;
import com.ejemplos.modelo.PaisRepositorio;
import com.ejemplos.modelo.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor // lombok crea el contructor
public class PaisController {
	
	@Autowired 
	private final PaisRepositorio paisRepositorio;  // con autowired ya no 
	
	@Autowired
	private PaisDTOConverter paisDTOConverter;
	
	
	@GetMapping("/producto") 
	public ResponseEntity<?> obtenerTodos(){
		List<Pais>result = paisRepositorio.findAll();
		
		if(result.isEmpty()) {
			return ResponseEntity.notFound().build();
		}else {

			List<PaisDTO> dtoList = result.stream()
					.map(paisDTOConverter::convertirADto)
					.collect(Collectors.toList());
			return ResponseEntity.ok(dtoList);
		}
	}
	//http://localhost:8080/producto -----------------------------------------------------------------------------
	
	@GetMapping("/producto/{id}")
	public ResponseEntity<?> obtenerUno(@PathVariable Integer id) {
		Pais result = paisRepositorio.findById(id).orElse(null); 
		
		//not found es el 404
		if(result==null)
			return ResponseEntity.notFound().build();
		else {
			return ResponseEntity.ok(paisDTOConverter.convertirADto(result));
		}
				
	}
	
	//Postman url: http://localhost:8080/producto -----------------------------------------------------------------------------------------------------------------
	// 1 Insertamos nuevo producto @param nuevo   2 @return producto insertado
	
	@PostMapping("/producto")
	public  ResponseEntity<?> nuevoPais(@RequestBody CreatePaisDTO nuevo) {
		Pais saved = paisDTOConverter.convertirAProd(nuevo);
		return  ResponseEntity.status(HttpStatus.CREATED).body( paisRepositorio.save(saved)); //201 Created
	}
	
	// http://localhost:8080/producto
/*
	 {  "nombre":"Zumo PAPAYA",
    	"precio" : 9,
    	"categoriaId": 1  } */
	
	// ACTUALIZA PRODUCTO | @param editar | @param id | @return  
	
	@PutMapping("/producto/{id}")
	public ResponseEntity<?> editarPais(@RequestBody CreatePaisDTO editar, @PathVariable Integer id) {
		if(paisRepositorio.existsById(id)) {
			Pais n = paisDTOConverter.convertirAProd(editar);
			n.setId(id);
			return ResponseEntity.ok(paisRepositorio.save(n));
		}else
			return ResponseEntity.notFound().build();
	}
	
	//para probarlo en Postman http://localhost:8080/producto/1452 --------------------------------------------------------------
	//Borrar
		
	@DeleteMapping("/producto/{id}") // da error porque tiene la misma URL
	public ResponseEntity<?> borrarPais(@PathVariable Integer id ) {
		if(paisRepositorio.existsById(id)) {
			paisRepositorio.deleteById(id);
			return ResponseEntity.noContent().build(); //204
		}else {
			return ResponseEntity.notFound().build();
		}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
