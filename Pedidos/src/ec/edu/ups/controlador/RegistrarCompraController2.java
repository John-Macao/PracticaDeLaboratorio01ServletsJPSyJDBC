package ec.edu.ups.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrarCompraController2
 */
@WebServlet("/RegistrarCompraController2")
public class RegistrarCompraController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
    public RegistrarCompraController2() {
        
    	
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = null;
		
		try {
			
			
		} catch (Exception e) {
			System.out.println("Error Listar: " + e);
			url = "/JSPs/error.jsp";
		}
		
		
		
		getServletContext().getRequestDispatcher(url).forward(request, response);	
	}

}
