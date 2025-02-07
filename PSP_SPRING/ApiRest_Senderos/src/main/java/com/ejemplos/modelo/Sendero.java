package com.ejemplos.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Sendero {
	
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cod_sendero")
	private String id;
	private String nombre;
	private Integer distancia;
	private String dificultad;
	
	@ManyToOne
	@JoinColumn(name = "cod_municipio")
	private Sendero sendero;
	
	
	
	
}
