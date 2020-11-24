package ec.edu.ups.dao;

import ec.edu.ups.jdbc.JDBCCabeceraDAO;
import ec.edu.ups.jdbc.JDBCCategoriaDAO;
import ec.edu.ups.jdbc.JDBCDetalleDAO;
import ec.edu.ups.jdbc.JDBCEmpresaDAO;
import ec.edu.ups.jdbc.JDBCProductoDAO;
import ec.edu.ups.jdbc.JDBCUsuarioDAO;

public class JDBCDAOFactory extends DAOFactory {

	public CabeceraDAO getCabeceraDAO() {
		return new JDBCCabeceraDAO();
	}

	public CategoriaDAO getCategoriaDAO() {
		return new JDBCCategoriaDAO();
	}

	public DetalleDAO getDetalleDAO() {
		return new JDBCDetalleDAO();
	}

	public EmpresaDAO getEmpresaDAO() {
		return new JDBCEmpresaDAO();
	}

	public ProductoDAO getProductoDAO() {
		return new JDBCProductoDAO();
	}

	public UsuarioDAO getUsuarioDAO() {
		return new JDBCUsuarioDAO();
	}

}
