package co.edu.eam.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ContactoDTO {
	
	@JsonProperty("mail")
	private String correo;
	
	@JsonProperty("cellNumber")
	private String telefono;

	/**
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	
}
