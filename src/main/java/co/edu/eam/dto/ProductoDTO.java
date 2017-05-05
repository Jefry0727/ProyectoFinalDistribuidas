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
public class ProductoDTO {
	
	@JsonProperty("page")
	private PaginaDTO pagina;
	
	@JsonProperty("description")
	private DescripcionDTO descripcion;
	
	@JsonProperty("image")
	private ImagenDTO imagenes;
	
	@JsonProperty("price")
	private CostoDTO costo;

	/**
	 * @return the descripcion
	 */
	public DescripcionDTO getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(DescripcionDTO descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the imagenes
	 */
	public ImagenDTO getImagenes() {
		return imagenes;
	}

	/**
	 * @param imagenes the imagenes to set
	 */
	public void setImagenes(ImagenDTO imagenes) {
		this.imagenes = imagenes;
	}

	/**
	 * @return the costo
	 */
	public CostoDTO getCosto() {
		return costo;
	}

	/**
	 * @param costo the costo to set
	 */
	public void setCosto(CostoDTO costo) {
		this.costo = costo;
	}
	
	
	
}
