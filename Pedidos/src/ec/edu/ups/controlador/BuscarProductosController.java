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
 * Servlet implementation class BuscarProductosController
 */
@WebServlet("/BuscarProductosController")
public class BuscarProductosController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductoDAO productoDao;
	private Producto producto;
	private List<Producto> productos;
    
	private int producto_id;
	private int empresa_id;
	private int usuario_id;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarProductosController() {
    	productoDao = DAOFactory.getFactory().getProductoDAO();
    	producto = new Producto();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		try {
			String control = request.getParameter("page");
			String metodo = request.getParameter("bus");
			
			if (control.equals("m") && metodo.equals("ide")) {
				usuario_id = Integer.valueOf(request.getParameter("usu_id"));
				empresa_id = Integer.valueOf(request.getParameter("emp_id"));
				
				producto_id = Integer.valueOf(request.getParameter("pro_id"));
				producto = productoDao.read(producto_id);
				productos = productoDao.find();
				
				request.setAttribute("producto", producto);		
				request.setAttribute("productos", productos);
				request.setAttribute("empresa_id", empresa_id);
				request.setAttribute("usuario_id", usuario_id);
				
				url = "/JSPs/modificar_producto.jsp";
				
			} else if (control.equals("b") && metodo.equals("cat")) {
				usuario_id = Integer.valueOf(request.getParameter("usuario_id"));
				empresa_id = Integer.valueOf(request.getParameter("empresa_id"));
				
				System.out.println("Usuario Id: " + usuario_id);
				System.out.println("Empresa Id: " + empresa_id);
				
				productos = productoDao.buscarPorCateoria(Integer.valueOf(request.getParameter("categoria")), empresa_id);
				request.setAttribute("productos", productos);
				/*
				request.setAttribute("empresa_id", empresa_id);
				request.setAttribute("usuario_id", usuario_id);
				*/
				url = "/JSPs/buscar_producto.jsp";
				
			} else if(control.equals("b") && metodo.equals("nom")) {
				usuario_id = Integer.valueOf(request.getParameter("usuario_id"));
				empresa_id = Integer.valueOf(request.getParameter("empresa_id"));
				
				System.out.println("Usuario Id: " + usuario_id);
				System.out.println("Empresa Id: " + empresa_id);
				
				producto = productoDao.buscarPorNombre(request.getParameter("nombre"), empresa_id);
				request.setAttribute("producto", producto);
				/*
				request.setAttribute("empresa_id", empresa_id);
				request.setAttribute("usuario_id", usuario_id);
				*/
				url = "/JSPs/buscar_producto.jsp";
			}
			
		} catch (Exception e) {
			System.out.println("Error buscar: " + e);
			url = "/JSPs/error.jsp";
		}
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
