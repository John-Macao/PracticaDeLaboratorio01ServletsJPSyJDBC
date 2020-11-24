package ec.edu.ups.modelo;

import java.util.ArrayList;

public class Usuario {
	
	private int id;
	private String nombre;
	private String apellido;
	private String usuario;
	private String contrasena;
	private String rol;
	private ArrayList<Cabecera> cabeceras;
	
	public Usuario() {
		
	}
	
	public Usuario(int id, String nombre, String apellido, String usuario, String contrasena, String rol, ArrayList<Cabecera> cabeceras) {
		this.setId(id);
		this.setNombre(nombre);
		this.setApellido(apellido);
		this.setUsuario(usuario);
		this.setContrasena(contrasena);
		this.setRol(rol);
		this.setCabeceras(cabeceras);
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public ArrayList<Cabecera> getCabeceras() {
		return cabeceras;
	}

	public void setCabeceras(ArrayList<Cabecera> cabeceras) {
		this.cabeceras = cabeceras;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}
	
	
	
}
