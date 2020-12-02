package ec.edu.ups.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.DetalleDAO;
import ec.edu.ups.dao.ProductoDAO;
import ec.edu.ups.modelo.Detalle;
import ec.edu.ups.modelo.Producto;

/**
 * Servlet implementation class TEST
 */
@WebServlet("/TEST")
public class TEST extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ProductoDAO productoDao;
    private List<Producto> listaProductos;
    
    private Producto producto;
    
    private DetalleDAO detalleDao;
    private Detalle detalle;
    
    int cont=0;
    
    public TEST() {
    	productoDao = DAOFactory.getFactory().getProductoDAO();
    	
    	detalleDao = DAOFactory.getFactory().getDetalleDAO();
    	detalle = new Detalle();
    	
    	producto = new Producto();
    }
	
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int usuario_id = Integer.valueOf(request.getParameter("usuario_id"));
		
		
		String cabecera_id = request.getParameter("ver_id");
		
		
		String p = request.getParameter("item");
		String c = request.getParameter("cantidad");
		System.out.println("OBTENGO CABECERA   :   " + cabecera_id);
		System.out.println("OBTENGO USUARIO_ID   :   " + usuario_id);
		
		System.out.println("TEXTO   :   " + p);
		
		
		if (c.equals("")) {
			System.out.println("---------------------------");
			System.out.println("VALOR DE CANTIDAD :  " + c);
			System.out.println("---------------------------");
			listaProductos = productoDao.find();
			request.setAttribute("listaProductos", listaProductos);
			request.setAttribute("usuario_id", usuario_id);
			
			
		}else {
			
			int cc = Integer.parseInt(c);
			int ver_id = Integer.parseInt(cabecera_id);
			cont=cont+1;
			
			System.out.println("-------------------------------------------------");
			System.out.println("ver id de user:  " + usuario_id);
			System.out.println("ver id de cabecera:  " + ver_id);
				listaProductos = productoDao.find();
				
				System.out.println("Tamaño de la lista recuperada: " + listaProductos.size());
				System.out.println("VER posicion del  PRODUCTO: " + p);
				System.out.println("VER cantidad de Producto: " + c);
				
				producto = productoDao.buscarSoloPorNombre(p);
				detalle.setCantidad(cc);
				detalleDao.crear(detalle, ver_id, producto.getId());
				
				request.setAttribute("listaProductos", listaProductos);
				request.setAttribute("usuario_id", usuario_id);
				request.setAttribute("number1", Integer.toString(cont));
			
		}
		
		this.getServletContext().getRequestDispatcher("/JSPs/registrar_Compra.jsp").forward(request, response);
		
	}

}
