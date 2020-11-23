package ec.edu.ups.jdbc;

import ec.edu.ups.dao.GenericDAO;

public abstract class JDBCGenericDAO<T, ID> implements GenericDAO<T, ID> {
	
	protected ContextJDBC sql = ContextJDBC.getJDBC();
	
}
