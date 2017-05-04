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
			String output2 = "";
			System.out.println("Output from Server .... \n");
			
			
			
			while ((output = br.readLine()) != null) {
				
				output2 += output;
				System.out.println(output);
			}
			String cadenaEjemplo = "{  \"code\": \"200\",  \"status\": \"Ok\",  \"response\": {    \"customer\": {      \"personal\": {        \"firstName\": \"maria\",        \"lastName\": \"Cano\",        \"sex\": \"F\"      },      \"social\": {        \"mail\": [          \"46gdd@hotmail.com\"        ],        \"cellNumber\": [          \"3214563363\"        ]      },      \"localization\": {        \"country\": \"Colombia\",        \"state\": \"Quindío\",        \"city\": \"Armenia\",        \"addressStreet\": \"Clle 13\"      },      \"ids\": {        \"id\": \"590aaed5d4b89d9f9\"      }    }  }}";
			System.out.println("ToString");
			System.out.println((output2.split("\"response\":"))[1]);
			

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		} catch (Exception e) {

			e.printStackTrace();

		}

	}
	
	
	public String createObjectToJson(Object objeto){
		
		ObjectMapper mapper = new ObjectMapper();

		try {
			String jsonInString = "";
			
			// Convert object to JSON string
			//String jsonInString = mapper.writeValueAsString(objeto);
			//System.out.println(jsonInString);

			// Convert object to JSON string and pretty print
			jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(objeto);
			System.out.println(jsonInString);
			
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

}
