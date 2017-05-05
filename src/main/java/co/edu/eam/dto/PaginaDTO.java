/**
 * 
 */
package co.edu.eam.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Jefry Londoño <jjmb2789@gmail.com>
 * @5/05/2017
 * @version 
 */
public class PaginaDTO {
	
	@JsonProperty("now")
	private String existencia;
	
	@JsonProperty("total")
	private String total;

	/**
	 * @return the existencia
	 */
	public String getExistencia() {
		return existencia;
	}

	/**
	 * @param existencia the existencia to set
	 */
	public void setExistencia(String existencia) {
		this.existencia = existencia;
	}

	/**
	 * @return the total
	 */
	public String getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(String total) {
		this.total = total;
	}
	
	

}
