package ec.edu.ups.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.dao.ProductoDAO;
import ec.edu.ups.modelo.Producto;

public class JDBCProductoDAO extends JDBCGenericDAO<Producto, Integer> implements ProductoDAO {

	public void create(Producto producto) {
		
	}
	
	public void crear(Producto producto, int empresaId, int categoriaId) {
		sql.update("INSERT producto VALUES (" + producto.getId() + ", '" + producto.getNombre() + "', "
				+ producto.getCantidad() + ", '"+ producto.getEstado() + "', " + empresaId + categoriaId + ")");
	}

	public Producto read(Integer id) {
		Producto producto = null;
		ResultSet rs = sql.query("SELECT * FROM producto WHERE pro_id=" + id);
		try {
			if (rs != null && rs.next()) {
				producto = new Producto(rs.getInt("pro_id"), rs.getString("pro_nombre"), rs.getInt("pro_cantidad"), 
						rs.getString("pro_estado"), null);
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCPersonaDAO:read): " + e.getMessage());
		}

		return producto;
	}
	
	public int empresaId(int id) {
		int empId = 0;
		ResultSet rs = sql.query("SELECT pro_emp_id FROM producto WHERE pro_id=" + id);
		try {
			if (rs != null && rs.next()) {
				empId = rs.getInt("pro_emp_id");
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCPersonaDAO:read): " + e.getMessage());
		}

		return empId;
	}
	
	public int categoriaId(int id) {
		int catId = 0;
		ResultSet rs = sql.query("SELECT pro_emp_id FROM producto WHERE pro_id=" + id);
		try {
			if (rs != null && rs.next()) {
				catId = rs.getInt("pro_emp_id");
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCPersonaDAO:read): " + e.getMessage());
		}

		return catId;
	}

	public void update(Producto producto) {
		sql.update("UPDATE producto SET pro_nombre = '" + producto.getNombre() + "', pro_cantidad = " + producto.getCantidad()
		+ ", pro_estado='" + producto.getEstado() + "' WHERE pro_id = " + producto.getId());
	}

	public void delete(Producto producto) {
		sql.update("UPDATE producto SET pro_estado='" + producto.getEstado() + "' WHERE pro_id = " + producto.getId());
	}

	public List<Producto> find() {
		List<Producto> list = new ArrayList<Producto>();
		ResultSet rs = sql.query("SELECT * FROM producto");
		try {
			while (rs.next()) {
				list.add(new Producto(rs.getInt("pro_id"), rs.getString("pro_nombre"), rs.getInt("pro_cantidad"), 
						rs.getString("pro_estado"), null));
			}

		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCPersonaDAO:find): " + e.getMessage());
		}
		return list;
	}
	
	public List<Producto> find(int empId) {
		List<Producto> list = new ArrayList<Producto>();
		ResultSet rs = sql.query("SELECT * FROM producto WHERE pro_emp_id=" + empId);
		try {
			while (rs.next()) {
				list.add(new Producto(rs.getInt("pro_id"), rs.getString("pro_nombre"), rs.getInt("pro_cantidad"), 
						rs.getString("pro_estado"), null));
			}

		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCPersonaDAO:find): " + e.getMessage());
		}
		return list;
	}

}
