
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Buscar Producto</title>
	<link rel="stylesheet" type="text/css" href="/Pedidos/CSS/estilos.css">
</head>
<body>
	<header>
        <img src="logo_ups.png" alt="Logo" width="700" height="100"/>
        <h2>Buscar Producto</h2>

        <nav id="list_1">
            <ul>
                <li><a href="login.html">Login</a></li>
                <li>Empresas</li>
                <li>Productos</li>
            </ul>
        </nav>
    </header>

    <div class="jump"></div>
    
    <form action="/Pedidos/BuscarController?bus=cat&page=b" method="get">
    	<label for="categoria">Categoria: </label>
    	<select name="categoria">
            <option value="1">Perfumeria</option> 
            <option value="2">Maquillaje</option>
            <option value="3">Moda</option>
        </select>
        
        <input type="submit" value="Buscar por Categoria">
    </form>
    
    <form action="/Pedidos/BuscarController?bus=nom&page=b" method="get">
    	<label for="nombre">Nombre del Producto: </label>
    	<input type="text" name="nombre">
    	
    	<input type="submit" value="Buscar por Nombre">
    </form>
    
    <aside>
    
    </aside>
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