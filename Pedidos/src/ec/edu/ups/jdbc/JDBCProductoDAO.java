package ec.edu.ups.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.dao.ProductoDAO;
import ec.edu.ups.modelo.Categoria;
import ec.edu.ups.modelo.Detalle;
import ec.edu.ups.modelo.Producto;

public class JDBCProductoDAO extends JDBCGenericDAO<Producto, Integer> implements ProductoDAO {

	public void create(Producto producto) {
		
	}
	
	public void crear(Producto producto, int empresaId, int categoriaId) {
		sql.update("INSERT producto VALUES (0, '" + producto.getNombre() + "', "
				+ producto.getCantidad() + ", '"+ producto.getEstado() + "', " + empresaId +","+ categoriaId + ")");
	}

	public Producto read(Integer id) {
		Producto producto = null;
		ResultSet rs = sql.query("SELECT * FROM producto WHERE pro_id=" + id + " AND pro_estado != 'e'");
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
	
	public int categoriaId(int id) {
		int catId = 0;
		ResultSet rs = sql.query("SELECT pro_cat_id FROM producto WHERE pro_id=" + id);
		try {
			if (rs != null && rs.next()) {
				catId = rs.getInt("pro_cat_id");
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
		ResultSet rs = sql.query("SELECT * FROM producto WHERE pro_estado != 'e'");
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
		ResultSet rs = sql.query("SELECT * FROM producto WHERE pro_emp_id=" + empId + " AND pro_estado != 'e'");
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

	public List<Producto> buscarPorCateoria(int catId, int empId) {
		List<Producto> list = new ArrayList<Producto>();
		ResultSet rs = sql.query("SELECT * FROM producto WHERE pro_cat_id=" + catId + " AND pro_emp_id=" + empId + " AND pro_estado != 'e'");
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
	
	public Producto buscarPorNombre(String nombre, int empId) {
		Producto producto = null;
		ResultSet rs = sql.query("SELECT * FROM producto WHERE pro_nombre='" + nombre + "' AND pro_emp_id=" + empId + " AND pro_estado != 'e'");
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

	
	public Producto buscarSoloPorNombre(String nombre) {
		Producto producto = null;
		ResultSet rs = sql.query("SELECT * FROM producto WHERE pro_nombre='" + nombre + "'");
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
	
	
	
	
	
	
	
	public Producto TEST (int id_pro) {
		Producto producto = null;
		ResultSet rs = sql.query("SELECT * FROM producto WHERE pro_id=" + id_pro );
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
	
	
	public List<Producto> buscarPorCateoria2(int catId) {
		List<Producto> list = new ArrayList<Producto>();
		ResultSet rs = sql.query("SELECT * FROM producto WHERE pro_cat_id=" + catId + " AND pro_estado != 'e'");
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
	
	
	public int obtenerCategoriaId(int producto) {
		int cat_id = 0;
		ResultSet rs = sql.query("SELECT pro_cat_id FROM producto WHERE pro_id = " + producto);
		try {
			if (rs != null && rs.next()) {
				cat_id = rs.getInt("pro_cat_id");
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCPersonaDAO:read): " + e.getMessage());
		}

		return cat_id;
	}
	
	
}
