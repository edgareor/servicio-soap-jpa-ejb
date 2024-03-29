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

	@WebMethod
	public abstract Persona extraerPorId(Persona paramPersona);

	@WebMethod
	public abstract int extraerMax();

	@WebMethod
	public abstract int extraerMin();

	@WebMethod
	public abstract long contar();

	@WebMethod
	public abstract String insertar(Persona paramPersona);

	@WebMethod
	public abstract String modificar(Persona paramPersona);

	@WebMethod
	public abstract String eliminar(Persona paramPersona);

}
