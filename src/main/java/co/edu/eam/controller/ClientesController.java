package co.edu.eam.controller;

import co.edu.eam.dto.ClienteCRM;
import co.edu.eam.dto.ClienteDTO;
import co.edu.eam.dto.ContactoDTO;
import co.edu.eam.dto.IdDTO;
import co.edu.eam.dto.IdentificacionDTO;
import co.edu.eam.dto.PersonaDTO;
import co.edu.eam.dto.UbicacionDTO;
import co.edu.eam.model.Clientes;
import co.edu.eam.orquestador.RestCliente;
import co.edu.eam.servicesCliente.Cliente;

public class ClientesController {

	RestCliente servicio = new RestCliente();

	ServicesPostController post = new ServicesPostController();
	
	/**
	 * 
	 * <p><b> Crea un cliente en el CRM y en la base de datos local </b></p><br/>
	 * <ul><li></li></ul><br/>
	 * @author EAM <br/>
	 *         Jefry Londoño Acosta <br/>
	 *         Email: jjmb2789@gmail.com <br/>
	 *         14/05/2017
	 * @version 1.0
	 * @param numero
	 * @param tipoDocumento
	 * @param nombres
	 * @param apellido
	 * @param genero
	 * @param edad
	 * @param correo
	 * @param telefono
	 * @param pais
	 * @param departamento
	 * @param ciudad
	 * @param direccion
	 * @return
	 * @throws Exception 
	 */
	public String crearCliente(String numero, String tipoDocumento, String nombres, String apellido, String genero,
			String edad, String correo, String telefono, String pais, String departamento, String ciudad,
			String direccion) throws Exception {

		/*
		 * Objeto DTO para la creacion de la identificacion del cliente
		 */
		IdentificacionDTO identificacion = new IdentificacionDTO();

		identificacion.setNumero(numero);
		identificacion.setTipoDocumento(tipoDocumento);

		/*
		 * Objeto DTO para la creacion de los datos de la persona
		 */
		PersonaDTO persona = new PersonaDTO();

		persona.setNombres(nombres);
		persona.setApellido(apellido);
		persona.setGenero(genero);
		persona.setEdad(edad);

		/*
		 * Objeto DTO para la creacion de los datos de contacto
		 */
		ContactoDTO contacto = new ContactoDTO();

		contacto.setCorreo(correo);
		contacto.setTelefono(telefono);

		/*
		 * Objeto DTO para la creacion de los datos de ubicacion
		 */
		UbicacionDTO ubicacion = new UbicacionDTO();

		ubicacion.setPais(pais);
		ubicacion.setDepartamento(departamento);
		ubicacion.setCiudad(ciudad);
		ubicacion.setDireccion(direccion);

		/*
		 * Objeto DTO para la creacion del cliente
		 */
		ClienteDTO clienteDto = new ClienteDTO();

		clienteDto.setIdentificacion(identificacion);
		clienteDto.setPersona(persona);
		clienteDto.setContacto(contacto);
		clienteDto.setUbicacion(ubicacion);

		/*
		 * Objeto CRM que se enviara al servicio
		 */
		ClienteCRM cliente = new ClienteCRM();

		cliente.setCliente(clienteDto);

		/*
		 * Llama el Controlador que invoca el servicio
		 */

		ClienteCRM clienteCRM = servicio.servicioCrearClientes(cliente);
		
		System.out.println("Creó cliente en crm");
		
		System.out.println(clienteCRM.getCliente().getPersona().getApellido());

		if (clienteCRM != null) {

			return post.servicioPostCrearCliente(numero, clienteCRM.getCliente().getId().getId());
			// servicio.prueba();

		}

		return null;

	}
	
	/**
	 * 
	 * <p><b> Busca un cliente en el CRM </b></p><br/>
	 * <ul><li></li></ul><br/>
	 * @author EAM <br/>
	 *         Jefry Londoño Acosta <br/>
	 *         Email: jjmb2789@gmail.com <br/>
	 *         14/05/2017
	 * @version 1.0
	 * @param cedula
	 * @return
	 */
	public ClienteCRM buscarCliente(String cedula) throws Exception{
		
		
		ClienteCRM respuesta;
		
		/*
		 * Busca un cliente con numero de cedula en la base de datos
		 */
		Cliente client = post.servicioPostBuscarCliente(cedula);
		
		System.out.println("cliente de base de datos"+client.getCedula()+ ", "+ client.getIdCrm());

		if (client != null) {
			
			System.out.println("entreal if para servicio rest");
			
			/*
			 * Busca un cliente con el id del crm en el servicio del CRM
			 */
			System.out.println("antesdelserviico");
			respuesta = servicio.servicioBuscarClientes(client.getIdCrm());
			respuesta.setId(client.getId());
			respuesta.getCliente().setId(new IdDTO());
			respuesta.getCliente().getId().setId(client.getIdCrm());
			
			System.out.println(respuesta.getCliente().getId().getId() + "  ids");
			
			return respuesta;

		}
		
		return null;

	}

}
