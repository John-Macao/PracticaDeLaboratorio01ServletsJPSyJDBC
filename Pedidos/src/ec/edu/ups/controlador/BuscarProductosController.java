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
 * Servlet implementation class BuscarProductosController
 */
@WebServlet("/BuscarProductosController")
public class BuscarProductosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductoDAO productoDao;
	private Producto producto;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarProductosController() {
    	productoDao = DAOFactory.getFactory().getProductoDAO();
    	producto = new Producto();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		try {
			String control = request.getParameter("page");
			String metodo = request.getParameter("bus");
			
			if (control.equals("m")) {
				int id = Integer.valueOf(request.getParameter("pro"));
				producto = productoDao.read(id);
				request.setAttribute("producto", producto);
				url = "/ListarProductosController?page=m";
				
			} else if(control.equals("b") && metodo.equals("cat")) {
				//producto = productoDao.buscarPorCateoria(Integer.valueOf(request.getParameter("categoria")), Integer.valueOf(request.getParameter("emp")));
				request.setAttribute("producto", producto);
				url = "/ListarProductosController?page=m";
				
			} else if(control.equals("b") && metodo.equals("nom")) {
				
			}
			
		} catch (Exception e) {
			url = "/JSPs/error.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
