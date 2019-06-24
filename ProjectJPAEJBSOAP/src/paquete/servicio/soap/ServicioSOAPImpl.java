package paquete.servicio.soap;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

import paquete.entity.Persona;
import paquete.servicio.delegate.DelegateJpaEjbRest;

@Stateless
@WebService(name="NombreServidorSOAP", serviceName="ProjectJPAEJBSOAP", endpointInterface="paquete.servicio.soap.ServicioSOAP")
public class ServicioSOAPImpl implements ServicioSOAP {

	@WebMethod
	@Override
	public String getStatus() {
		
		Date fecha = new Date ();
		Locale currentLocale = new Locale("EN");
		DateFormat formato = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.MEDIUM, currentLocale);
		String output = formato.format(fecha);
		return output;
	}
	
	@WebMethod
	@Override
	public String sumar( int a, int b) {
		
		if (a==0 && b==0) {
			String mensaje = "Debe Introducir valores en las variables";
			return mensaje;
		} else {
			String mensaje = String.valueOf(a+b);
			return mensaje;
		}
	}

	@WebMethod
	@Override
	public List<Persona> extraerAll() {
		DelegateJpaEjbRest ejb = new DelegateJpaEjbRest();
		List<Persona> list = ejb.extraerAllEJBDelegate();
		return list;
	}
}
