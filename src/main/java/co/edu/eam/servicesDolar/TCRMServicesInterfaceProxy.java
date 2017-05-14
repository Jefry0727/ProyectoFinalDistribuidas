package co.edu.eam.servicesDolar;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.rpc.ServiceException;


public class TCRMServicesInterfaceProxy implements TCRMServicesInterface
{
	private String _endpoint = null;
	private TCRMServicesInterface tCRMServicesInterface = null;

	public TCRMServicesInterfaceProxy()
	{
		_initTCRMServicesInterfaceProxy();
	}

	public TCRMServicesInterfaceProxy(String endpoint)
	{
		_endpoint = endpoint;
		_initTCRMServicesInterfaceProxy();
	}

	private void _initTCRMServicesInterfaceProxy()
	{
            try {
                tCRMServicesInterface = (new TCRMServicesWebServiceLocator()).getTCRMServicesWebServicePort();
            } catch (ServiceException ex) {
                Logger.getLogger(TCRMServicesInterfaceProxy.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (tCRMServicesInterface != null)
            {
                if (_endpoint != null)
                    ((javax.xml.rpc.Stub) tCRMServicesInterface)._setProperty( "javax.xml.rpc.service.endpoint.address",_endpoint);
                else
                    _endpoint = (String) ((javax.xml.rpc.Stub) tCRMServicesInterface)._getProperty("javax.xml.rpc.service.endpoint.address");
            }
	}

	public String getEndpoint()
	{
		return _endpoint;
	}

	public void setEndpoint(String endpoint)
	{
		_endpoint = endpoint;
		if (tCRMServicesInterface != null)
			((javax.xml.rpc.Stub) tCRMServicesInterface)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);

	}

	public TCRMServicesInterface getTCRMServicesInterface()
	{
		if (tCRMServicesInterface == null)
			_initTCRMServicesInterfaceProxy();
		return tCRMServicesInterface;
	}

	public TcrmResponse queryTCRM( java.util.Calendar tcrmQueryAssociatedDate) throws java.rmi.RemoteException
	{
		if (tCRMServicesInterface == null)
			_initTCRMServicesInterfaceProxy();
		return tCRMServicesInterface.queryTCRM(tcrmQueryAssociatedDate);
	}

}