package ec.edu.ups.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.modelo.Usuario;

public class JDBCUsuarioDAO extends JDBCGenericDAO<Usuario, Integer> implements UsuarioDAO {
	
	public Usuario login(String usuairo, String contrasena) {
		Usuario usuario = null;
		ResultSet rs = sql.query("SELECT * FROM usuario WHERE usu_usuario='" + usuario + "' AND usu_contrasena='" + contrasena +"'");
		try {
			if (rs != null && rs.next()) {
				usuario = new Usuario(rs.getInt("usu_id"), rs.getString("usu_nombre"), rs.getString("usu_apellido"),
						rs.getString("usu_usuario"), rs.getString("usu_contrasena"), rs.getString("usu_rol"), null);
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCPersonaDAO:read): " + e.getMessage());
		}
		//Se debe agregar la lista de pedidos que se han hecho (posible solucion, en el controlador se obtiene el usuario y alli se envia
		//la consulta para los pedidos y se le agrega al usuario)
		return usuario;
	}

	public void update(Usuario usuario) {
		sql.update("UPDATE usuario SET usu_nombre = '" + usuario.getNombre() + "', usu_apellido = '" + usuario.getApellido()
		+ "', usu_contrasena = '" + usuario.getContrasena() + "' WHERE usu_id = " + usuario.getId());
		
	}

	public void delete(Usuario usuario) {
		sql.update("DELETE FROM usuario WHERE usu_id = " + usuario.getId());
		
	}

	public List<Usuario> find() {
		List<Usuario> list = new ArrayList<Usuario>();
		ResultSet rs = sql.query("SELECT * FROM usuario");
		try {
			while (rs.next()) {
				list.add(new Usuario(rs.getInt("usu_id"), rs.getString("usu_nombre"), rs.getString("usu_apellido"),
						rs.getString("usu_usuario"), rs.getString("usu_contrasena"), rs.getString("usu_rol"), null));
			}

		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCPersonaDAO:find): " + e.getMessage());
		}
		return list;
	}
	
	public List<Usuario> buscarPorEmpresa(int empresaId) {
		List<Usuario> list = new ArrayList<Usuario>();
		ResultSet rs = sql.query("SELECT * FROM usuario WHERE usu_emp_id=" + empresaId);
		try {
			while (rs.next()) {
				list.add(new Usuario(rs.getInt("usu_id"), rs.getString("usu_nombre"), rs.getString("usu_apellido"),
						rs.getString("usu_usuario"), rs.getString("usu_contrasena"), rs.getString("usu_rol"), null));
			}

		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCPersonaDAO:find): " + e.getMessage());
		}
		return list;
	}

	public void create(Usuario entity) {
		// TODO Auto-generated method stub
		
	}

	public Usuario read(Integer id) {
		Usuario usuario = null;
		ResultSet rs = sql.query("SELECT * FROM usuario WHERE usu_id=" + id);
		try {
			if (rs != null && rs.next()) {
				usuario = new Usuario(rs.getInt("usu_id"), rs.getString("usu_nombre"), rs.getString("usu_apellido"),
						rs.getString("usu_usuario"), rs.getString("usu_contrasena"), rs.getString("usu_rol"), null);
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCPersonaDAO:read): " + e.getMessage());
		}

		return usuario;
	}

	public int empresaId(int id) {
		int empresa=0;
		ResultSet rs = sql.query("SELECT usu_emp_id FROM usuario WHERE usu_id=" + id);
		
		try {
			if (rs != null && rs.next()) {
				empresa = rs.getInt("usu__emp_id");
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCPersonaDAO:read): " + e.getMessage());
		}
		return empresa;
		
	}


}
