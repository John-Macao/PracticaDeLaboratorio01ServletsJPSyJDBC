<%@page import="ec.edu.ups.dao.DAOFactory"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="ec.edu.ups.modelo.Producto"%>
<%@page import="ec.edu.ups.modelo.Categoria"%>
<%@page import="ec.edu.ups.dao.ProductoDAO"%>
<%@page import="ec.edu.ups.dao.CategoriaDAO"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Buscar Producto</title>
	<link rel="stylesheet" type="text/css" href="/Pedidos/CSS/generalAdministrador.css">
</head>
<body>

	<% 
		String emp_id = request.getParameter("empresa_id");
		String usu_id = request.getParameter("usuario_id");
	%>

	<header>
        <img id="logo" src="/Pedidos/img/logo_ups.png" alt="Logo" width="700" height="100"/>
        <h1>Menu de Inicio</h1>

        <nav id="list_1">
            <ul>
                <li><a href="login.html">Login</a></li>
                <li>Empresas</li>
            </ul>
        </nav>
    </header>

    <div class="jump"></div>
    <br>
    <form class="form" action="/Pedidos/BuscarProductosController" method="post">
    	<label for="categoria">Categoria: </label>
    	<select name="categoria">
            <option value="1">Perfumeria</option> 
            <option value="2">Maquillaje</option>
            <option value="3">Moda</option>
        </select>
        
        <input type="text" name="bus" value="cat" style="display:none">
        <input type="text" name="page" value="b" style="display:none">
        <input type="text" value=<%= emp_id %> name="empresa_id" style="display:none">
		<input type="text" value=<%= usu_id %>  name="usuario_id" style="display:none">
        
        <input type="submit" value="Buscar por Categoria">
    </form>
    <br>
    <form class="form" action="/Pedidos/BuscarProductosController" method="post">
    	<label for="nombre">Nombre del Producto: </label>
    	<input type="text" name="nombre">
    	
    	<input type="text" name="bus" value="nom" style="display:none">
        <input type="text" name="page" value="b" style="display:none">
    	<input type="text" value=<%= emp_id %> name="empresa_id" style="display:none">
		<input type="text" value=<%= usu_id %>  name="usuario_id" style="display:none">
    	
    	<input type="submit" value="Buscar por Nombre">
    </form>
    <br>
    
    <aside id="primer_metodo" style="dyssplay:none">
    	<table class='table'>
    	<% 
    		List<Producto> lista_P = (List<Producto>) request.getAttribute("productos"); 
    		ProductoDAO productoDao = DAOFactory.getFactory().getProductoDAO();
    		CategoriaDAO categoriaDao = DAOFactory.getFactory().getCategoriaDAO();
    		
    		Producto prod;	
    		Categoria cate;
    		
    		int categoria_id;
    	
    		if(lista_P != null){
    			out.println("<tr><td class='titulo'><strong>Codigo</strong></td>" +
						"<td class='titulo'><strong>Nombre</strong></td>" +
						"<td class='titulo'><strong>Cantidad</strong></td>" +
						"<td class='titulo'><strong>Categoria</strong></td></tr>");
    			
    			for(int i = 0; i < lista_P.size(); i++){
    				prod = lista_P.get(i);
    				
    				out.println("<tr><td>" + prod.getId() + "</td>");
    				out.println("<td>" + prod.getNombre() + "</td>");
    				out.println("<td>" + prod.getCantidad() + "</td>");
    				
    				categoria_id = productoDao.categoriaId(prod.getId());
    				cate = categoriaDao.read(categoria_id);
    				
    				out.println("<td>" + cate.getNombre() + "</td></tr>");
    			}
   			}
    	
    	%>
    	</table>
    </aside>
    <br>
    
    <aside id="segundo_metodo" style="dyssplay:none">
    	<table class='table'>
    	
    	<%
    		Producto prod2 = (Producto) request.getAttribute("producto");
    	
    		if(prod2 != null){
    			out.println("<tr><td class='titulo'><strong>Codigo</strong></td>" +
						"<td class='titulo'><strong>Nombre</strong></td>" +
						"<td class='titulo'><strong>Cantidad</strong></td>" +
						"<td class='titulo'><strong>Categoria</strong></td></tr>");
    			
    			out.println("<tr><td>" + prod2.getId() + "</td>");
				out.println("<td>" + prod2.getNombre() + "</td>");
				out.println("<td>" + prod2.getCantidad() + "</td>");
				
				categoria_id = productoDao.categoriaId(prod2.getId());
				cate = categoriaDao.read(categoria_id);
				
				out.println("<td>" + cate.getNombre() + "</td></tr>");
    		}
    	%>
    	</table>
    </aside>
    
    <form action="/Pedidos/BuscarUsuarioAdmin" method="post">
    	<input type="text" name="emp_id" value=<%= emp_id %>  style="display:none">
		<input type="text" name="usu_id" value=<%= usu_id %>  style="display:none">
		<input class="btng" type="submit" value="Regresar a Inicio">
    </form>
</body>

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
</html>