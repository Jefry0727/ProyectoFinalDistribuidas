/**
 * 
 */
package co.edu.eam.controller;

import java.util.LinkedList;

import co.edu.eam.dto.ClienteDTO;
import co.edu.eam.dto.ContactoDTO;
import co.edu.eam.dto.IdDTO;
import co.edu.eam.dto.IdentificacionDTO;
import co.edu.eam.dto.ItemDTO;
import co.edu.eam.dto.PagoDTO;
import co.edu.eam.dto.PagosPayu;
import co.edu.eam.dto.PersonaDTO;
import co.edu.eam.dto.TarjetaDTO;
import co.edu.eam.dto.UbicacionDTO;
import co.edu.eam.dto.ValorDTO;
import co.edu.eam.orquestador.RestCliente;


/**
 * @author Jefry Londoño <jjmb2789@gmail.com> @6/05/2017
 * @version
 */
public class PagoController {

	RestCliente servicio = new RestCliente();
	
	ServicesPostController post = new ServicesPostController();
	
	/**
	 * 
	 * <p><b> Metodo que realiza el pago de un producto </b></p><br/>
	 * <ul><li></li></ul><br/>
	 * @author EAM <br/>
	 *         Alvaro lotero <br/>
	 *         Email: lotero021095@gmail.com <br/>
	 *         12/05/2017
	 * @version 1.0
	 * @param correo
	 * @param telefono
	 * @param id
	 * @param numero_documento
	 * @param tipoDocumento
	 * @param apellido
	 * @param edad
	 * @param nombres
	 * @param genero
	 * @param ciudad
	 * @param departamento
	 * @param direccion
	 * @param pais
	 * @param ciudadTarjeta
	 * @param codigoSeguridad
	 * @param fechaVencimiento
	 * @param metodoPago
	 * @param nombreTarjeta
	 * @param numeroTarjeta
	 * @param valor
	 */
	public boolean realizarPago(String correo, String telefono,String idCrm, String id, String numero_documento, String tipoDocumento,
			String apellido, String edad, String nombres, String genero, String ciudad, String departamento,
			String direccion, String pais, String ciudadTarjeta, String codigoSeguridad, String fechaVencimiento,
			String metodoPago, String nombreTarjeta, String numeroTarjeta, double valor,LinkedList<ItemDTO>itemsCompra) throws Exception{

		PagosPayu pagos = new PagosPayu();

		/*
		 * Se crea el Contacto DTO
		 */
		ContactoDTO contacto = new ContactoDTO();
		contacto.setCorreo(correo);
		contacto.setTelefono(telefono);

		IdDTO idDto = new IdDTO();
		idDto.setId(idCrm);

		/*
		 * Se crea la IdentificacionDTO
		 */
		IdentificacionDTO identificacion = new IdentificacionDTO();

		identificacion.setNumero(numero_documento);
		identificacion.setTipoDocumento(tipoDocumento);

		/*
		 * Se Crea PersonaDTO
		 */
		PersonaDTO persona = new PersonaDTO();

		persona.setNombres(nombres);
		persona.setApellido(apellido);
		persona.setEdad(edad);
		persona.setGenero(genero);

		/*
		 * Se crea la UbicacionDTO
		 */
		UbicacionDTO ubicacion = new UbicacionDTO();

		ubicacion.setCiudad(ciudad);
		ubicacion.setDepartamento(departamento);
		ubicacion.setDireccion(direccion);
		ubicacion.setPais(pais);

		/*
		 * Se crea el ClienteDTO
		 */
		ClienteDTO cliente = new ClienteDTO();

		cliente.setContacto(contacto);
		cliente.setId(idDto);
		cliente.setIdentificacion(identificacion);
		cliente.setPersona(persona);
		cliente.setUbicacion(ubicacion);
		
		/*
		 * Crear TarjetaDTO
		 */
		TarjetaDTO tarjeta = new TarjetaDTO();

		tarjeta.setCiudad(ciudadTarjeta);
		tarjeta.setCodigoSeguridad(codigoSeguridad);
		tarjeta.setFechaVencimiento(fechaVencimiento);
		tarjeta.setMetodoPago(metodoPago);
		tarjeta.setNombre(nombreTarjeta);
		tarjeta.setNumeroTarjeta(numeroTarjeta);
		
		ValorDTO valorDto = new ValorDTO();
		
		System.out.println(valor);
		
		int aux = (int) valor;
		
		System.out.println(aux);
		
		valorDto.setValor(aux);

		/*
		 * Se crea el PagoDTO
		 */
		PagoDTO pagodto = new PagoDTO();
		
		pagodto.setCliente(cliente);
		pagodto.setTarjeta(tarjeta);
		pagodto.setValor(valorDto);
		

		pagos.setPagos(pagodto);

		PagosPayu respuesta = servicio.servicioRealizarPago(pagos);
		
		System.out.println("Estado de pago.....");
		
		System.out.println(respuesta.getPagos().getEstado());
		
		if(respuesta != null){
			
			return validarCompra(respuesta, id, valor, itemsCompra);
			
		}
		
		return false;
		

	}
	
	
	
	public boolean validarCompra(PagosPayu pago, String idCliente, double valorTotal,LinkedList<ItemDTO>itemsCompra) throws Exception{
		//DECLINED 
		if(pago.getPagos().getEstado().equals("APPROVED")){
			
			return post.servicioPostCompra(Integer.parseInt(idCliente), valorTotal, itemsCompra);
			
		}
		
		return false;
		
		
	}

}
