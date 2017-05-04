package co.edu.eam.model;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import co.edu.eam.dto.ClienteDTO;
import co.edu.eam.dto.PersonaDTO;



public class Prueba {
	
	@JsonProperty("name")
	private String nombre;
	@JsonProperty("age")
	private int edad;
	@JsonProperty("position")
	private String posicion;
	@JsonProperty("salary")
	private BigDecimal salario;
	@JsonProperty("skills")
	private List<String> habilidades = new ArrayList<String>();
	
	@JsonProperty("personal")
	private PersonaDTO persona;
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public String getPosicion() {
		return posicion;
	}
	
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	
	public BigDecimal getSalario() {
		return salario;
	}
	
	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}
	
	public List<String> getHabilidades() {
		return habilidades;
	}
	
	public void setHabilidades(List<String> habilidades) {
		this.habilidades = habilidades;
	}

	/**
	 * @return the persona
	 */
	public PersonaDTO getPersona() {
		return persona;
	}

	/**
	 * @param persona the persona to set
	 */
	public void setPersona(PersonaDTO persona) {
		this.persona = persona;
	}

	
	
	
	
	
	
	
	
}
