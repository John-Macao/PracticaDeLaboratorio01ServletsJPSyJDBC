package ec.edu.ups.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.dao.DAOFactory;
import ec.edu.ups.dao.EmpresaDAO;
import ec.edu.ups.dao.UsuarioDAO;
import ec.edu.ups.modelo.Empresa;
import ec.edu.ups.modelo.Usuario;

/**
 * Servlet implementation class IniciarSesionController
 */
@WebServlet("/IniciarSesionController")
public class IniciarSesionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private UsuarioDAO usuarioDao;
    private EmpresaDAO empresaDao;
    private Usuario usuario;
    private Empresa empresa;
    private int empresa_id;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IniciarSesionController() {
    	usuarioDao = DAOFactory.getFactory().getUsuarioDAO();
    	empresaDao = DAOFactory.getFactory().getEmpresaDAO();
    	usuario = new Usuario();
    	empresa = new Empresa();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String url = null;
		try {
			String user = String.valueOf(request.getParameter("user"));
			String contra = String.valueOf(request.getParameter("contra"));
			usuario = usuarioDao.login(user, contra);

			if (usuario.getRol().equals("a")) {
				//System.out.println("entra al if");
				empresa_id = usuarioDao.empresaId(usuario.getId());
				empresa = empresaDao.read(empresa_id);
				request.setAttribute("usuario", usuario);
				request.setAttribute("empresa", empresa);
				
				url = "/JSPs/perfilAdmin.jsp";
			} else if (usuario.getRol() == "u") {
				//System.out.println("entra al else");
				request.setAttribute("usuario", usuario);	
				url = "/JSPs/perfilUser.jsp";
			}
		} catch (Exception e) {
			url = "/HTMLs/login.html";
		}
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
			
			if (usuario.getRol().equals("a")) {
				//Se busca la empresa del administrador
				empresa_id = usuarioDao.empresaId(usuario.getId());
				empresa = empresaDao.read(empresa_id);
				
				//Se envian los dos objetos
				request.setAttribute("usuario", usuario);
				request.setAttribute("empresa", empresa);
				
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
