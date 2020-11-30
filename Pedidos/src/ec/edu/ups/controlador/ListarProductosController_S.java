package ec.edu.ups.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.ProductoDAO;
import ec.edu.ups.modelo.Producto;

/**
 * Servlet implementation class ListarProductosController_S
 */
@WebServlet("/ListarProductosController_S")
public class ListarProductosController_S extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductoDAO productoDao;
	private Producto producto;
    private List<Producto> listaProductos; 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarProductosController_S() {
    	productoDao = DAOFactory.getFactory().getProductoDAO();
    	producto = new Producto();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		System.out.println("Entra al Listado_S");
		try {
			//String page = request.getParameter("page");
			int usuario_id = Integer.valueOf(request.getParameter("usuario_id"));
			int empresa_id = Integer.valueOf(request.getParameter("empresa_id")); 
			
			listaProductos = productoDao.find();
			//System.out.println("Tamano de la lista recuperada: " + listaProductos.size());
			request.setAttribute("productos", listaProductos);
			request.setAttribute("producto", producto);
			request.setAttribute("empresa_id", empresa_id);
			request.setAttribute("usuario_id", usuario_id);
			url = "/JSPs/modificar_producto.jsp";
		
		} catch (Exception e) {
			System.out.println("Error Listar_S: " + e);
			url = "/JSPs/error.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
