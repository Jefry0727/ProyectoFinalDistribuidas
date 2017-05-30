/**
 * 
 */
package co.edu.eam.dto;

import java.util.LinkedList;

import co.edu.eam.model.Clientes;
import co.edu.eam.model.Tarjeta;


/**
 * @author Jefry Londoño <jjmb2789@gmail.com>
 * @15/05/2017
 * @version 
 */
public class PaymentDTO {
	
	private Clientes cliente;
	private Tarjeta tarjeta;
	private LinkedList<ItemDTO> itemsCompra;
	
	/**
	 * @return the cliente
	 */
	public Clientes getCliente() {
		return cliente;
	}
	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}
	/**
	 * @return the tarjeta
	 */
	public Tarjeta getTarjeta() {
		return tarjeta;
	}
	/**
	 * @param tarjeta the tarjeta to set
	 */
	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}
	/**
	 * @return the itemsCompra
	 */
	public LinkedList<ItemDTO> getItemsCompra() {
		return itemsCompra;
	}
	/**
	 * @param itemsCompra the itemsCompra to set
	 */
	public void setItemsCompra(LinkedList<ItemDTO> itemsCompra) {
		this.itemsCompra = itemsCompra;
	}
	
	
	
	

}
