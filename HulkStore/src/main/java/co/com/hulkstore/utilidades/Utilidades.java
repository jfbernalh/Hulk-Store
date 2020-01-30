package co.com.hulkstore.utilidades;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;



public class Utilidades {
	
	
	public Utilidades() {
		throw new UnsupportedOperationException();
	}
	
	public static boolean validarPrecio(Double precio) {
		return precio > 0;
	}
	
	public static boolean validarCantidad(Integer cantidad) {
		return cantidad > 0;
	}
	
	public static void crearMensaje(Severity tipo, String titulo, String mensaje) {
		FacesContext.getCurrentInstance().addMessage(null, 
				new FacesMessage(tipo, titulo, mensaje));
	}
	
	

}
