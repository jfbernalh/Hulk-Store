package co.com.hulkstore.bean;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import co.com.hulkstore.modelo.Producto;
import co.com.hulkstore.servicio.ServicioProducto;
import co.com.hulkstore.utilidades.Utilidades;

/**
 * @author jcd
 *
 */
@Named
@ViewScoped
public class ActualizarProducto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	/**
	 * 
	 */
	@EJB
	private ServicioProducto servicioProducto;
	/**
	 * 
	 */
	private List<String> tipoProductos;
	/**
	 * 
	 */
	private String productoSeleccionado;
	/**
	 * 
	 */
	private Producto producto;
	
	
	/**
	 * 
	 */
	@PostConstruct
	public void init() {
		tipoProductos = servicioProducto.tipos();
		FacesContext fc = FacesContext.getCurrentInstance();
		String prodId= fc.getExternalContext()
				.getRequestParameterMap().get("prodId");
		producto = servicioProducto.obtenerObjetoPorId(prodId);
		
	}
	
	/**
	 * 
	 * @throws IOException
	 */
	public void update() throws IOException {
		try {
			if(Utilidades.validarPrecio(producto.getPrecioProducto())) {
				if(Utilidades.validarCantidad(producto
											.getCantidadInventario())) {
					if(!(productoSeleccionado.equals("null")))	{
						producto.setTipoProducto(productoSeleccionado);
						servicioProducto.update(producto);
						ExternalContext context= FacesContext
								.getCurrentInstance().getExternalContext();
						context.redirect("administracion.xhtml");
					} else {
						Utilidades.crearMensaje(FacesMessage.SEVERITY_ERROR, 
								"Error!", "Debe seleccionarse un tipo de producto");
						
					}
				} else {
					Utilidades.crearMensaje(FacesMessage.SEVERITY_ERROR, 
							"Error!", "La cantidad de productos ingresados "
									+ "debe ser mayor a cero");
					
				}
			} else {
				Utilidades.crearMensaje(FacesMessage.SEVERITY_ERROR, 
						"Error!", "El precio del producto debe ser mayor a cero");
			}
		}
		catch(Exception ex) {
			Utilidades.crearMensaje(FacesMessage.SEVERITY_ERROR, 
					"Error!", "No se actualizó el producto");
		}
	}

	/**
	 * @return the tipoProductos
	 */
	public List<String> getTipoProductos() {
		return tipoProductos;
	}

	/**
	 * @param tipoProductos the tipoProductos to set
	 */
	public void setTipoProductos(List<String> tipoProductos) {
		this.tipoProductos = tipoProductos;
	}

	/**
	 * @return the productoSeleccionado
	 */
	public String getProductoSeleccionado() {
		return productoSeleccionado;
	}

	/**
	 * @param productoSeleccionado the productoSeleccionado to set
	 */
	public void setProductoSeleccionado(String productoSeleccionado) {
		this.productoSeleccionado = productoSeleccionado;
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
