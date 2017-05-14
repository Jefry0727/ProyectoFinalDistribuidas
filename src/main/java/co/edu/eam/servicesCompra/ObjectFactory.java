
package co.edu.eam.servicesCompra;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the distribuidos.ingsoft.eam.edu.co package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GeneraIdResponse_QNAME = new QName("http://co.edu.eam.ingsoft.distribuidos", "generaIdResponse");
    private final static QName _GeneraId_QNAME = new QName("http://co.edu.eam.ingsoft.distribuidos", "generaId");
    private final static QName _OperacionCrearCompra_QNAME = new QName("http://co.edu.eam.ingsoft.distribuidos", "operacionCrearCompra");
    private final static QName _OperacionCrearCompraResponse_QNAME = new QName("http://co.edu.eam.ingsoft.distribuidos", "operacionCrearCompraResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: distribuidos.ingsoft.eam.edu.co
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GeneraIdResponse }
     * 
     */
    public GeneraIdResponse createGeneraIdResponse() {
        return new GeneraIdResponse();
    }

    /**
     * Create an instance of {@link GeneraId }
     * 
     */
    public GeneraId createGeneraId() {
        return new GeneraId();
    }

    /**
     * Create an instance of {@link OperacionCrearCompra }
     * 
     */
    public OperacionCrearCompra createOperacionCrearCompra() {
        return new OperacionCrearCompra();
    }

    /**
     * Create an instance of {@link OperacionCrearCompraResponse }
     * 
     */
    public OperacionCrearCompraResponse createOperacionCrearCompraResponse() {
        return new OperacionCrearCompraResponse();
    }

    /**
     * Create an instance of {@link ItemsDTO }
     * 
     */
    public ItemsDTO createItemsDTO() {
        return new ItemsDTO();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeneraIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://co.edu.eam.ingsoft.distribuidos", name = "generaIdResponse")
    public JAXBElement<GeneraIdResponse> createGeneraIdResponse(GeneraIdResponse value) {
        return new JAXBElement<GeneraIdResponse>(_GeneraIdResponse_QNAME, GeneraIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GeneraId }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://co.edu.eam.ingsoft.distribuidos", name = "generaId")
    public JAXBElement<GeneraId> createGeneraId(GeneraId value) {
        return new JAXBElement<GeneraId>(_GeneraId_QNAME, GeneraId.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperacionCrearCompra }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://co.edu.eam.ingsoft.distribuidos", name = "operacionCrearCompra")
    public JAXBElement<OperacionCrearCompra> createOperacionCrearCompra(OperacionCrearCompra value) {
        return new JAXBElement<OperacionCrearCompra>(_OperacionCrearCompra_QNAME, OperacionCrearCompra.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperacionCrearCompraResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://co.edu.eam.ingsoft.distribuidos", name = "operacionCrearCompraResponse")
    public JAXBElement<OperacionCrearCompraResponse> createOperacionCrearCompraResponse(OperacionCrearCompraResponse value) {
        return new JAXBElement<OperacionCrearCompraResponse>(_OperacionCrearCompraResponse_QNAME, OperacionCrearCompraResponse.class, null, value);
    }

}
