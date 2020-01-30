package co.com.hulkstore.servicio;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;

import co.com.hulkstore.modelo.Producto;

@Stateless
public class ServicioProducto{
	
	/**
	 * Lista con todos los productos en existencia
	 */
	private List<Producto> productos;
	
	@PostConstruct
	public void init() {
		productos = new ArrayList<>();		
	}
	
	/**
	 * <p>Metodo para crear un nuevo registro de un 
	 * producto 
	 * </p>
	 * @param producto - objeto de tipo producto
	 */
	public void create(Producto producto) {
		producto.setId(productos.size()+1);
		productos.add(producto);
	}
	
	/**
	 * <p>Metodo para actualizar el registro de un 
	 * producto  
	 * </p>
	 * @param producto
	 */
	public void update(Producto producto) {		
			producto.setNombreProducto
							(producto.getNombreProducto());
			producto.setTipoProducto(producto.getTipoProducto());
			producto.setCantidadInventario		
							(producto.getCantidadInventario());
			producto.setPrecioProducto(producto.getPrecioProducto());
	}
	
	/**
	 * <p>Metodo que retorna la lista de productos  
	 * </p>
	 * @return lista con productos en inventario
	 */
	public List<Producto> list(){
		return productos;
	}
	
	/**
	 * 
	 * @return
	 */
	public List<String> tipos() {
		List<String> tipos = new ArrayList<>();
		tipos.add("Muñecos/Juguetes");
		tipos.add("Camisetas/Ropa");
		tipos.add("Vasos");
		tipos.add("Coleccionables");
		tipos.add("Peliculas/Series");
		tipos.add("Comics/Libros");
		tipos.add("Otros");
		return tipos;
	}
	
	/**
	 * 
	 * @param producto
	 */
	public void delete(Producto producto) {
		productos.remove(producto);
	}
	
	/**
	 * 
	 * @param prodId
	 * @return
	 */
	public Producto obtenerObjetoPorId(String prodId) {
		return productos.get(Integer.parseInt(prodId) - 1);
	}

	/**
	 * @return the productos
	 */
	public List<Producto> getProductos() {
		return productos;
	}

	/**
	 * @param productos the productos to set
	 */
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	
}
