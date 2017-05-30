package co.edu.eam.orquestador;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.BindingProvider;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.edu.eam.servicesCliente.Cliente;
import co.edu.eam.servicesCliente.ClienteController;
import co.edu.eam.servicesCliente.ClienteControllerService;



//import co.edu.eam.servicesCliente.Cliente;
//import co.edu.eam.servicesCliente.ClienteController;
//import co.edu.eam.servicesCliente.ClienteControllerService;

//import co.edu.eam.controller.ClienteController;
//import co.edu.eam.controller.PagoController;
//import co.edu.eam.controller.ProductoController;
//import co.edu.eam.dto.ClienteCRM;
//import co.edu.eam.model.Prueba;
//import co.edu.eam.servicesCliente.Cliente;
//import co.edu.eam.servicesCliente.ClienteControllerService;

/**
 * Hello world!
 *
 */
public class App {

	// Base URI the Grizzly HTTP server will listen on
	public static final String BASE_URI = "http://0.0.0.0:18000/rest/";

	/**
	 * Starts Grizzly HTTP server exposing JAX-RS resources defined in this
	 * application.
	 * 
	 * @return Grizzly HTTP server.
	 */
	public static HttpServer startServer() {
		// create a resource config that scans for JAX-RS resources and
		// providers
		// in co.edu.eam.ingesoft.distribuidos.restapp package
		final ResourceConfig rc = new ResourceConfig().packages("co.edu.eam.services");
		//final ResourceConfig rc = new ResourceConfig().packages("co.edu.eam.ingesoft.distribuidos.restapp");

		// create and start a new instance of grizzly http server
		// exposing the Jersey application at BASE_URI
		return GrizzlyHttpServerFactory.createHttpServer(URI.create(BASE_URI), rc);
	}

	public static void main(String[] args) {
//		 ClienteControllerService servicioCliente = new ClienteControllerService();
//         ClienteController clienteServicio =  servicioCliente.getClienteControlPort();
//
//			String endpointURL1 = "http://localhost:8089/servicio_soap/ClienteController?wsdl";
//			BindingProvider bp1 = (BindingProvider) clienteServicio;
//			bp1.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointURL1);
//	                
//	               Cliente cliente = clienteServicio.operacionBuscar("455456665");
//	               
//	               System.out.println(cliente.getCedula());
		
		
		final HttpServer server = startServer();
		System.out.println(String.format(
				"Jersey app started with WADL available at " + "%sapplication.wadl\nHit enter to stop it...",
				BASE_URI));
		while (true)
			;
		// server.stop();

		// ClienteController c = new ClienteController();
		// ProductoController p = new ProductoController();
		// PagoController pa = new PagoController();
		// RestSevicioDolar sd = new RestSevicioDolar();

		// sd.servicioDolar();
		// 590bf872a92aceb86 , 590aaed5d4b89d9f9 , 590d2d223a18d6f6e
		// c.buscarCliente("590d2d223a18d6f6e");
		// p.buscarProductoPorId("B017B198DA");
		// pa.realizarPago("355646y@hotmail.com", "3214497363",
		// "590d2d223a18d6f6e", "455456665", "CC", "Henao", "28", "Santiago
		// Andres", "M", "Armenia", "Quindío", "Clle 13", "Colombia", "CO",
		// "581", "2018/10", "VISA", "APPROVED", "4869398635648702", 20000);
		// p.buscarProductoPorNombre("lego");

		// c.crearCliente("455456665", "CC", "Santiago Andres", "Henao", "M",
		// "28", "355646y@hotmail.com", "3214497363", "Colombia", "Quindío",
		// "Armenia", "Clle 13");
		// App obj = new App();
		// obj.run2();
	}

}
