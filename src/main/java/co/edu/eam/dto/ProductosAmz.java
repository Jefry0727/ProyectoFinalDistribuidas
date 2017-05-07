/**
 * 
 */
package co.edu.eam.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Jefry Londoño <jjmb2789@gmail.com>
 * @6/05/2017
 * @version 
 */
public class ProductosAmz {

	
	@JsonProperty("products")
	private  List<ProductoAmz> productos;
	
	
	/**
	 * @return the productos
	 */
	public List<ProductoAmz> getProductos() {
		return productos;
	}

	/**
	 * @param productos the productos to set
	 */
	public void setProductos(List<ProductoAmz> productos) {
		this.productos = productos;
	}
	
}
