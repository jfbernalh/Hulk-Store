package co.com.hulkstore.modelo;

import java.io.Serializable;

/**
 * Clase que implementa el modelo 
 * @author Jonny Bernal
 *
 */
public class Producto implements Serializable{

	/**
	 * Variable para serializacion
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Id del objeto tipo producto
	 */
	private Integer id;
	/**
	 * Nombre del producto
	 */
	private String nombreProducto;
	/**
	 * Precio del producto
	 */
	private Double precioProducto;
	/**
	 * Tipo del producto
	 */
	private String tipoProducto;
	/**
	 * Cantidad de productos de un mismo tipo en 
	 * inventario
	 */
	private Integer cantidadInventario;
	
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the nombreProducto
	 */
	public String getNombreProducto() {
		return nombreProducto;
	}
	/**
	 * @param nombreProducto the nombreProducto to set
	 */
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	/**
	 * @return the tipoProducto
	 */
	public String getTipoProducto() {
		return tipoProducto;
	}
	/**
	 * @param tipoProducto the tipoProducto to set
	 */
	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}
	/**
	 * @return the cantidadInventario
	 */
	public Integer getCantidadInventario() {
		return cantidadInventario;
	}
	/**
	 * @param cantidadInventario the cantidadInventario to set
	 */
	public void setCantidadInventario(Integer cantidadInventario) {
		this.cantidadInventario = cantidadInventario;
	}
	/**
	 * @return the precioProducto
	 */
	public Double getPrecioProducto() {
		return precioProducto;
	}
	/**
	 * @param precioProducto the precioProducto to set
	 */
	public void setPrecioProducto(Double precioProducto) {
		this.precioProducto = precioProducto;
	}
	

}
