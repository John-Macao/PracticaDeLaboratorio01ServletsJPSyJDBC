package ec.edu.ups.modelo;

import java.util.ArrayList;

public class Cabecera {
	
	private int id;
	private String estado;
	private ArrayList<Detalle> detalles;
	
	public Cabecera() {
	}
	
	public Cabecera(int id, String estado, ArrayList<Detalle> detalles) {
		this.setId(id);
		this.setEstado(estado);
		this.setDetalles(detalles);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public ArrayList<Detalle> getDetalles() {
		return detalles;
	}

	public void setDetalles(ArrayList<Detalle> detalles) {
		this.detalles = detalles;
	}
	
	
	
}
