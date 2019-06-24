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
@WebService(name = "NombreServidorSOAP", serviceName = "ProjectJPAEJBSOAP", endpointInterface = "paquete.servicio.soap.ServicioSOAP")
public class ServicioSOAPImpl implements ServicioSOAP {

	@WebMethod
	@Override
	public String getStatus() {

		Date fecha = new Date();
		Locale currentLocale = new Locale("EN");
		DateFormat formato = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.MEDIUM, currentLocale);
		String output = formato.format(fecha);
		return output;
	}

	@WebMethod
	@Override
	public String sumar(int a, int b) {

		if (a == 0 && b == 0) {
			String mensaje = "Debe Introducir valores en las variables";
			return mensaje;
		} else {
			String mensaje = String.valueOf(a + b);
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

	@WebMethod
	public Persona extraerPorId(Persona person) {
		DelegateJpaEjbRest ejb = new DelegateJpaEjbRest();
		Persona list = ejb.extraerPorIdEJBDelegate(person);
		return list;
	}

	@WebMethod
	public int extraerMax() {
		DelegateJpaEjbRest ejb = new DelegateJpaEjbRest();
		int num = ejb.extraerMaxEJBDelegate();
		return num;
	}

	@WebMethod
	public int extraerMin() {
		DelegateJpaEjbRest ejb = new DelegateJpaEjbRest();
		int num = ejb.extraerMinEJBDelegate();
		return num;
	}

	@WebMethod
	public long contar() {
		DelegateJpaEjbRest ejb = new DelegateJpaEjbRest();
		long num = ejb.contarPersonasEJBDelegate();
		return num;
	}

	@WebMethod
	public String insertar(Persona person) {
		DelegateJpaEjbRest ejb = new DelegateJpaEjbRest();
		ejb.insertarPersonaEJBDelegate(person);
		return "PErsona ingresada Exitosamente";
	}

	@WebMethod
	public String modificar(Persona person) {

		int id = person.getIdPersona();
		String ids = String.valueOf(id);
		String nombre =person.getNombrePersona();
		String apellido =person.getApellidoPersona();
		String rut = person.getRutPersona();
		
		if (person.getIdPersona().intValue() == 0) {
			return "Debe ingresar un ID de persona para ser Modificada";
		} else {
			DelegateJpaEjbRest ejb = new DelegateJpaEjbRest();
			ejb.modificarPersonaEJBDelegate(person);
			return "Persona modificada Exitosamente : "+ ids + " "+nombre+" "+apellido+" "+rut;
		}
	}

	@WebMethod
	public String eliminar(Persona person) {
		if (person.getIdPersona().intValue() == 0) {
			return "Debe ingresar un ID de persona para ser eliminada";
		} else {
			DelegateJpaEjbRest ejb = new DelegateJpaEjbRest();
			ejb.eliminarPersonaEJBDelegate(person);
			return "Persona Eliminada correctamente";
		}
	}
}