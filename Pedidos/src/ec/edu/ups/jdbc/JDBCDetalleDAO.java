package ec.edu.ups.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.dao.DetalleDAO;
import ec.edu.ups.modelo.Detalle;

public class JDBCDetalleDAO extends JDBCGenericDAO<Detalle, Integer> implements DetalleDAO {

	public void create(Detalle detalle) {
		// TODO Auto-generated method stub
		
	}
	
	public void crear(Detalle detalle, int cabeceraId, int productoId) {
		
		/*
		sql.update("INSERT peddetalle VALUES (" + detalle.getId() + ", '" + detalle.getCantidad() + "', "
				+ cabeceraId + productoId + ")");
		*/
		
		sql.update("INSERT peddetalle VALUES (0, '" + detalle.getCantidad() + "', "
				+ cabeceraId + productoId + ")");
		
	}

	public Detalle read(Integer id) {
		Detalle detalle = null;
		ResultSet rs = sql.query("SELECT * FROM peddetalle WHERE det_id=" + id);
		try {
			if (rs != null && rs.next()) {
				detalle = new Detalle(rs.getInt("det_id"), rs.getInt("det_cantidad"), null);
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCPersonaDAO:read): " + e.getMessage());
		}

		return detalle;
	}

	public void update(Detalle detalle) {
		sql.update("UPDATE peddetalle SET ped_cantidad = " + detalle.getCantidad() + ", det_pro_id = '" + detalle.getProducto().getId()
		+ "' WHERE det_id = " + detalle.getId());
		
	}

	public void delete(Detalle detalle) {
		sql.update("DELETE FROM peddetalle WHERE det_id = " + detalle.getId());
		
	}

	public List<Detalle> find() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Detalle> buscarPorCabecera(int empresaId) {
		List<Detalle> list = new ArrayList<Detalle>();
		ResultSet rs = sql.query("SELECT * FROM usuario WHERE usu_emp_id=" + empresaId);
		try {
			while (rs.next()) {
				list.add(new Detalle(rs.getInt("det_id"), rs.getInt("det_cantidad"), null));
			}

		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCPersonaDAO:find): " + e.getMessage());
		}
		return list;
	}
	

}
