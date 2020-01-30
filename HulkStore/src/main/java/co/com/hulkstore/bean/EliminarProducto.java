package co.com.hulkstore.bean;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import co.com.hulkstore.modelo.Producto;
import co.com.hulkstore.servicio.ServicioProducto;

@Named
@ViewScoped
public class EliminarProducto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private Producto producto;
	/**
	 * 
	 */
	@EJB
	private ServicioProducto servicioProducto;
	
	/**
	 * 
	 */
	@PostConstruct
	public void init() {
		FacesContext fc = FacesContext.getCurrentInstance();
		String prodId= fc.getExternalContext()
				.getRequestParameterMap().get("prodId");
		producto = servicioProducto.obtenerObjetoPorId(prodId);
		
	}
	/**
	 * 
	 * @throws IOException
	 */
	public void delete() throws IOException {
		servicioProducto.delete(producto);
		ExternalContext context= FacesContext
				.getCurrentInstance().getExternalContext();
		context.redirect("administracion.xhtml");
	}
	/**
	 * @return the producto
	 */
	public Producto getProducto() {
		return producto;
	}
	/**
	 * @param producto the producto to set
	 */
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	
	

}
