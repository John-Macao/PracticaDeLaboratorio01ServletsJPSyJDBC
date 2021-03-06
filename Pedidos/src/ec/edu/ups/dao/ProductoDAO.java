package ec.edu.ups.dao;

import java.util.List;

import ec.edu.ups.modelo.Producto;

public interface ProductoDAO extends GenericDAO<Producto, Integer> {
	
	public abstract void crear(Producto producto, int empresaId, int categoriaId);
	public abstract int categoriaId(int id);
	public abstract List<Producto> find(int empId);
	public List<Producto> buscarPorCateoria(int catId, int empId);
	public Producto buscarPorNombre(String nombre, int empId);
	public Producto buscarSoloPorNombre(String nombre);
	
	public Producto TEST(int id_pro);
	public List<Producto> buscarPorCateoria2(int catId);
	public int obtenerCategoriaId(int producto);
}
