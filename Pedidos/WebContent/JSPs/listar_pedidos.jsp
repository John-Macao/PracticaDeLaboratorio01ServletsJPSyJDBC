<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="java.io.PrintWriter"%>
<%@page import="ec.edu.ups.dao.DAOFactory"%>
<%@page import="ec.edu.ups.modelo.Producto"%>
<%@page import="ec.edu.ups.modelo.Detalle"%>
<%@page import="ec.edu.ups.modelo.Cabecera"%>
<%@page import="ec.edu.ups.dao.DetalleDAO"%>
<%@page import="ec.edu.ups.dao.ProductoDAO"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Listar Pedidos</title>
	<link rel="stylesheet" type="text/css" href="/Pedidos/CSS/generalAdministrador.css">
</head>
<body>
	<c:set var="lista_U" scope="request" value="${usuarios}"/>
	
	<% 
		int emp = (Integer) request.getAttribute("empresa_id");
		int usu = (Integer) request.getAttribute("usuario_id"); 
	%>

	<header>
        <img id="logo" src="/Pedidos/img/logo_ups.png" alt="Logo" width="700" height="100"/>
        <h1>Menu de Inicio</h1>

        <nav id="list_1">
            <ul>
                <li><a href="login.html">Login</a></li>
                <li>Empresas</li>
                <li>Productos</li>
            </ul>
        </nav>
    </header>

    <div class="jump"></div>
    
    <div id="usuarios">
    	<h1 class="tema">Usuarios</h1>
    	
    	<table class="table" id="tabla_users">
			<tr>
				<td class="titulo"><strong>Nombre</strong></td>
				<td class="titulo"><strong>Apellido</strong></td>
				<td class="titulo"><strong>Pedidos</strong></td>
			</tr>
			
			<c:forEach var="us" items="${lista_U}">
				<tr>
					<td>${us.nombre}</td>
					<td>${us.apellido}</td>
					<td>
						<form action="/Pedidos/ListarCabecerasController" method="post">
							<input type="text" value="${us.id}" name="usuarioS_id" style="display:none">
							<input type="text" value="lp" name="page" style="display:none">
							<input type="text" value="<%= usu %>" name="usuario_id" style="display:none"> 
							<input type="text" value="<%= emp %>" name="empresa_id" style="display:none">
							<input type="submit" value="Listar">
						</form> 
					</td>
				</tr>
			</c:forEach>
		</table>
    </div>
    
    <div id="pedidos">
  		<% 
	  		List<Cabecera> lista_C = (List<Cabecera>) request.getAttribute("cabeceras");
			Cabecera cab;
	  		
			if(lista_C != null){
				int usuS = (Integer) request.getAttribute("usuarioS_id");
				
	   			for(int i = 0; i < lista_C.size(); i++){
	   				cab = lista_C.get(i);
	   				
	   				out.println("<h4>Pedido " + (i+1) + "</h4>");
	   				
	   				out.println("<table id='tabla_cabeceras'>" +
	   				"<tr><td><strong>Numero</strong></td>" +
	   				"<td><strong>Estado</strong></td></tr>");
	   				
	   				out.println("<tr><td>" + cab.getId() + "</td>" + 
	   							"<td>" + cab.getEstado() + "</td></tr></table>");
						
				}
			}
		%>	
    </div>
    
    <div id="detalle">
		<% 
			List<Detalle> lista_D = (List<Detalle>) request.getAttribute("detalles");
			DetalleDAO detalleDao = DAOFactory.getFactory().getDetalleDAO();
			ProductoDAO productoDao = DAOFactory.getFactory().getProductoDAO();
			
			Detalle deta = new Detalle();
			Producto prod = new Producto();
			
			int producto_id;
			
			if(lista_D != null){
				
				for (int i = 0; i < lista_D.size(); i++){
					Detalle control = lista_D.get(i);
					deta = control;
					
					producto_id =  detalleDao.obtenerProductoId(deta);
					
					prod = productoDao.read(producto_id);
					
	                out.println("<tr><td>" + prod.getNombre() + "</td>");
	                out.println("<td>" + control.getCantidad() + "</td></tr>");
       			}
			}
			
		%>
    </div>
    
    <form action="/Pedidos/BuscarUsuarioAdmin" method="post">
    	<input type="text" name="emp_id" value="<%= emp %>" style="display:none">
		<input type="text" name="usu_id" value="<%= usu %>" style="display:none">
		<input class="btng" type="submit" value="Regresar a Inicio">
    </form>
    
    <footer>
		<fieldset>
	        <legend>Institucion</legend>
	        <span>
	          Universidad: Universidad Politecnica Salesiana<br>
	          Sede: Cuenca<br>
	          Periodo: 57<br>
	        </span>
	    </fieldset>
	
	    <fieldset>
	        <legend>Contacto</legend>
	        <span>
	          Autores: Robbyn Taurino Reyes Duchitanga<br>
	          Correo: <a href="mailto:rreyesd@est.ups.edu.ec">rreyesd@est.ups.edu.ec</a><br>
	          Telefono: <a href="tel:+0969784090">0969784090</a><br>
	        </span>
	    </fieldset>
	</footer>
</body>
</html>