package ec.edu.ups.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.dao.CategoriaDAO;
import ec.edu.ups.modelo.Categoria;

public class JDBCCategoriaDAO extends JDBCGenericDAO<Categoria, Integer> implements CategoriaDAO {

	public void create(Categoria categoria) {
		// TODO Auto-generated method stub
		
	}

	public Categoria read(Integer id) {
		Categoria categoria = null;
		ResultSet rs = sql.query("SELECT * FROM categoria WHERE cat_id=" + id);
		try {
			if (rs != null && rs.next()) {
				categoria = new Categoria(rs.getInt("cat_id"), rs.getString("cat_nombre"));
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCPersonaDAO:read): " + e.getMessage());
		}

		return categoria;
	}

	public void update(Categoria categoria) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Categoria categoria) {
		// TODO Auto-generated method stub
		
	}

	public List<Categoria> find() {
		List<Categoria> list = new ArrayList<Categoria>();
		ResultSet rs = sql.query("SELECT * FROM usuario");
		try {
			while (rs.next()) {
				list.add(new Categoria(rs.getInt("usu_id"), rs.getString("cat_nombre")));
			}

		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCPersonaDAO:find): " + e.getMessage());
		}
		return list;
	}

}
