package ec.edu.ups.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.ProductoDAO;
import ec.edu.ups.modelo.Producto;

/**
 * Servlet implementation class ModificarProductosController
 */
@WebServlet("/ModificarProductosController")
public class ModificarProductosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductoDAO productoDao;
	private Producto producto;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarProductosController() {
    	productoDao = DAOFactory.getFactory().getProductoDAO();
    	producto = new Producto();
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		
		try {
			producto.setId(Integer.valueOf(request.getParameter("producto_id")));
			producto.setNombre(request.getParameter("nombre"));
			producto.setCantidad(Integer.valueOf(request.getParameter("cantidad")));
			producto.setEstado("h");
			productoDao.update(producto);

			url = "/ListarProductosController";
		} catch (Exception e) {
			url = "/JSPs/error.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
