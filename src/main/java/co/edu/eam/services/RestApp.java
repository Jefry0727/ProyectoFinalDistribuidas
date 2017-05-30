/**
 * 
 */
package co.edu.eam.services;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import co.edu.eam.controller.ClientesController;
import co.edu.eam.controller.PagoController;
import co.edu.eam.controller.ProductoController;
import co.edu.eam.dto.ClienteCRM;
import co.edu.eam.dto.IdentificacionDTO;
import co.edu.eam.dto.PaymentDTO;
import co.edu.eam.dto.ProductoAmz;
import co.edu.eam.model.ClienteResponse;
import co.edu.eam.model.Clientes;
import co.edu.eam.model.Producto;
import co.edu.eam.model.Response;
import co.edu.eam.model.Tarjeta;
import javassist.bytecode.stackmap.BasicBlock.Catch;
//import co.edu.eam.servicesCompra.ItemsDTO;

/**
 * @author Alvaro lotero <lotero021095@gmail.com> @12/05/2017
 * @version
 */
@Path("/restApp")
public class RestApp {

	ClientesController clienteController = new ClientesController();

	PagoController pagoController = new PagoController();

	ProductoController productoController = new ProductoController();

	/**
	 * 
	 * <p>
	 * <b> Servicio crear cliente que se expone, tipo REST para el GUI </b>
	 * </p>
	 * <br/>
	 * <ul>
	 * <li></li>
	 * </ul>
	 * <br/>
	 * 
	 * @author EAM <br/>
	 *         Alvaro lotero <br/>
	 *         Email: lotero021095@gmail.com <br/>
	 *         12/05/2017
	 * @version 1.0
	 * @param cliente
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/crearCliente")
	public Response restCrearCliente(Clientes cliente) {

		System.out.println("crear cliente");

		try {
			String servicio = clienteController.crearCliente(cliente.getNumero(), cliente.getTipoDocumento(),
					cliente.getNombres(), cliente.getApellido(), cliente.getGenero(), cliente.getEdad(),
					cliente.getCorreo(), cliente.getTelefono(), cliente.getPais(), cliente.getDepartamento(),
					cliente.getCiudad(), cliente.getDireccion());
			System.out.println("Respuesta de guardar ----");
			System.out.println(servicio);

			Response respuesta = new Response();

			respuesta.setRespuesta(servicio);

			return respuesta;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			return null;
		}

	}

	/**
	 * 
	 * <p>
	 * <b> Servicio buscar cliente que se expone, tipo REST para el GUI </b>
	 * </p>
	 * <br/>
	 * <ul>
	 * <li></li>
	 * </ul>
	 * <br/>
	 * 
	 * @author EAM <br/>
	 *         Alvaro lotero <br/>
	 *         Email: lotero021095@gmail.com <br/>
	 *         12/05/2017
	 * @version 1.0
	 * @param cedula
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/buscarCliente")
	public ClienteResponse restBuscarCliente(@QueryParam(value = "cedula") String cedula) {

		try {
			ClientesController clienteController = new ClientesController();

			System.out.println(cedula);

			ClienteCRM cliente;

			cliente = clienteController.buscarCliente(cedula);

			System.out.println(cliente.getCliente().getPersona().getApellido() + " el apellido");

			System.out.println("Final");

			if (cliente != null) {

				Clientes respuesta = new Clientes();

				respuesta.setIdCrm(cliente.getCliente().getId().getId());
				respuesta.setId(cliente.getId()+"");
				respuesta.setApellido(cliente.getCliente().getPersona().getApellido());
				respuesta.setCiudad(cliente.getCliente().getUbicacion().getCiudad());
				respuesta.setCorreo(cliente.getCliente().getContacto().getCorreo());
				respuesta.setDepartamento(cliente.getCliente().getUbicacion().getDepartamento());
				respuesta.setDireccion(cliente.getCliente().getUbicacion().getDireccion());
				respuesta.setEdad(cliente.getCliente().getPersona().getEdad());
				respuesta.setGenero(cliente.getCliente().getPersona().getGenero());
				respuesta.setNombres(cliente.getCliente().getPersona().getNombres());

				cliente.getCliente().setIdentificacion(new IdentificacionDTO());
				cliente.getCliente().getIdentificacion().setNumero(cedula);

				respuesta.setNumero(cliente.getCliente().getIdentificacion().getNumero());
				respuesta.setPais(cliente.getCliente().getUbicacion().getPais());
				respuesta.setTelefono(cliente.getCliente().getContacto().getTelefono());
				respuesta.setTipoDocumento(cliente.getCliente().getIdentificacion().getTipoDocumento());

				ClienteResponse response = new ClienteResponse();

				response.setCliente(respuesta);

				return response;

			}

		} catch (Exception e) {

			e.printStackTrace();
			return null;

		}
		return null;

	}

	/**
	 * 
	 * <p>
	 * <b> Busca un producto con el id del mismo </b>
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
	 * @param id
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/buscarProductoId")
	public Producto restBuscarProductoId(@QueryParam(value = "idProducto") String id) {

		ProductoAmz producto = productoController.buscarProductoPorId(id);

		if (producto != null) {

			Producto resultado = new Producto();

			resultado.setDescripcion(producto.getProducto().getDescripcion().getDescripcion());
			resultado.setId(producto.getProducto().getDescripcion().getId());
			resultado.setImagen_grande(producto.getProducto().getImagenes().getImagenGrande());
			resultado.setImagen_media(producto.getProducto().getImagenes().getImagenMediana());
			resultado.setImagen_pequenia(producto.getProducto().getImagenes().getImagenPequenia());
			resultado.setMarca(producto.getProducto().getDescripcion().getMarca());
			resultado.setNombre(producto.getProducto().getDescripcion().getNombre());
			resultado.setTitulo(producto.getProducto().getDescripcion().getTitulo());
			resultado.setValor(Double.parseDouble(producto.getProducto().getCosto().getValor()));

			return resultado;

		}

		return null;

	}

	/**
	 * 
	 * <p>
	 * <b> Busca productos por nombre </b>
	 * </p>
	 * <br/>
	 * <ul>
	 * <li></li>
	 * </ul>
	 * <br/>
	 * 
	 * @author EAM <br/>
	 *         Alvaro lotero <br/>
	 *         Email: lotero021095@gmail.com <br/>
	 *         16/05/2017
	 * @version 1.0
	 * @param nombreProducto
	 * @return
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/buscarProductoNombre")
	public List<Producto> restBuscarProductoNombre(@QueryParam(value = "nombre") String nombreProducto) {
		try {

			ArrayList<ProductoAmz> lista = productoController.buscarProductoPorNombre(nombreProducto);

			List<Producto> respuesta = new LinkedList<Producto>();

			if (lista != null) {

				for (ProductoAmz producto : lista) {

					Producto resultado = new Producto();

					resultado.setDescripcion(producto.getProducto().getDescripcion().getDescripcion());
					resultado.setId(producto.getProducto().getDescripcion().getId());
					resultado.setImagen_grande(producto.getProducto().getImagenes().getImagenGrande());
					resultado.setImagen_media(producto.getProducto().getImagenes().getImagenMediana());
					resultado.setImagen_pequenia(producto.getProducto().getImagenes().getImagenPequenia());
					resultado.setMarca(producto.getProducto().getDescripcion().getMarca());
					resultado.setNombre(producto.getProducto().getDescripcion().getNombre());
					resultado.setTitulo(producto.getProducto().getDescripcion().getTitulo());
					resultado.setValor(Double.parseDouble(producto.getProducto().getCosto().getValor()));

					respuesta.add(resultado);

				}

				return respuesta;

			}

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;

	}

	/**
	 * 
	 * <p>
	 * <b> Servicio pagar que se expone, tipo REST para el GUI </b>
	 * </p>
	 * <br/>
	 * <ul>
	 * <li></li>
	 * </ul>
	 * <br/>
	 * 
	 * @author EAM <br/>
	 *         Alvaro lotero <br/>
	 *         Email: lotero021095@gmail.com <br/>
	 *         12/05/2017
	 * @version 1.0
	 * @param cliente
	 * @param tarjeta
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/realizarPago")
	public Response restPago(PaymentDTO pago) {

		Clientes cliente = pago.getCliente();
		Tarjeta tarjeta = pago.getTarjeta();
		
		System.out.println(pago.getCliente().getApellido());
		System.out.println(pago.getItemsCompra().size());
		System.out.println(pago.getTarjeta().getNombreTarjeta());
		System.out.println("valor");
		System.out.println(tarjeta.getValor());
		
		Response respuesta = new Response();
		
		respuesta.setRespuesta("OK");
		
		//

		 try {
			pagoController.realizarPago(cliente.getCorreo(), cliente.getTelefono(),cliente.getIdCrm(), cliente.getId(),
					cliente.getNumero(), cliente.getTipoDocumento(), cliente.getApellido(), cliente.getEdad(),
					cliente.getNombres(), cliente.getGenero(), cliente.getCiudad(), cliente.getCiudad(),
					cliente.getDireccion(), cliente.getPais(), tarjeta.getCiudadTarjeta(), tarjeta.getCodigoSeguridad(),
					tarjeta.getFechaVencimiento(), tarjeta.getMetodoPago(), tarjeta.getNombreTarjeta(),
					tarjeta.getNumeroTarjeta(), tarjeta.getValor(), pago.getItemsCompra());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 return respuesta;

	}

}
