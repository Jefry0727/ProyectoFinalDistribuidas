/**
 * 
 */
package co.edu.eam.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Jefry Londoño <jjmb2789@gmail.com>
 * @4/05/2017
 * @version 
 */
public class ImagenDTO {

	@JsonProperty("small")
	private String imagenPequenia;
	
	@JsonProperty("medium")
	private String imagenMediana;
	
	@JsonProperty("large")
	private String imagenGrande;

	/**
	 * @return the imagenPequenia
	 */
	public String getImagenPequenia() {
		return imagenPequenia;
	}

	/**
	 * @param imagenPequenia the imagenPequenia to set
	 */
	public void setImagenPequenia(String imagenPequenia) {
		this.imagenPequenia = imagenPequenia;
	}

	/**
	 * @return the imagenMediana
	 */
	public String getImagenMediana() {
		return imagenMediana;
	}

	/**
	 * @param imagenMediana the imagenMediana to set
	 */
	public void setImagenMediana(String imagenMediana) {
		this.imagenMediana = imagenMediana;
	}

	/**
	 * @return the imagenGrande
	 */
	public String getImagenGrande() {
		return imagenGrande;
	}

	/**
	 * @param imagenGrande the imagenGrande to set
	 */
	public void setImagenGrande(String imagenGrande) {
		this.imagenGrande = imagenGrande;
	}
	
	
	
}
