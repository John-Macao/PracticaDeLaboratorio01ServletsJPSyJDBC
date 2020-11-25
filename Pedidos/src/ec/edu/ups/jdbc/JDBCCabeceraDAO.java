package ec.edu.ups.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.dao.CabeceraDAO;
import ec.edu.ups.modelo.Cabecera;

public class JDBCCabeceraDAO extends JDBCGenericDAO<Cabecera, Integer> implements CabeceraDAO {

	public void create(Cabecera cabecera) {
		// TODO Auto-generated method stub
		
	}
	
	public void crear(Cabecera cabecera, int usuarioId) {
		
		/*
		sql.update("INSERT pedcabecera VALUES (" + cabecera.getId() + ", '" + cabecera.getEstado() + "', "
				+ usuarioId + ")");
		*/
		
		sql.update("INSERT pedcabecera VALUES (0, '" + cabecera.getEstado() + "', "
				+ usuarioId + ")");
	}

	public Cabecera read(Integer id) {
		Cabecera cabecera = null;
		ResultSet rs = sql.query("SELECT * FROM pedcabecera WHERE usu_id=" + id);
		try {
			if (rs != null && rs.next()) {
				cabecera = new Cabecera(rs.getInt("cab_id"), rs.getString("cab_estado"), null);
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCPersonaDAO:read): " + e.getMessage());
		}

		return cabecera;
	}
	

	public void update(Cabecera cabecera) {
		sql.update("UPDATE pedcabecera SET cab_estado = '" + cabecera.getEstado() + "' WHERE cab_id = " + cabecera.getId());
		
	}

	public void delete(Cabecera cabecera) {
		// TODO Auto-generated method stub
		
	}

	public List<Cabecera> find() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public List<Cabecera> listarPorUsuario(int usuarioId) {
		List<Cabecera> list = new ArrayList<Cabecera>();
		ResultSet rs = sql.query("SELECT * FROM pedcabecera WHERE cab_usu_id=" + usuarioId);
		try {
			while (rs.next()) {
				list.add(new Cabecera(rs.getInt("cab_id"), rs.getString("cab_estado"), null));
			}

		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCPersonaDAO:find): " + e.getMessage());
		}
		return list;
	}
	
	public int ultimoCreado() {
		int cabeceraId = 0;
		ResultSet rs = sql.query("SELECT max(cab_id) FROM pedcabecera");
		try {
			if (rs != null && rs.next()) {
				cabeceraId = rs.getInt("cab_id");
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCPersonaDAO:read): " + e.getMessage());
		}

		return cabeceraId;
	}
	

}
