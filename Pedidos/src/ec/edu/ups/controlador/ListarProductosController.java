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
 * Servlet implementation class ListarProductosController
 */
@WebServlet("/ListarProductosController")
public class ListarProductosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductoDAO productoDao;
    private List<Producto> listaProductos; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListarProductosController() {
    	productoDao = DAOFactory.getFactory().getProductoDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		try {
			String page = request.getParameter("page");
			
			if(page.equals("m")) {
				listaProductos = productoDao.find();
				System.out.println("Tamano de la lista recuperada: " + listaProductos.size());
				request.setAttribute("productos", listaProductos);
				url = "/JSPs/modificar_producto.jsp?page=m";
			}
		} catch (Exception e) {
			url = "/JSPs/error.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		String url = null;
		try {
			listaProductos = productoDao.find();
			System.out.println("Tamano de la lista recuperada: " + listaProductos.size());
			request.setAttribute("productos", listaProductos);
			url = "/JSPs/modificar_productos.jsp";
		} catch (Exception e) {
			url = "/JSPs/error.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
		*/
	}

}
