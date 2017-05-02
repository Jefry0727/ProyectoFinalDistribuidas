package co.edu.eam.model;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;



public class Prueba {
	
	@JsonProperty("name")
	String nombre;
	@JsonProperty("age")
	int edad;
	@JsonProperty("position")
	String posicion;
	@JsonProperty("salary")
	BigDecimal salario;
	@JsonProperty("skills")
	List<String> habilidades = new ArrayList<String>();
	
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

	
	
	
	
	
	
	
	
}
