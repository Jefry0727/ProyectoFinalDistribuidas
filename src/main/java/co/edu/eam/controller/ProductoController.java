/**
 * 
 */
package co.edu.eam.controller;

import java.awt.List;
import java.util.ArrayList;
import java.util.LinkedList;

import co.edu.eam.dto.CostoDTO;
import co.edu.eam.dto.ProductoAmz;
import co.edu.eam.dto.ProductosAmz;
import co.edu.eam.orquestador.RestCliente;

/**
 * @author Jefry Londoño <jjmb2789@gmail.com> @5/05/2017
 * @version
 */
public class ProductoController {

	RestCliente servicio = new RestCliente();

	/**
	 * 
	 * <p>
	 * <b> Busca un producto por id en amazon </b>
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
	 *         15/05/2017
	 * @version 1.0
	 * @param id
	 * @return
	 */
	public ProductoAmz buscarProductoPorId(String id) {

		ProductoAmz resultado = servicio.servicioBuscarProducto(id);

		if (resultado != null) {

			double conversor = ((servicio.servicioDolar()
					* (Double.parseDouble(resultado.getProducto().getCosto().getValor()))));

			resultado.getProducto().getCosto().setValor("" + conversor);

			return resultado;

		}

		return null;

	}

	/**
	 * 
	 * <p>
	 * <b> </b>
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
	 * @param nombreProducto
	 * @return
	 */
	public ArrayList<ProductoAmz> buscarProductoPorNombre(String nombreProducto) throws Exception {

		ProductosAmz respuesta = servicio.servicioBuscarProductoNombre(nombreProducto, "0");

		if (respuesta != null) {

			System.out.println("Entre al if Buscar Product");

			ArrayList<ProductoAmz> lista = (ArrayList<ProductoAmz>) respuesta.getProductos();

			double valorDolar = servicio.servicioDolar();

			System.out.println(lista.get(1).getProducto().getCosto().getValor());

			for (ProductoAmz productoAmz : lista) {

				if (productoAmz.getProducto().getCosto().getValor() != null) {

					String cadena = (productoAmz.getProducto().getCosto().getValor()).replaceAll("\\$", " ");

					double aux = Double.parseDouble(cadena.replaceAll(",", ""));

					System.out.println("replaceALL");

					
					System.out.println("igual "+ (aux * valorDolar));

					productoAmz.getProducto().getCosto().setValor("" + (aux * valorDolar));

				} else {

					productoAmz.getProducto().getCosto().setValor("0.0");

				}

				System.out.println("calcule el valor");
			}

			return lista;

		}

		return null;
	}

}
