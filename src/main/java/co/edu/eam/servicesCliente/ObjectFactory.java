
package co.edu.eam.servicesCliente;

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

    private final static QName _OperacionCrear_QNAME = new QName("http://co.edu.eam.ingsoft.distribuidos", "operacionCrear");
    private final static QName _OperacionBuscar_QNAME = new QName("http://co.edu.eam.ingsoft.distribuidos", "operacionBuscar");
    private final static QName _OperacionBuscarResponse_QNAME = new QName("http://co.edu.eam.ingsoft.distribuidos", "operacionBuscarResponse");
    private final static QName _OperacionCrearResponse_QNAME = new QName("http://co.edu.eam.ingsoft.distribuidos", "operacionCrearResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: distribuidos.ingsoft.eam.edu.co
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link OperacionCrear }
     * 
     */
    public OperacionCrear createOperacionCrear() {
        return new OperacionCrear();
    }

    /**
     * Create an instance of {@link OperacionBuscar }
     * 
     */
    public OperacionBuscar createOperacionBuscar() {
        return new OperacionBuscar();
    }

    /**
     * Create an instance of {@link OperacionBuscarResponse }
     * 
     */
    public OperacionBuscarResponse createOperacionBuscarResponse() {
        return new OperacionBuscarResponse();
    }

    /**
     * Create an instance of {@link OperacionCrearResponse }
     * 
     */
    public OperacionCrearResponse createOperacionCrearResponse() {
        return new OperacionCrearResponse();
    }

    /**
     * Create an instance of {@link Cliente }
     * 
     */
    public Cliente createCliente() {
        return new Cliente();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperacionCrear }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://co.edu.eam.ingsoft.distribuidos", name = "operacionCrear")
    public JAXBElement<OperacionCrear> createOperacionCrear(OperacionCrear value) {
        return new JAXBElement<OperacionCrear>(_OperacionCrear_QNAME, OperacionCrear.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperacionBuscar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://co.edu.eam.ingsoft.distribuidos", name = "operacionBuscar")
    public JAXBElement<OperacionBuscar> createOperacionBuscar(OperacionBuscar value) {
        return new JAXBElement<OperacionBuscar>(_OperacionBuscar_QNAME, OperacionBuscar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperacionBuscarResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://co.edu.eam.ingsoft.distribuidos", name = "operacionBuscarResponse")
    public JAXBElement<OperacionBuscarResponse> createOperacionBuscarResponse(OperacionBuscarResponse value) {
        return new JAXBElement<OperacionBuscarResponse>(_OperacionBuscarResponse_QNAME, OperacionBuscarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OperacionCrearResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://co.edu.eam.ingsoft.distribuidos", name = "operacionCrearResponse")
    public JAXBElement<OperacionCrearResponse> createOperacionCrearResponse(OperacionCrearResponse value) {
        return new JAXBElement<OperacionCrearResponse>(_OperacionCrearResponse_QNAME, OperacionCrearResponse.class, null, value);
    }

}
