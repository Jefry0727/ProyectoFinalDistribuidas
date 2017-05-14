
package co.edu.eam.servicesCompra;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para operacionCrearCompra complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="operacionCrearCompra">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id_Cliente" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="valor_total" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="items_compra" type="{http://co.edu.eam.ingsoft.distribuidos}itemsDTO" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "operacionCrearCompra", propOrder = {
    "idCliente",
    "valorTotal",
    "itemsCompra"
})
public class OperacionCrearCompra {

    @XmlElement(name = "id_Cliente")
    protected int idCliente;
    @XmlElement(name = "valor_total")
    protected double valorTotal;
    @XmlElement(name = "items_compra")
    protected List<ItemsDTO> itemsCompra;

    /**
     * Obtiene el valor de la propiedad idCliente.
     * 
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * Define el valor de la propiedad idCliente.
     * 
     */
    public void setIdCliente(int value) {
        this.idCliente = value;
    }

    /**
     * Obtiene el valor de la propiedad valorTotal.
     * 
     */
    public double getValorTotal() {
        return valorTotal;
    }

    /**
     * Define el valor de la propiedad valorTotal.
     * 
     */
    public void setValorTotal(double value) {
        this.valorTotal = value;
    }

    /**
     * Gets the value of the itemsCompra property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the itemsCompra property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getItemsCompra().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ItemsDTO }
     * 
     * 
     */
    public List<ItemsDTO> getItemsCompra() {
        if (itemsCompra == null) {
            itemsCompra = new ArrayList<ItemsDTO>();
        }
        return this.itemsCompra;
    }

}
