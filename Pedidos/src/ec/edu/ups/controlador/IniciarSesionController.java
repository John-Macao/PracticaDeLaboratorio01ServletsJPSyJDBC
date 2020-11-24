package ec.edu.ups.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.modelo.Usuario;

/**
 * Servlet implementation class IniciarSesionController
 */
@WebServlet("/IniciarSesionController")
public class IniciarSesionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UsuarioDAO usuarioDao;
    private Usuario usuario;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IniciarSesionController() {
    	usuarioDao = DAOFactory.getFactory().getUsuarioDAO();
    	usuario = new Usuario();
        // TODO Auto-generated constructor stub
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
    	String url = null;
    	
		try {
			String user = String.valueOf(request.getParameter("user"));
			String contra = String.valueOf(request.getParameter("contra"));
			usuario = usuarioDao.login(user, contra);

			if (usuario.getRol() == "a") {
				request.setAttribute("usuario", usuario);	
				url = "/JSPs/perfilAdmin.jsp";
			} else if (usuario.getRol() == "u") {
				request.setAttribute("usuario", usuario);	
				url = "/JSPs/perfilUser.jsp";
			}
		} catch (Exception e) {
			url = "/HTMLs/login.html";
		}
		//getServletContext().getRequestDispatcher(url).forward(request, response);
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = null;
		try {
			String user = String.valueOf(request.getParameter("user"));
			String contra = String.valueOf(request.getParameter("contra"));
			usuario = usuarioDao.login(user, contra);
			
			System.out.println(user);
			System.out.println(contra);
			System.out.println(usuario.getUsuario());
			System.out.println(usuario.getContrasena());
			System.out.println(usuario.getRol());
			
			if (usuario.getRol().equals("a")) {
				System.out.println("entra al if");
				request.setAttribute("usuario", usuario);	
				url = "/JSPs/perfilAdmin.jsp";
			} else if (usuario.getRol() == "u") {
				System.out.println("entra al else");
				request.setAttribute("usuario", usuario);	
				url = "/JSPs/perfilUser.jsp";
			}
		} catch (Exception e) {
			url = "/HTMLs/login.html";
		}
		getServletContext().getRequestDispatcher(url).forward(request, response);
	}

}
