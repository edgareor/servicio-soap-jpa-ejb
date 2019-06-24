package paquete.servicio.soap;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import paquete.entity.Persona;

@WebService
public interface ServicioSOAP {

	@WebMethod
	public String getStatus();
	
	@WebMethod
	public String sumar(int a, int b);
	
	@WebMethod
	public List<Persona> extraerAll();

}
