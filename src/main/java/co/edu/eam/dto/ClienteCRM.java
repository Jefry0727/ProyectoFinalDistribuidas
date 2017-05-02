package co.edu.eam.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClienteCRM {
	
	@JsonProperty("customer")
	private ClienteDTO cliente;

	/**
	 * @return the cliente
	 */
	public ClienteDTO getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}
	
	

}
