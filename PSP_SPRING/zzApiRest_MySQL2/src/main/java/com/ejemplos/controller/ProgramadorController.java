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
import com.ejemplos.DTO.CreateProgramadorDTO;
import com.ejemplos.DTO.ProductoDTO;
import com.ejemplos.DTO.ProductoDTOConverter;
import com.ejemplos.DTO.ProgramadorDTO;
import com.ejemplos.DTO.ProgramadorDTOConverter;
import com.ejemplos.modelo.Programador;
import com.ejemplos.modelo.ProgramadorRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor // lombok crea el contructor
public class ProgramadorController {
	
	@Autowired 
	private final ProgramadorRepository programadorRepository;  // con autowired ya no 
	
	@Autowired
	private ProgramadorDTOConverter programadorDTOConverter;
	
	@GetMapping("/pro") 
	public ResponseEntity<?> obtenerTodos(){
		List<Programador>result = programadorRepository.findAll();
		
		if(result.isEmpty()) {
			return ResponseEntity.notFound().build();
		}else {
			List<ProgramadorDTO> dtoList = result.stream()
			.map(programadorDTOConverter::convertirADto)
			.collect(Collectors.toList());
			return ResponseEntity.ok(dtoList);
		}
	}
	//http://localhost:8080/producto -----------------------------------------------------------------------------
	
	@GetMapping("/pro/{id}")
	public ResponseEntity<?> obtenerUno(@PathVariable String id) {
		Programador result = programadorRepository.findById(id).orElse(null); 
		
		//not found es el 404
		if(result==null)
			return ResponseEntity.notFound().build();
		else {
			return ResponseEntity.ok(programadorDTOConverter.convertirADto(result));
		}
				
	}
	
	//en Postman para probarlo url: http://localhost:8080/producto
	//-----------------------------------------------------------------------------------------------------------------
	
	// 1 Insertamos nuevo producto @param nuevo   2 @return producto insertado
	
	@PostMapping("/producto")
	public  ResponseEntity<?> nuevoProducto(@RequestBody CreateProgramadorDTO nuevo) {
		Programador saved = programadorDTOConverter.convertirAProg(nuevo);
		return  ResponseEntity.status(HttpStatus.CREATED).body( programadorRepository.save(saved)); //201 Created
	}
	
	// http://localhost:8080/producto
	
/*
	 {  "nombre":"Zumo PAPAYA",
    	"precio" : 9,
    	"categoriaId": 1  
     }
	 	*/
	
	// MODIFICA PRODUCTO | @param editar | @param id | @return  
	
	@PutMapping("/prog/{id}")
	public ResponseEntity<?>  editaProgramador(@RequestBody Programador editar, @PathVariable String id ) {
		if(programadorRepository.existsById(id)) {
			editar.setId(id);
			return ResponseEntity.ok(programadorRepository.save(editar)); //ok
		}else {
			return ResponseEntity.notFound().build(); //404 no lo encuentro
		}
	
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	

}
