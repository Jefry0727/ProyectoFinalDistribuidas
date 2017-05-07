/**
 * 
 */
package co.edu.eam.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Jefry Londoño <jjmb2789@gmail.com>
 * @6/05/2017
 * @version 
 */
public class PagoDTO {

	@JsonProperty("value")
	private ValorDTO valor;
	
	@JsonProperty("card")
	private TarjetaDTO tarjeta;
	
	@JsonProperty("customer")
	private ClienteDTO cliente;

	/**
	 * @return the valor
	 */
	public ValorDTO getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(ValorDTO valor) {
		this.valor = valor;
	}

	/**
	 * @return the tarjeta
	 */
	public TarjetaDTO getTarjeta() {
		return tarjeta;
	}

	/**
	 * @param tarjeta the tarjeta to set
	 */
	public void setTarjeta(TarjetaDTO tarjeta) {
		this.tarjeta = tarjeta;
	}

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
