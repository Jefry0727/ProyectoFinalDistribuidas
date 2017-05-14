/**
 * 
 */
package co.edu.eam.services;

import co.edu.eam.controller.ClienteController;
import co.edu.eam.controller.PagoController;
import co.edu.eam.controller.ProductoController;
import co.edu.eam.model.Cliente;
import co.edu.eam.model.Tarjeta;

/**
 * @author Alvaro lotero <lotero021095@gmail.com> @12/05/2017
 * @version
 */
public class RestApp {

	ClienteController clienteController = new ClienteController();

	PagoController pagoController = new PagoController();
	
	ProductoController productoController = new ProductoController();

	/**
	 * 
	 * <p>
	 * <b> Servicio crear cliente que se expone, tipo REST para el GUI </b>
	 * </p>
	 * <br/>
	 * <ul>
	 * <li></li>
	 * </ul>
	 * <br/>
	 * 
	 * @author EAM <br/>
	 *         Alvaro lotero <br/>
	 *         Email: lotero021095@gmail.com <br/>
	 *         12/05/2017
	 * @version 1.0
	 * @param cliente
	 */
	public void restCrearCliente(Cliente cliente) {

		clienteController.crearCliente(cliente.getNumero(), cliente.getTipoDocumento(), cliente.getNombres(),
				cliente.getApellido(), cliente.getGenero(), cliente.getEdad(), cliente.getCorreo(),
				cliente.getTelefono(), cliente.getPais(), cliente.getDepartamento(), cliente.getCiudad(),
				cliente.getDireccion());

	}

	/**
	 * 
	 * <p>
	 * <b> Servicio buscar cliente que se expone, tipo REST para el GUI </b>
	 * </p>
	 * <br/>
	 * <ul>
	 * <li></li>
	 * </ul>
	 * <br/>
	 * 
	 * @author EAM <br/>
	 *         Alvaro lotero <br/>
	 *         Email: lotero021095@gmail.com <br/>
	 *         12/05/2017
	 * @version 1.0
	 * @param id
	 */
	public void restBuscarCliente(String id) {

		clienteController.buscarCliente(id);

	}
	
	/**
	 * 
	 * <p><b> Servicio pagar que se expone, tipo REST para el GUI </b></p><br/>
	 * <ul><li></li></ul><br/>
	 * @author EAM <br/>
	 *         Alvaro lotero <br/>
	 *         Email: lotero021095@gmail.com <br/>
	 *         12/05/2017
	 * @version 1.0
	 * @param cliente
	 * @param tarjeta
	 */
	public void restPago(Cliente cliente, Tarjeta tarjeta) {

		pagoController.realizarPago(cliente.getCorreo(), cliente.getTelefono(), cliente.getId(), cliente.getNumero(),
				cliente.getTipoDocumento(), cliente.getApellido(), cliente.getEdad(), cliente.getNombres(),
				cliente.getGenero(), cliente.getCiudad(), cliente.getCiudad(), cliente.getDireccion(),
				cliente.getPais(), tarjeta.getCiudadTarjeta(), tarjeta.getCodigoSeguridad(),
				tarjeta.getFechaVencimiento(), tarjeta.getMetodoPago(), tarjeta.getNombreTarjeta(),
				tarjeta.getNumeroTarjeta(), tarjeta.getValor());

	}
	
	
	public void restBuscarProductoNombre(String nombreProducto){
		
		productoController.buscarProductoPorNombre(nombreProducto);
	}
	
	
	public void restBuscarProductoId(String id){
		
		productoController.buscarProductoPorId(id);
		
	}
	
	

}
