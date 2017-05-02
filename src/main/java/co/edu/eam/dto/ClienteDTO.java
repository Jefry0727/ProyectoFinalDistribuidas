package co.edu.eam.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClienteDTO {
	
	@JsonProperty("identification")
	private IdentificacionDTO identificacion;
	
	@JsonProperty("personal")
	private PersonaDTO persona;
	
	@JsonProperty("social")
	private ContactoDTO contacto;
	
	@JsonProperty("localization")
	private UbicacionDTO ubicacion;
	
	@JsonProperty("ids")
	private IdDTO id;

	/**
	 * @return the identificacion
	 */
	public IdentificacionDTO getIdentificacion() {
		return identificacion;
	}

	/**
	 * @param identificacion the identificacion to set
	 */
	public void setIdentificacion(IdentificacionDTO identificacion) {
		this.identificacion = identificacion;
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

	/**
	 * @return the contacto
	 */
	public ContactoDTO getContacto() {
		return contacto;
	}

	/**
	 * @param contacto the contacto to set
	 */
	public void setContacto(ContactoDTO contacto) {
		this.contacto = contacto;
	}

	/**
	 * @return the ubicacion
	 */
	public UbicacionDTO getUbicacion() {
		return ubicacion;
	}

	/**
	 * @param ubicacion the ubicacion to set
	 */
	public void setUbicacion(UbicacionDTO ubicacion) {
		this.ubicacion = ubicacion;
	}

	/**
	 * @return the id
	 */
	public IdDTO getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(IdDTO id) {
		this.id = id;
	}
	
	

}
