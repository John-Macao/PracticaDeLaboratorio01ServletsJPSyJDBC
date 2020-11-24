package ec.edu.ups.modelo;

public class Producto {
	
	private int id;
	private String nombre;
	private int cantidad;
	//Estado: h (habilitado), i (inhabilitado)
	private String estado;
	private Categoria categoria;
	
	public Producto() {
		
	}
	
	public Producto(int id, String nombre, int cantidad, String rol, Categoria categoria) {
		this.setId(id);
		this.setNombre(nombre);
		this.setCantidad(cantidad);
		this.setEstado(rol);
		this.setCategoria(categoria);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
	
}
