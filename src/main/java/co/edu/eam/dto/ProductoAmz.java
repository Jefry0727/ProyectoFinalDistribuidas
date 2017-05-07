/**
 * 
 */
package co.edu.eam.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Jefry Londoño <jjmb2789@gmail.com>
 * @4/05/2017
 * @version 
 */
public class ProductoAmz {
	
	@JsonProperty("product")
	private ProductoDTO producto;
	
	

	/**
	 * @return the producto
	 */
	public ProductoDTO getProducto() {
		return producto;
	}

	/**
	 * @param producto the producto to set
	 */
	public void setProducto(ProductoDTO producto) {
		this.producto = producto;
	}

	
	
	

}
