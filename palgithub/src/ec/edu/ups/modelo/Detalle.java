package ec.edu.ups.modelo;

public class Detalle {
	
	private int id;
	private int cantidad;
	private Producto producto;
	
	public Detalle() {
		
	}
	
	public Detalle(int id, int cantidad, Producto producto) {
		this.setId(id);
		this.setCantidad(cantidad);
		this.setProducto(producto);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
	
	
}
