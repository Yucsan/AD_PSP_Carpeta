package com.ejemplos.modelo;

public class Usuario {
	
	private long id;
	private String nombre;
	private String avatar;
	private String mail;
	
	public Usuario(long id, String nombre, String avatar, String mail) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.avatar = avatar;
		this.mail = mail;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
	
	

}
