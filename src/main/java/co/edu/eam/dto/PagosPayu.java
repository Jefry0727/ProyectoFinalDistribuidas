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
public class PagosPayu {
	
	@JsonProperty("payment")
	private PagoDTO pagos;
	
	/**
	 * @return the pagos
	 */
	public PagoDTO getPagos() {
		return pagos;
	}

	/**
	 * @param pagos the pagos to set
	 */
	public void setPagos(PagoDTO pagos) {
		this.pagos = pagos;
	}
	
	

}
