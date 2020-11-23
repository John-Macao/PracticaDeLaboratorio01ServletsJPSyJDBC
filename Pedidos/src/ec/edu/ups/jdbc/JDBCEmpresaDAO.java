package ec.edu.ups.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.dao.EmpresaDAO;
import ec.edu.ups.modelo.Empresa;
import ec.edu.ups.modelo.Usuario;

public class JDBCEmpresaDAO extends JDBCGenericDAO<Empresa, Integer> implements EmpresaDAO {

	public void create(Empresa empresaa) {
		// TODO Auto-generated method stub
		
	}

	public Empresa read(Integer id) {
		Empresa empresa = null;
		ResultSet rs = sql.query("SELECT * FROM empresa WHERE emp_id=" + id);
		try {
			if (rs != null && rs.next()) {
				empresa = new Empresa(rs.getInt("emp_id"), rs.getString("emp_nombre"), null);
			}
		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCPersonaDAO:read): " + e.getMessage());
		}

		return empresa;
	}

	public void update(Empresa empresa) {
		// TODO Auto-generated method stub
		
	}

	public void delete(Empresa empresa) {
		// TODO Auto-generated method stub
		
	}

	public List<Empresa> find() {
		List<Empresa> list = new ArrayList<Empresa>();
		ResultSet rs = sql.query("SELECT * FROM usuario");
		try {
			while (rs.next()) {
				list.add(new Empresa(rs.getInt("emp_id"), rs.getString("emp_nombre"), null));
			}

		} catch (SQLException e) {
			System.out.println(">>>WARNING (JDBCPersonaDAO:find): " + e.getMessage());
		}
		return list;
	}

}
