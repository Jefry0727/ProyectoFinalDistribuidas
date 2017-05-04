package co.edu.eam.controller;

import co.edu.eam.dto.ClienteCRM;
import co.edu.eam.dto.ClienteDTO;
import co.edu.eam.dto.ContactoDTO;
import co.edu.eam.dto.IdentificacionDTO;
import co.edu.eam.dto.PersonaDTO;
import co.edu.eam.dto.UbicacionDTO;
import co.edu.eam.orquestador.RestCliente;

public class ClienteController {

	public void crearCliente(String numero, String tipoDocumento, String nombres, String apellido, String genero,
			String edad, String correo, String telefono, String pais, String departamento, String ciudad,
			String direccion) {

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
		RestCliente servicio = new RestCliente();
		
		servicio.servicioCrearCliente(cliente);
		
	

	}

}
