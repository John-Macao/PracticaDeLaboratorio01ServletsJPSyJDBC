<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Perfil Admin</title>
</head>
<body>
	<c:set var="usuA" scope="request" value="${usuario}" />
	<c:set var="empA" scope="request" value="${empresa}" />

	<h1>Administrador</h1>		
		
	<p>Id: ${usuA.id}</p>
	<p>Nombre: ${usuA.nombre}</p>
	<p>Apellido: ${usuA.apellido}</p>
	<p>Empresa: ${empA.nombre} </p>
	
	<a href="/Pedidos/JSPs/administrar_productos.jsp">Administrar Productos</a>
	<a href="/Pedidos/JSPs/registrar_producto.jsp?emp=${empA.id}">Registrar Producto</a>
	<a href="/Pedidos/ListarProductosController">Modificar Producto</a>
	<a href="/Pedidos/BuscarProductosController">Buscar Producto</a>
	<a href="/Pedidos/JSPs/listar_pedidos.jsp">Listar Pedidos</a>
	<a href="/Pedidos/JSPs/administrar_pedidos.jsp">Administrar Pedidos</a>
	
</body>
</html>