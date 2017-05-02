package co.edu.eam.orquestador;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.edu.eam.model.Prueba;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	App obj = new App();
		obj.run2();
    }
    
    private void run() {
		ObjectMapper mapper = new ObjectMapper();

		Prueba staff = createDummyObject();

		try {
			// Convert object to JSON string and save into a file directly
			//mapper.writeValue(new File("D:\\staff.json"), staff);

			// Convert object to JSON string
			String jsonInString = mapper.writeValueAsString(staff);
			System.out.println(jsonInString);

			// Convert object to JSON string and pretty print
			jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(staff);
			System.out.println(jsonInString);

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
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
			String jsonInString = "{\"name\":\"mkyong\",\"salary\":7500,\"skills\":[\"java\",\"python\"]}";
			Prueba staff1 = mapper.readValue(jsonInString, Prueba.class);
			System.out.println(staff1.getNombre() +" "+ staff1.getEdad()+" "+ staff1.getPosicion()+" "+staff1.getHabilidades()+" "+staff1.getSalario());

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

}
