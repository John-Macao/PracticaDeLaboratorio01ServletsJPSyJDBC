package ec.edu.ups.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import ec.edu.ups.modelo.Cabecera;

public interface CabeceraDAO extends GenericDAO<Cabecera, Integer> {
	
	public abstract void crear(Cabecera cabecera, int usuarioId);
	public abstract List<Cabecera> listarPorUsuario(int usuarioId);
	public abstract int ultimoCreado();
	public abstract List<Cabecera> listarRevisadas(int usuarioId);
	public abstract List<Cabecera> listarAprobadas(int usuarioId);
	public abstract List<Cabecera> listarRechazadas(int usuarioId);
	
}
