
package co.edu.eam.servicesCompra;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para itemsDTO complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="itemsDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cantidad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idProducto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="valorProducto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "itemsDTO", propOrder = {
    "cantidad",
    "idProducto",
    "valorProducto"
})
public class ItemsDTO {

    protected String cantidad;
    protected String idProducto;
    protected String valorProducto;

    /**
     * Obtiene el valor de la propiedad cantidad.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCantidad() {
        return cantidad;
    }

    /**
     * Define el valor de la propiedad cantidad.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCantidad(String value) {
        this.cantidad = value;
    }

    /**
     * Obtiene el valor de la propiedad idProducto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdProducto() {
        return idProducto;
    }

    /**
     * Define el valor de la propiedad idProducto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdProducto(String value) {
        this.idProducto = value;
    }

    /**
     * Obtiene el valor de la propiedad valorProducto.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValorProducto() {
        return valorProducto;
    }

    /**
     * Define el valor de la propiedad valorProducto.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValorProducto(String value) {
        this.valorProducto = value;
    }

}
