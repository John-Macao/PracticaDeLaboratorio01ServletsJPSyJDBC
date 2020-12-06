<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Perfil Admin</title>
	<link rel="stylesheet" type="text/css" href="/Pedidos/CSS/perfil.css">
</head>
<body>
	<c:set var="usuA" scope="request" value="${usuario}" />
	<c:set var="empA" scope="request" value="${empresa}" />

	<header>
		<h1>Administrador</h1>		
		<hr color="#313b4a"  width="98%">
		<h3 class="datos">Id: ${usuA.id}</h3>
		<h3 class="datos">Nombre: ${usuA.nombre}</h3>
		<h3 class="datos">Apellido: ${usuA.apellido}</h3>
		<h3 class="datos">Empresa: ${empA.nombre} </h3>
	</header>

		
	
	<h2> Actividades de administrador </h2>
	
	<form action="/Pedidos/JSPs/registrar_producto.jsp" method="post">
		<input type="text" name="empresa_id" value="${empA.id}" style="display:none">
		<input type="text" name="usuario_id" value="${usuA.id}" style="display:none">
		
		<input type="submit" value="Registrar Productos">
	</form>
	
	<form action="/Pedidos/ListarProductosController" method="post">
		<input type="text" name="empresa_id" value="${empA.id}" style="display:none">
		<input type="text" name="usuario_id" value="${usuA.id}" style="display:none">
		<input type="text" name="page" value="m" style="display:none">
		
		<input type="submit" value="Modificar Productos">
	</form>
	
	<form action="/Pedidos/JSPs/buscar_producto.jsp" method="post">
		<input type="text" name="empresa_id" value="${empA.id}" style="display:none">
		<input type="text" name="usuario_id" value="${usuA.id}" style="display:none">
		<input type="text" name="page" value="b" style="display:none">
		
		<input type="submit" value="Buscar Productos">
	</form>
	
	<form action="/Pedidos/ListarUsuariosController" method="post">
		<input type="text" name="empresa_id" value="${empA.id}" style="display:none">
		<input type="text" name="usuario_id" value="${usuA.id}" style="display:none">
		<input type="text" name="page" value="cp" style="display:none">
		
		<input type="submit" value="Administrar Pedidos">
	</form>
	
	<form action="/Pedidos/ListarUsuariosController" method="post">
		<input type="text" name="empresa_id" value="${empA.id}" style="display:none">
		<input type="text" name="usuario_id" value="${usuA.id}" style="display:none">
		<input type="text" name="page" value="lp" style="display:none">
		
		<input type="submit" value="Listar Pedidos">
	</form>
	
	<form action="/Pedidos/CerrarSesion" method="post"> 
		<input type="submit" value="Cerrar Sesion">
	</form>
	
</body>
</html>