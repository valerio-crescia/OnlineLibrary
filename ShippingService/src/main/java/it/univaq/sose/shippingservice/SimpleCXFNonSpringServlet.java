package it.univaq.sose.shippingservice;

import javax.servlet.ServletConfig;
import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.transport.servlet.CXFNonSpringServlet;

import it.univaq.sose.shippingservice.api.ShippingSoapApiImpl;

public class SimpleCXFNonSpringServlet extends CXFNonSpringServlet{
	private static final long serialVersionUID = 5976105248644843342L;

	@Override
	public void loadBus(ServletConfig servletConfig) {
		super.loadBus(servletConfig);
		Bus bus = getBus();
		BusFactory.setDefaultBus(bus);
		Endpoint.publish("/message", new ShippingSoapApiImpl());
		
	}

}
