package com.ejemplos.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.ejemplos.modelo.Usuario;
import com.ejemplos.service.UsuarioService;

@Controller
public class UsuarioController {
	

	@Autowired
	private UsuarioService usuarioService;
	//******************************************
	
	@GetMapping("/index")
	public String inicio(Model model) {
		model.addAttribute("titulo","Prueba del index");
		return "index";
	}
	
	//mostrar
	@GetMapping("/listado")
	public String listar(Model model) {
		model.addAttribute("titulo","Listado de usuarios");	
		
		List<Usuario>usuarios = usuarioService.obtenerUsuarios();
	
		
		if(usuarios.isEmpty()){
			
			model.addAttribute("usuarios", usuarios );
		}else {			
			model.addAttribute("usuarios", usuarioService.obtenerUsuarios() );
		}
		
		return "listar";
	}
	
	//mostrar
	@GetMapping(value="/eliminar/{id}")
	public String eliminar(@PathVariable(value="id")Long id) {
		
		if(id>0) {
			usuarioService.borrarUsuario(id);
		}
		return "redirect:/listado";
	}
	
	
	@GetMapping(value = "/form")
	public String crear(Model model) {
		Usuario usuario = new Usuario(); // objeto mismo nombre que la clase
		
		//paso datos a la vista
		model.addAttribute("usuario", usuario);
		model.addAttribute("titulo", "Formulario de usuario");
		return "formsincss";
		//fase 1 mostrar formulario
	}
	
	/*  2da fase el usuario envia los datos cuando se hace sumit del formulario  
	 se necesita metodo que trate estos datos la url es igual al Post guardar porcesa el formulario y recibe datos*/
	@PostMapping("/form")
	public String guardar(Usuario usuario) {
		usuarioService.crearUsuario(usuario);
		return "redirect:/listado";
	}
	
	
	
	
}
