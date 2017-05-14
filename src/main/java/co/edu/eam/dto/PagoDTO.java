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
	
	@JsonProperty("operacionId")
	private String id_operacion;
	
	@JsonProperty("state")
	private String estado;

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

	/**
	 * @return the id_operacion
	 */
	public String getId_operacion() {
		return id_operacion;
	}

	/**
	 * @param id_operacion the id_operacion to set
	 */
	public void setId_operacion(String id_operacion) {
		this.id_operacion = id_operacion;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
}
