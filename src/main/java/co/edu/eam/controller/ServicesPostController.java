/**
 * 
 */
package co.edu.eam.controller;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.BindingProvider;

import co.edu.eam.dto.ItemDTO;
import co.edu.eam.servicesCliente.Cliente;
import co.edu.eam.servicesCliente.ClienteController;
import co.edu.eam.servicesCliente.ClienteControllerService;
import co.edu.eam.servicesCompra.CompraController;
//import co.edu.eam.servicesCompra.CompraController;
//import co.edu.eam.servicesCompra.CompraControllerService;
//import co.edu.eam.servicesCompra.ItemsDTO;
import co.edu.eam.servicesCompra.CompraControllerService;
import co.edu.eam.servicesCompra.ItemsDTO;

/**
 * @author Alvaro lotero <lotero021095@gmail.com> @13/05/2017
 * @version
 */
public class ServicesPostController {

	private ClienteController clienteServicio;

	private CompraController servicio;

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
	public String servicioPostCrearCliente(String cedula, String idCrm) throws Exception{
		
		System.out.println("Entre al post guardar");
		/*
		 * Inicia el servicio post
		 */
		consumirServicioClientePost();

		/*
		 * Objeto Cliente del servico Post
		 */
		Cliente cliente = new Cliente();
		cliente.setCedula(cedula);
		cliente.setId(1);
		cliente.setIdCrm(idCrm);

		return clienteServicio.operacionCrear(cliente);
		

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
		
		System.out.println("Entre al post");
		/*
		 * Inicia el servicio post
		 */
		consumirServicioClientePost();
		
//		ClienteControllerService servicioCliente = new ClienteControllerService();
		

		//ClienteController clienteServicio = servicioCliente.getClienteControlPort();
		System.out.println("despues del host");

//		String endpointURL1 = "http://localhost:8089/servicio_soap/CompraController?wsdl";
//		BindingProvider bp1 = (BindingProvider) clienteServicio;
//		bp1.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointURL1);
		
		
		/*
		 * Objeto Cliente del servico Post
		 */
		return clienteServicio.operacionBuscar(cedula);

	}

	/**
	 * 
	 * <p>
	 * <b> Servicio POST que crea una compra en la base de datos junto con su
	 * items compra </b>
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
	 * @param idCliente
	 * @param valorTotal
	 * @param itemsCompra
	 * @return
	 */
	public boolean servicioPostCompra(int idCliente, double valorTotal, List<ItemDTO> itemsCompra) throws Exception{
		
		System.out.println("entra al post compra");
		List<ItemsDTO> items = new ArrayList<>();
		
		for (ItemDTO itemDTO : itemsCompra) {
			
			ItemsDTO item = new ItemsDTO();
			
			item.setCantidad(itemDTO.getCantidad());
			item.setIdProducto(itemDTO.getIdProducto());
			item.setValorProducto(itemDTO.getValorProducto());
			
			items.add(item);
			
		}
		
		/*
		 * Inicia el servicio post
		 */
		consumirServicioCompraPost();

		return servicio.operacionCrearCompra(idCliente, valorTotal, items);

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

		clienteServicio = servicioCliente.getClienteControlPort();

		String endpointURL1 = "http://localhost:8089/servicio_soap/ClienteController";
		BindingProvider bp1 = (BindingProvider) clienteServicio;
		bp1.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointURL1);

	}

	/**
	 * 
	 * <p>
	 * <b> Funcion que instancia el servcio POST de la Compra </b>
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

	public void consumirServicioCompraPost() {

		CompraControllerService servicioCompra = new CompraControllerService();

		servicio = servicioCompra.getCompraCtlPort();

		String endpointURL1 = "http://localhost:8089/servicio_soap/CompraController";
		BindingProvider bp1 = (BindingProvider) servicio;
		bp1.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointURL1);

	}

}
