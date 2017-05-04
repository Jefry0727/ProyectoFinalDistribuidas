package co.edu.eam.orquestador;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientResponse;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.edu.eam.dto.ClienteCRM;
import co.edu.eam.model.Prueba;

public class RestCliente {

	
	/**
	 * Invoca el servicio de CRM Para craer un cliente
	 * <p><b> </b></p><br/>
	 * <ul><li></li></ul><br/>
	 * @author EAM <br/>
	 *         Jefry Londoño Acosta <br/>
	 *         Email: jjmb2789@gmail.com <br/>
	 *         4/05/2017
	 * @version 1.0
	 * @param objeto
	 */
	public void servicioCrearCliente(ClienteCRM objeto) {

		try {
			/*
			 * Conexion al servicio rest
			 */
			ClientRequest request = new ClientRequest("http://104.155.149.197:8090/tienda/espocrm/createCustomer");
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
			 * Parte la cadena para obtener solo el objeto
			 */
			outputAuxiliar = ((outputAuxiliar.split("\"response\":"))[1]).substring(0,
					((outputAuxiliar.split("\"response\":"))[1]).length() - 1);

			outputAuxiliar = outputAuxiliar.replaceAll("\\[", " ");
			outputAuxiliar = outputAuxiliar.replaceAll("\\]", " ");
			
			ClienteCRM respuesta = (ClienteCRM)createJsonToObject(outputAuxiliar, new ClienteCRM());
			

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}
	
	/**
	 * Crea un Objeto a partir de un Json
	 * <p><b> </b></p><br/>
	 * <ul><li></li></ul><br/>
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
	 * Crea un Json en el objeto deseado
	 * <p><b> </b></p><br/>
	 * <ul><li></li></ul><br/>
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
