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
	
	@JsonProperty("products")
	private  List<ProductoDTO> productos;

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

	/**
	 * @return the productos
	 */
	public List<ProductoDTO> getProductos() {
		return productos;
	}

	/**
	 * @param productos the productos to set
	 */
	public void setProductos(List<ProductoDTO> productos) {
		this.productos = productos;
	}
	
	

}
