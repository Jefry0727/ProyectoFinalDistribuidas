package co.edu.eam.orquestador;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.edu.eam.controller.ClienteController;
import co.edu.eam.dto.ClienteCRM;
import co.edu.eam.model.Prueba;
import co.edu.eam.model.PruebaPadre;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	
    	ClienteController c = new ClienteController();
    	//590bf872a92aceb86 , 590aaed5d4b89d9f9
    	c.buscarCliente("590bf872a92aceb86");
    	//c.crearCliente("2323232", "CC", "Alvaro Andres", "Giraldo", "M", "28", "dfr34@hotmail.com", "3214457363", "Colombia", "Quindío", "Armenia", "Clle 13");
//    	App obj = new App();
//		obj.run2();
    }
    
    private void run() {

		Prueba staff = createDummyObject();

			// Convert object to JSON string and save into a file directly
			//mapper.writeValue(new File("D:\\staff.json"), staff);
			String jsonInString = "";
			// Convert object to JSON string
			//String jsonInString = mapper.writeValueAsString(staff);
			System.out.println(jsonInString);

			// Convert object to JSON string and pretty print
			jsonInString = createObjectToJson(staff);
			System.out.println(jsonInString);

		
	}

	private Prueba createDummyObject() {

		Prueba staff = new Prueba();

		staff.setNombre("mkyong");
		staff.setEdad(33);
		staff.setPosicion("Developer");
		staff.setSalario(new BigDecimal("7500"));

		List<String> skills = new ArrayList<String>();
		skills.add("java");
		skills.add("python");

		staff.setHabilidades(skills);

		return staff;

	}
	
	
	private void run2() {
		ObjectMapper mapper = new ObjectMapper();

		try {

			// Convert JSON string from file to Object
//			Prueba staff = mapper.readValue(new File("D:\\staff.json"), Prueba.class);
//			System.out.println(staff);

			// Convert JSON string to Object
			String jsonInString = "{ \"test\": {\"name\":\"mkyong\",\"salary\":7500,\"skills\":[\"java\",\"python\"], \"personal\": {        \"firstName\": \"maria\",        \"lastName\": \"Cano\",        \"sex\": \"F\"      }}}";
			PruebaPadre staff1 = mapper.readValue(jsonInString, PruebaPadre.class);
			System.out.println(jsonInString);
			System.out.println(staff1.getPrueba() );

			//Pretty print
			String prettyStaff1 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(staff1);
			System.out.println(prettyStaff1);

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
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
