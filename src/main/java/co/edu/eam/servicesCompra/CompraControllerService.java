
package co.edu.eam.servicesCompra;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.8
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "CompraControllerService", targetNamespace = "http://co.edu.eam.ingsoft.distribuidos", wsdlLocation = "http://localhost:8089/servicio_soap/CompraController?wsdl")
public class CompraControllerService
    extends Service
{

    private final static URL COMPRACONTROLLERSERVICE_WSDL_LOCATION;
    private final static WebServiceException COMPRACONTROLLERSERVICE_EXCEPTION;
    private final static QName COMPRACONTROLLERSERVICE_QNAME = new QName("http://co.edu.eam.ingsoft.distribuidos", "CompraControllerService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8089/servicio_soap/CompraController?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        COMPRACONTROLLERSERVICE_WSDL_LOCATION = url;
        COMPRACONTROLLERSERVICE_EXCEPTION = e;
    }

    public CompraControllerService() {
        super(__getWsdlLocation(), COMPRACONTROLLERSERVICE_QNAME);
    }

    public CompraControllerService(WebServiceFeature... features) {
        super(__getWsdlLocation(), COMPRACONTROLLERSERVICE_QNAME, features);
    }

    public CompraControllerService(URL wsdlLocation) {
        super(wsdlLocation, COMPRACONTROLLERSERVICE_QNAME);
    }

    public CompraControllerService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, COMPRACONTROLLERSERVICE_QNAME, features);
    }

    public CompraControllerService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CompraControllerService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns CompraController
     */
    @WebEndpoint(name = "CompraCtlPort")
    public CompraController getCompraCtlPort() {
        return super.getPort(new QName("http://co.edu.eam.ingsoft.distribuidos", "CompraCtlPort"), CompraController.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CompraController
     */
    @WebEndpoint(name = "CompraCtlPort")
    public CompraController getCompraCtlPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://co.edu.eam.ingsoft.distribuidos", "CompraCtlPort"), CompraController.class, features);
    }

    private static URL __getWsdlLocation() {
        if (COMPRACONTROLLERSERVICE_EXCEPTION!= null) {
            throw COMPRACONTROLLERSERVICE_EXCEPTION;
        }
        return COMPRACONTROLLERSERVICE_WSDL_LOCATION;
    }

}
