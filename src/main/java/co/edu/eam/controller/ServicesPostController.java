/**
 * 
 */
package co.edu.eam.controller;

import javax.xml.ws.BindingProvider;

import co.edu.eam.servicesCliente.Cliente;
import co.edu.eam.servicesCliente.ClienteController;
import co.edu.eam.servicesCliente.ClienteControllerService;

/**
 * @author Alvaro lotero <lotero021095@gmail.com> @13/05/2017
 * @version
 */
public class ServicesPostController {

	private ClienteController servicio;

	/**
	 * 
	 */
	public ServicesPostController() {

	}

	/**
	 * 
	 * <p>
	 * <b> Servicio POST que crea un cliente en la base de datos </b>
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
	 *         14/05/2017
	 * @version 1.0
	 * @param cedula
	 * @param idCrm
	 * @return
	 */
	public boolean servicioPostCrearCliente(String cedula, String idCrm) {

		/*
		 * Inicia el servicio post
		 */
		consumirServicioClientePost();

		/*
		 * Objeto Cliente del servico Post
		 */
		Cliente cliente = new Cliente();
		cliente.setCedula(cedula);
		// cliente.setId(value);
		cliente.setIdCrm(idCrm);

		return servicio.operacionCrear(cliente);

	}

	/**
	 * 
	 * <p>
	 * <b> Servicio POST que busca un Cliente en la base de datos </b>
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
	 *         14/05/2017
	 * @version 1.0
	 * @param cedula
	 * @return
	 */
	public Cliente servicioPostBuscarCliente(String cedula) {

		/*
		 * Inicia el servicio post
		 */
		consumirServicioClientePost();

		/*
		 * Objeto Cliente del servico Post
		 */

		return servicio.operacionBuscar(cedula);

	}

	/**
	 * 
	 * <p>
	 * <b> Funcion que instancia el servcio POST del cliente </b>
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
	 *         14/05/2017
	 * @version 1.0
	 */
	public void consumirServicioClientePost() {

		ClienteControllerService servicioCliente = new ClienteControllerService();

		ClienteController servicio = servicioCliente.getClienteControlPort();

		String endpointURL1 = "localhost:8089/servicio_soap/ClienteController";
		BindingProvider bp1 = (BindingProvider) servicio;
		bp1.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointURL1);

	}
	
	public void consumirServicioCompraPost(){
		
		
		
	}

}
