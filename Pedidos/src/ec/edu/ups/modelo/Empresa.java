package ec.edu.ups.modelo;

import java.util.ArrayList;

public class Empresa {
	
	private int id;
	private String nombre;
	private ArrayList<Usuario> usuarios;
	
	public Empresa() {
		
	}
	
	public Empresa(int id, String nombre, ArrayList<Usuario> usuarios) {
		this.setId(id);
		this.setNombre(nombre);
		this.setUsuarios(usuarios);
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

	public ArrayList<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(ArrayList<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	
	
	
	
}
