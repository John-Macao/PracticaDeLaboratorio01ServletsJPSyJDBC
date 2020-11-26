<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Modificar Productos</title>
	<link rel="stylesheet" type="text/css" href="/Pedidos/CSS/estilos.css">
</head>
<body>
	<c:set var="lista" scope="request" value="${productos}"/>
	<c:set var="proInf" scope="request" value="${producto}"/>
	<c:set var="emp" scope="request" value="${empresa_id}"/>
	<c:set var="usu" scope="request" value="${usuario_id}"/>

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
				<td>
					<form action="/Pedidos/BuscarProductosController" method="post">
						<input type="text" value="m" name="page" style="display:none">
						<input type="text" value="${pro.id}" name="pro_id" style="display:none"> 
						<input type="text" name="emp_id" value="${emp}" style="display:none">
						<input type="text" name="usu_id" value="${usu}" style="display:none">
						<input type="submit" value="Modificar">
					</form> 
				</td>
			</tr>
		</c:forEach>
		</table>
		
		<form action="/Pedidos/ModificarProductosController" method="post">
			<label for="nombre">Nombre: </label>
			<input type="text" name="nombre" value="${proInf.nombre}"/>
			
			<label for="cantidad">Cantidad: </label>
			<input type="text" name="cantidad" value="${proInf.cantidad}">
			
			<label for="categoria">Categoria: </label>
            <select name="categoria">
                <option value="1">Perfumeria</option> 
                <option value="2">Maquillaje</option>
                <option value="3">Moda</option>
            </select>

			<input type="text" value="${proInf.id}" name="producto_id" style="display:none">
			
    	<input type="submit" value="Modificar Producto">
	</form>
    </div>
    
    <br>
    
    <form action="/Pedidos/BuscarUsuarioAdmin" method="post">
    	<input type="text" name="emp_id" value="${emp}" style="display:none">
		<input type="text" name="usu_id" value="${usu}" style="display:none">
		<input type="submit" value="Regresar a Inicio">
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