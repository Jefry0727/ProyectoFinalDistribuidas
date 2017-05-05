package co.edu.eam.orquestador;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;

import org.apache.http.client.ClientProtocolException;
import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.edu.eam.dto.ClienteCRM;
import co.edu.eam.dto.ProductoAmz;
import co.edu.eam.model.Prueba;

public class RestCliente {
	
	/**
	 * 
	 * <p><b> Invoca el servicio de CRM Para craer un cliente </b></p><br/>
	 * <ul><li></li></ul><br/>
	 * @author EAM <br/>
	 *         Jefry Londoño Acosta <br/>
	 *         Email: jjmb2789@gmail.com <br/>
	 *         4/05/2017
	 * @version 1.0
	 * @param objeto
	 */
	public void servicioCrearClientes(ClienteCRM objeto){
		
		String output = servicioPost("http://104.155.149.197:8090/tienda/espocrm/createCustomer", objeto);
		
		ClienteCRM respuesta = (ClienteCRM) createJsonToObject(output, new ClienteCRM());

		System.out.println(respuesta.getCliente().getPersona().getNombres());
		
	}
	
	/**
	 * 
	 * <p><b> Invoca el servicio de CRM Para buscar un cliente  </b></p><br/>
	 * <ul><li></li></ul><br/>
	 * @author EAM <br/>
	 *         Jefry Londoño Acosta <br/>
	 *         Email: jjmb2789@gmail.com <br/>
	 *         4/05/2017
	 * @version 1.0
	 * @param id
	 */
	public void servicioBuscarClientes(String id){
		
		String output = servicioGet("http://104.155.149.197:8090/tienda/espocrm/searchCustomer/" + id);
		
		ClienteCRM respuesta = (ClienteCRM) createJsonToObject(output, new ClienteCRM());

		System.out.println(respuesta.getCliente().getPersona().getNombres());
		
	}
	
	/**
	 * 
	 * <p><b> Invoca al servicio de Amazon para buscar un producto </b></p><br/>
	 * <ul><li></li></ul><br/>
	 * @author EAM <br/>
	 *         Jefry Londoño Acosta <br/>
	 *         Email: jjmb2789@gmail.com <br/>
	 *         4/05/2017
	 * @version 1.0
	 * @param id
	 */
	public void servicioBuscarProducto(String id){
		
		String output = servicioGet("http://104.155.149.197:8090/tienda/amazon/searchProduct/" + id);
		
		ProductoAmz respuesta = (ProductoAmz) createJsonToObject(output, new ProductoAmz());
		
		System.out.println(respuesta.getProducto().getDescripcion().getNombre());
		
	}
	
	public void servicioBuscarProductoNombre(String nombreProducto){
		
		String output = servicioGet("http://104.155.149.197:8090/tienda/amazon/searchAll/" + nombreProducto);
		
		ProductoAmz respuesta = (ProductoAmz) createJsonToObject(output, new ProductoAmz());
		
		System.out.println(respuesta.getProductos().get(0).getDescripcion().getNombre());
		
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
			/*
			 * Conexion al servicio rest
			 */
			ClientRequest request = new ClientRequest(urlRequest);
			request.accept("application/json");

			/*
			 * Se envia el objeto para transformarlo en JSON
			 */
			String input = createObjectToJson(objeto);

			/*
			 * Se envia el JSON al servicio por POST
			 */
			request.body("application/json", input);
			ClientResponse<String> response = request.post(String.class);

			System.out.println("Respuesta ....");

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}

			BufferedReader br = new BufferedReader(
					new InputStreamReader(new ByteArrayInputStream(response.getEntity().getBytes())));

			String output;
			String outputAuxiliar = "";
			System.out.println("Output from Server .... \n");

			while ((output = br.readLine()) != null) {

				outputAuxiliar += output;
				System.out.println(output);
			}

			/*
			 * Parte la cadena JSON que es la respuesta del servicio POST
			 */
			outputAuxiliar = organizarCadena(outputAuxiliar);

			System.out.println(outputAuxiliar);
			
			return outputAuxiliar;

			

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();

		}
		
		return null;

	}

	/**
	 * 
	 * <p><b> Funcion que realiza la conexion de cualquier servicio GET </b></p><br/>
	 * <ul><li></li></ul><br/>
	 * @author EAM <br/>
	 *         Jefry Londoño Acosta <br/>
	 *         Email: jjmb2789@gmail.com <br/>
	 *         4/05/2017
	 * @version 1.0
	 * @param urlRequest
	 */
	public String servicioGet(String urlRequest) {

		try {

			ClientRequest request = new ClientRequest(urlRequest);
			request.accept("application/json");
			ClientResponse<String> response = request.get(String.class);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}

			BufferedReader br = new BufferedReader(
					new InputStreamReader(new ByteArrayInputStream(response.getEntity().getBytes())));

			String output;

			String outputAuxiliar = "";

			System.out.println("Output from Server .... \n");

			while ((output = br.readLine()) != null) {

				outputAuxiliar += output;
				// System.out.println(output);
			}

			/*
			 * Parte la cadena para obtener solo el objeto
			 */
			outputAuxiliar = organizarCadena(outputAuxiliar);

			return outputAuxiliar;

		} catch (ClientProtocolException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();

		}
		
		return null;

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
	public String organizarCadena(String outputAuxiliar) {

		outputAuxiliar = ((outputAuxiliar.split("\"response\":"))[1]).substring(0,
				((outputAuxiliar.split("\"response\":"))[1]).length() - 1);

		outputAuxiliar = outputAuxiliar.replaceAll("\\[", " ");
		outputAuxiliar = outputAuxiliar.replaceAll("\\]", " ");

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
