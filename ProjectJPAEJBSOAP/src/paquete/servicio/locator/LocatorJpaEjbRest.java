package paquete.servicio.locator;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import paquete.ejb.InterfaceEjbJpaRemoteSoap;

public class LocatorJpaEjbRest {
	
	private InterfaceEjbJpaRemoteSoap ejb;
	
	public InterfaceEjbJpaRemoteSoap getEjb(){
	
		try {
		
		if (ejb==null) {
			Context jndi = new InitialContext();
			ejb = (InterfaceEjbJpaRemoteSoap) jndi.lookup("paquete.ejb.EjbJpaSoap#paquete.ejb.InterfaceEjbJpaRemoteSoap");  // El EJB debe tener definido el atributo mappedName="beans.BussinesEJB"
		}
	
		return ejb;
	
		} catch(NamingException e) {
			e.printStackTrace();
			return null;
		}
	}

}
