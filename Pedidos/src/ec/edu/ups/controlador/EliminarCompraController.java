package ec.edu.ups.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.CabeceraDAO;
import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.modelo.Cabecera;

/**
 * Servlet implementation class EliminarCompraController
 */
@WebServlet("/EliminarCompraController")
public class EliminarCompraController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private CabeceraDAO cabeceraDao;
	private Cabecera cabecera;
	
	
	
    public EliminarCompraController() {
    	cabeceraDao = DAOFactory.getFactory().getCabeceraDAO();
        cabecera = new Cabecera();
    	
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		String estado="D";
		
		try {
			String id = String.valueOf(request.getParameter("idR"));
			System.out.println(id);
			
			int idR = Integer.parseInt(id);
			System.out.println("verificar valor entero:" + idR);
			cabecera = cabeceraDao.read(idR);
			cabecera.setEstado(estado);
			
			
			System.out.println("ver estado de cabecera base:     " + cabecera.getEstado() );
			System.out.println("ver id de cabecera base    " + cabecera.getId() );
			System.out.println("ver id recuperado   " + id );
			
			cabeceraDao.update(cabecera);
			
			System.out.println("Estado actualizado ---- ");
			
		} catch (Exception e) {
			url = "/HTMLs/login.html";
		}
		
		
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
