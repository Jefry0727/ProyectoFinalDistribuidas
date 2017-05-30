package co.edu.eam.orquestador;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.RemoteException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

//import org.apache.http.client.ClientProtocolException;
//import org.jboss.resteasy.client.ClientRequest;
//import org.jboss.resteasy.client.ClientResponse;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import co.edu.eam.dto.ClienteCRM;
import co.edu.eam.dto.PagosPayu;
import co.edu.eam.dto.ProductoAmz;
import co.edu.eam.dto.ProductosAmz;
import co.edu.eam.model.Clientes;
import co.edu.eam.model.Prueba;
import co.edu.eam.servicesDolar.TCRMServicesInterfaceProxy;

public class RestCliente {

	/**
	 * @param args
	 *            the command line arguments
	 */
	/**
	 * Valid from and valid to TCRM date format
	 */
	private final static String _DATE_RESPONSE_FORMAT = "EEE, d MMM yyyy HH:mm:ss Z";

	/**
	 * TCRM query value format
	 */
	private final static String _VALUE_QUERY_FORMAT = "#0";

	/**
	 * Web Service end point
	 */
	private final static String _WEB_SERVICE_URL = "https://www.superfinanciera.gov.co/SuperfinancieraWebServiceTRM/TCRMServicesWebService/TCRMServicesWebService?WSDL";

	/**
	 * 
	 * <p>
	 * <b> Servicio que consume el valor del dolar actual </b>
	 * </p>
	 * <br/>
	 * <ul>
	 * <li></li>
	 * </ul>
	 * <br/>
	 * 
	 * @author EAM <br/>
	 *         Jefry Londoño Acosta <br/>
	 *         Email: jjmb2789@gmail.com <br/>
	 *         15/05/2017
	 * @version 1.0
	 * @return double
	 */
	public double servicioDolar() {

		try {
			//
			// Simple date format declaration
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(_DATE_RESPONSE_FORMAT);

			//
			// Decimal value format declaration
			DecimalFormat decimalFormat = new DecimalFormat(_VALUE_QUERY_FORMAT);

			TCRMServicesInterfaceProxy proxy = new TCRMServicesInterfaceProxy(_WEB_SERVICE_URL);

			//
			// Gets the TCRM value for the current date
			co.edu.eam.servicesDolar.TcrmResponse tcrmResponse = null;

			tcrmResponse = proxy.queryTCRM(null);

//			System.out.println("Identificador: " + tcrmResponse.getId());
//			System.out
//					.println("TCRM Valida desde: " + simpleDateFormat.format(tcrmResponse.getValidityFrom().getTime()));
//			System.out.println("TCRM Valida hasta: " + simpleDateFormat.format(tcrmResponse.getValidityTo().getTime()));
			System.out.println("Valor: " + decimalFormat.format(tcrmResponse.getValue()));
			
			

			return Double.parseDouble(decimalFormat.format(tcrmResponse.getValue())+"");

		} catch (RemoteException ex) {

			ex.printStackTrace();

			return 0.0;

		}

	}

	/**
	 * 
	 * <p>
	 * <b> Invoca el servicio de CRM Para craer un cliente </b>
	 * </p>
	 * <br/>
	 * <ul>
	 * <li></li>
	 * </ul>
	 * <br/>
	 * 
	 * @author EAM <br/>
	 *         Jefry Londoño Acosta <br/>
	 *         Email: jjmb2789@gmail.com <br/>
	 *         15/05/2017
	 * @version 1.0
	 * @param objeto
	 * @return ClienteCRM
	 */
	public ClienteCRM servicioCrearClientes(ClienteCRM objeto) {

		ClienteCRM respuesta;

		String output = servicioPost("http://104.155.149.197:8090/tienda/espocrm/createCustomer", objeto);

		if (output != null) {

			respuesta = (ClienteCRM) createJsonToObject(output, new ClienteCRM());

			System.out.println(respuesta.getCliente().getPersona().getNombres());

			return respuesta;
		}

		return null;

	}

	/**
	 * 
	 * <p>
	 * <b> Invoca el servicio de CRM Para buscar un cliente </b>
	 * </p>
	 * <br/>
	 * <ul>
	 * <li></li>
	 * </ul>
	 * <br/>
	 * 
	 * @author EAM <br/>
	 *         Jefry Londoño Acosta <br/>
	 *         Email: jjmb2789@gmail.com <br/>
	 *         4/05/2017
	 * @version 1.0
	 * @param id
	 */
	public ClienteCRM servicioBuscarClientes(String id) throws Exception{

		ClienteCRM cliente;

		String output = servicioGet("http://104.155.149.197:8090/tienda/espocrm/searchCustomer/" + id, "1");

		if (output != null) {

			cliente = (ClienteCRM) createJsonToObject(output, new ClienteCRM());

			System.out.println("SERVICIO ....");

			System.out.println(cliente.getCliente().getPersona().getNombres());
			
			System.out.println("Antes del return");

			return cliente;

		}

		return null;

	}

	/**
	 * 
	 * <p>
	 * <b> Invoca al servicio de Amazon para buscar un producto por id </b>
	 * </p>
	 * <br/>
	 * <ul>
	 * <li></li>
	 * </ul>
	 * <br/>
	 * 
	 * @author EAM <br/>
	 *         Jefry Londoño Acosta <br/>
	 *         Email: jjmb2789@gmail.com <br/>
	 *         4/05/2017
	 * @version 1.0
	 * @param id
	 */
	public ProductoAmz servicioBuscarProducto(String id) {

		String output = servicioGet("http://104.155.149.197:8090/tienda/amazon/searchProduct/" + id, "1");

		if (output != null) {

			ProductoAmz respuesta = (ProductoAmz) createJsonToObject(output, new ProductoAmz());

			System.out.println(respuesta.getProducto().getDescripcion().getNombre());

			return respuesta;
		}

		return null;

	}

	/**
	 * 
	 * <p>
	 * <b> Invoca al servicio de Amazon para buscar un producto por nombre </b>
	 * </p>
	 * <br/>
	 * <ul>
	 * <li></li>
	 * </ul>
	 * <br/>
	 * 
	 * @author EAM <br/>
	 *         Jefry Londoño Acosta <br/>
	 *         Email: jjmb2789@gmail.com <br/>
	 *         5/05/2017
	 * @version 1.0
	 * @param nombreProducto
	 */
	public ProductosAmz servicioBuscarProductoNombre(String nombreProducto, String tipo) {

		String output = servicioGet("http://104.155.149.197:8090/tienda/amazon/searchAll/" + nombreProducto, tipo);

		if (output != null) {

			ProductosAmz respuesta = (ProductosAmz) createJsonToObject(output, new ProductosAmz());
			System.out.println(respuesta.getProductos().get(0).getProducto().getDescripcion().getMarca());

			return respuesta;
		}

		return null;

	}

	/**
	 * 
	 * <p>
	 * <b> Invoca al servicio de PAYU para generar un pago </b>
	 * </p>
	 * <br/>
	 * <ul>
	 * <li></li>
	 * </ul>
	 * <br/>
	 * 
	 * @author EAM <br/>
	 *         Jefry Londoño Acosta <br/>
	 *         Email: jjmb2789@gmail.com <br/>
	 *         6/05/2017
	 * @version 1.0
	 * @param objeto
	 */
	public PagosPayu servicioRealizarPago(PagosPayu objeto) {

		String output = servicioPost("http://104.155.149.197:8090/tienda/payu/payment", objeto);

		if (output != null) {

			PagosPayu respuesta = (PagosPayu) createJsonToObject(output, new PagosPayu());

			System.out.println(respuesta.getPagos().getEstado() + " " + respuesta.getPagos().getId_operacion());

			return respuesta;

		}

		return null;

	}

	/**
	 * 
	 * <p>
	 * <b> Funcion que realiza la conexion de cualquier servicio POST </b>
	 * </p>
	 * <br/>
	 * <ul>
	 * <li></li>
	 * </ul>
	 * <br/>
	 * 
	 * @author EAM <br/>
	 *         Jefry Londoño Acosta <br/>
	 *         Email: jjmb2789@gmail.com <br/>
	 *         4/05/2017
	 * @version 1.0
	 * @param objeto
	 */
	public String servicioPost(String urlRequest, Object objeto) {
		
		
		try {

			Client client = Client.create();

			WebResource webResource = client
			   .resource(urlRequest);
			
			/*
			 * Se envia el objeto para transformarlo en JSON
			 */
			String input = createObjectToJson(objeto);
			
			System.out.println("Convertir...");
			
			System.out.println(input);

			ClientResponse response = webResource.type("application/json")
			   .post(ClientResponse.class, input);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
				     + response.getStatus());
			}

			System.out.println("Output from Server .... \n");
			String output = response.getEntity(String.class);
			System.out.println(output);
			
			/*
			 * Parte la cadena JSON que es la respuesta del servicio POST
			 */
			output = organizarCadena(output, "1");
			
			return output;

		  } catch (Exception e) {

			e.printStackTrace();
			
			return null;

		  }

	}

	/**
	 * 
	 * <p>
	 * <b> Funcion que realiza la conexion de cualquier servicio GET </b>
	 * </p>
	 * <br/>
	 * <ul>
	 * <li></li>
	 * </ul>
	 * <br/>
	 * 
	 * @author EAM <br/>
	 *         Jefry Londoño Acosta <br/>
	 *         Email: jjmb2789@gmail.com <br/>
	 *         4/05/2017
	 * @version 1.0
	 * @param urlRequest
	 */
	public String servicioGet(String urlRequest, String tipo) {
		try {

			Client client = Client.create();

			WebResource webResource = client
			   .resource(urlRequest);

			ClientResponse response = webResource.accept("application/json")
	                   .get(ClientResponse.class);

			if (response.getStatus() != 200) {
			   throw new RuntimeException("Failed : HTTP error code : "
				+ response.getStatus());
			}

			String output = response.getEntity(String.class);

			System.out.println("Output from Server .... \n");
			System.out.println(output);
			
			output = organizarCadena(output, tipo);
			
			return output;

		  } catch (Exception e) {

			e.printStackTrace();
			return null;
		  }

	}

	/**
	 * 
	 * <p>
	 * <b> organiza la cadena JSON para posterior convertirla en objeto </b>
	 * </p>
	 * <br/>
	 * <ul>
	 * <li></li>
	 * </ul>
	 * <br/>
	 * 
	 * @author EAM <br/>
	 *         Jefry Londoño Acosta <br/>
	 *         Email: jjmb2789@gmail.com <br/>
	 *         4/05/2017
	 * @version 1.0
	 * @param outputAuxiliar
	 */
	public String organizarCadena(String outputAuxiliar, String tipo) {

		outputAuxiliar = ((outputAuxiliar.split("\"response\":"))[1]).substring(0,
				((outputAuxiliar.split("\"response\":"))[1]).length() - 1);

		if (tipo.equals("1")) {

			outputAuxiliar = outputAuxiliar.replaceAll("\\[", " ");
			outputAuxiliar = outputAuxiliar.replaceAll("\\]", " ");

		}

		return outputAuxiliar;

	}

	/**
	 * 
	 * <p>
	 * <b>Crea un Objeto a partir de un Json </b>
	 * </p>
	 * <br/>
	 * <ul>
	 * <li></li>
	 * </ul>
	 * <br/>
	 * 
	 * @author EAM <br/>
	 *         Jefry Londoño Acosta <br/>
	 *         Email: jjmb2789@gmail.com <br/>
	 *         4/05/2017
	 * @version 1.0
	 * @param objeto
	 * @return
	 */
	public String createObjectToJson(Object objeto) {

		ObjectMapper mapper = new ObjectMapper();

		try {

			String jsonInString = "";

			// Convert object to JSON string and pretty print
			jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(objeto);
			// System.out.println(jsonInString);

			return jsonInString;

		} catch (JsonGenerationException e) {

			e.printStackTrace();

		} catch (JsonMappingException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

		return null;

	}

	/**
	 * 
	 * <p>
	 * <b>Crea un Json en el objeto deseado </b>
	 * </p>
	 * <br/>
	 * <ul>
	 * <li></li>
	 * </ul>
	 * <br/>
	 * 
	 * @author EAM <br/>
	 *         Jefry Londoño Acosta <br/>
	 *         Email: jjmb2789@gmail.com <br/>
	 *         4/05/2017
	 * @version 1.0
	 * @param jsonInString
	 * @param objeto
	 */
	public Object createJsonToObject(String jsonInString, Object objeto) {

		ObjectMapper mapper = new ObjectMapper();

		try {
			
			System.out.println("convertir objeto ...");
			System.out.println(jsonInString);

			// Convert JSON string to Object
			Object object = mapper.readValue(jsonInString, objeto.getClass());
			System.out.println(object);

			// Pretty print
			String prettyStaff1 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
			System.out.println(prettyStaff1);

			return object;

		} catch (JsonGenerationException e) {

			e.printStackTrace();

		} catch (JsonMappingException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

		return null;

	}

	public void prueba() {

		String cadenaEjemplo = "{  \"code\": \"200\",  \"status\": \"Ok\",  \"response\": {    \"customer\": {      \"personal\": {        \"firstName\": \"maria\",        \"lastName\": \"Cano\",        \"sex\": \"F\"      },      \"social\": {        \"mail\": [          \"46gdd@hotmail.com\"        ],        \"cellNumber\": [          \"3214563363\"        ]      },      \"localization\": {        \"country\": \"Colombia\",        \"state\": \"Quindío\",        \"city\": \"Armenia\",        \"addressStreet\": \"Clle 13\"      },      \"ids\": {        \"id\": \"590aaed5d4b89d9f9\"      }    }  }}";
		System.out.println("ToString");
		System.out.println(((cadenaEjemplo.split("\"response\":"))[1]).substring(0,
				((cadenaEjemplo.split("\"response\":"))[1]).length() - 1));

		String cadenaNueva = ((cadenaEjemplo.split("\"response\":"))[1]).substring(0,
				((cadenaEjemplo.split("\"response\":"))[1]).length() - 1);
		cadenaNueva = cadenaNueva.replaceAll("\\[", " ");
		cadenaNueva = cadenaNueva.replaceAll("\\]", " ");
		// cadenaNueva.replaceAll("]","");
		System.out.println(cadenaNueva);
		createJsonToObject(cadenaNueva, new ClienteCRM());
	}

}
