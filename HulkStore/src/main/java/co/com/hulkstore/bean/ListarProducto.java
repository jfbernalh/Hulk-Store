package co.com.hulkstore.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import co.com.hulkstore.servicio.ServicioProducto;
import co.com.hulkstore.modelo.Producto;

@Named
@ViewScoped
public class ListarProducto implements Serializable{

	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	@EJB
	private ServicioProducto servicioProducto;
	/**
	 * 
	 */
	private List<Producto> listaProductos;
	
	/**
	 * 
	 */
	@PostConstruct
	public void init() {
		listaProductos = servicioProducto.list();
	}

	/**
	 * @return the servicioProducto
	 */
	public ServicioProducto getServicioProducto() {
		return servicioProducto;
	}

	/**
	 * @param servicioProducto the servicioProducto to set
	 */
	public void setServicioProducto(ServicioProducto servicioProducto) {
		this.servicioProducto = servicioProducto;
	}

	/**
	 * @return the listaProductos
	 */
	public List<Producto> getListaProductos() {
		return listaProductos;
	}

	/**
	 * @param listaProductos the listaProductos to set
	 */
	public void setListaProductos(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}	
	

}
