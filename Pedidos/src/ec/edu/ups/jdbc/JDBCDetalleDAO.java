package ec.edu.ups.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.dao.DetalleDAO;
import ec.edu.ups.modelo.Detalle;
import ec.edu.ups.modelo.Producto;

public class JDBCDetalleDAO extends JDBCGenericDAO<Detalle, Integer> implements DetalleDAO {

	public void create(Detalle detalle) {
		// TODO Auto-generated method stub
		
	}
	
	public void crear(Detalle detalle, int cabeceraId, int productoId) {
		
		sql.update("INSERT peddetalle VALUES (0, '" + detalle.getCantidad() + "', "
				+ cabeceraId +","+ productoId + ")");
		
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
		sql.update("UPDATE peddetalle SET det_cantidad = '" + detalle.getCantidad() + "' WHERE det_id = " + detalle.getId());
		
	}
	
	
	

	public void delete(Detalle detalle) {
		sql.update("DELETE FROM peddetalle WHERE det_id = " + detalle.getId());
		
	}

	public List<Detalle> find() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Detalle> buscarPorCabecera(int cabeceraId) {
		List<Detalle> list = new ArrayList<Detalle>();
		ResultSet rs = sql.query("SELECT * FROM peddetalle WHERE det_cab_id=" + cabeceraId);
		try {
			while (rs.next()) {
				list.add(new Detalle(rs.getInt("det_id"), rs.getInt("det_cantidad"), null));
			}

		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCPersonaDAO:find): " + e.getMessage());
		}
		return list;
	}
	
	public int obtenerProductoId(Detalle detalle) {
		int productoId = 0;
		ResultSet rs = sql.query("SELECT det_pro_id FROM peddetalle WHERE det_id=" + detalle.getId());
		try {
			if (rs != null && rs.next()) {
				productoId = rs.getInt("det_pro_id");
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCPersonaDAO:read): " + e.getMessage());
		}

		return productoId;
	}
	
	
	
	
	public Detalle test(int id_cab) {
		Detalle detalle = null;
		ResultSet rs = sql.query("SELECT * FROM peddetalle WHERE det_cab_id=" + id_cab);
		try {
			if (rs != null && rs.next()) {
				detalle = new Detalle(rs.getInt("det_id"), rs.getInt("det_cantidad"), null);
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCPersonaDAO:read): " + e.getMessage());
		}

		return detalle;
	}
	
	public Detalle test2(int pro_id, int cab_id) {
		Detalle detalle = null;
		ResultSet rs = sql.query("SELECT * FROM peddetalle WHERE det_pro_id= " + pro_id + " AND det_cab_id= " + cab_id);
		try {
			if (rs != null && rs.next()) {
				detalle = new Detalle(rs.getInt("det_id"), rs.getInt("det_cantidad"), null);
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCPersonaDAO:read): " + e.getMessage());
		}

		return detalle;
	}
	

}
