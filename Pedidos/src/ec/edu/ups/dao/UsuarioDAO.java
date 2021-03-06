package ec.edu.ups.dao;

import java.util.List;

import ec.edu.ups.modelo.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario, Integer> {
	
	public abstract Usuario login(String usuairo, String contrasena);
	public abstract int empresaId(int id);
	public abstract List<Usuario> buscarSoloUsuario(int empresaId);
}
