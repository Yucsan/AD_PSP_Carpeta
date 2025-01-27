package ejer4_JAXB;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

import jakarta.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Pais {
	private String nombre;
	private String capital;
	private Date fechaCenso;
	private String continente;
	private Integer habitantes;
	private Integer importancia;
	
	public Pais() {
	}
	
	public Pais(String nombre, String capital, Date fechaCenso, String continente, Integer habitantes,
			Integer importancia) {
		super();
		this.nombre = nombre;
		this.capital = capital;
		this.fechaCenso = fechaCenso;
		this.continente = continente;
		this.habitantes = habitantes;
		this.importancia = importancia;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pais other = (Pais) obj;
		return Objects.equals(nombre, other.nombre);
	}

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getCapital() {
		return capital;
	}


	public void setCapital(String capital) {
		this.capital = capital;
	}


	public Date getFechaCenso() {
		return fechaCenso;
	}


	public void setFechaCenso(Date fechaCenso) {
		this.fechaCenso = fechaCenso;
	}


	public String getContinente() {
		return continente;
	}


	public void setContinente(String continente) {
		this.continente = continente;
	}


	public Integer getHabitantes() {
		return habitantes;
	}


	public void setHabitantes(Integer habitantes) {
		this.habitantes = habitantes;
	}


	public Integer getImportancia() {
		return importancia;
	}


	public void setImportancia(Integer importancia) {
		this.importancia = importancia;
	}
	
	@Override
	public String toString() {
		return "Pais [nombre=" + nombre + ", capital=" + capital + ", fechaCenso=" + fechaCenso + ", continente="
				+ continente + ", habitantes=" + habitantes + ", importancia=" + importancia + "]";
	}

	
	
	
	
}
