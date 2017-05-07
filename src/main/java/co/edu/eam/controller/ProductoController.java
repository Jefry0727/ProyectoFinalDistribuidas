/**
 * 
 */
package co.edu.eam.controller;

import co.edu.eam.orquestador.RestCliente;

/**
 * @author Jefry Londoño <jjmb2789@gmail.com>
 * @5/05/2017
 * @version 
 */
public class ProductoController {
	
	RestCliente servicio = new RestCliente();
	
	
	
	public void buscarProductoPorId(String id){
		
		servicio.servicioBuscarProducto(id);
		
	}
	
	
	public void buscarProductoPorNombre(String nombreProducto){
		
		servicio.servicioBuscarProductoNombre(nombreProducto, "0");
	}

}
