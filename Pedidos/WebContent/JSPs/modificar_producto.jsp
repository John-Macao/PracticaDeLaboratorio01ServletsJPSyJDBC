<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Modificar Productos</title>
	<link rel="stylesheet" type="text/css" href="/Pedidos/CSS/estilos.css">
	<script></script>
</head>
<body>
	
	<c:set var="lista" scope="request" value="${productos}"/>

	<header>
        <img src="logo_ups.png" alt="Logo" width="700" height="100"/>
        <h2>Menu de Inicio</h2>

        <nav id="list_1">
            <ul>
                <li><a href="login.html">Login</a></li>
                <li>Empresas</li>
                <li>Productos</li>
            </ul>
        </nav>
    </header>

    <div class="jump"></div>

    <div id=opcion2>
        <h1>Modificar Productos</h1>
        
        <table>
		<tr>
			<td><strong>Nombre</strong></td>
			<td><strong>Cantidad</strong></td>
			<td><strong>Categoria</strong></td>
			<td><strong>Modificar</strong></td>
		</tr>
		<c:forEach var="pro" items="${lista}">
			<tr>
				<td>${pro.nombre}</td>
				<td>${pro.cantidad}</td>
				<td>${pro.categoria}</td>
				<td><input type="button" value="Modificar${pro.id}" onclick="mostrarFormulario()"></td>
			</tr>
			
		</c:forEach>
	</table>

        <form id="modificar" action="/Pedidos/ModificarProductosController" method="post">
        	
        </form>
    </div>
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