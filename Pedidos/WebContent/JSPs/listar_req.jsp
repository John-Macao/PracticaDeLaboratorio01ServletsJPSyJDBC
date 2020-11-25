<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado </title>
</head>
<body>

<div> llega JSP correcto</div>
	<c:set var="cabecera" scope="request" value="${cab}" />
	
	<!-- 
	<c:set var="detalle" scope="request" value="${det}" />
	 -->
	<h1>Listaaaaaa </h1>

	<table>
		<tr>
			<td><strong>Id</strong></td>
			<td><strong>estado</strong></td>
		</tr>
		<c:forEach var="c" items="${cabecera}">
			<tr>
				<td>${c.cab_id}</td>
				<td>${u.cab_estado}</td>
			</tr>
		</c:forEach>
		
		<!-- 
		<c:forEach var="d" items="${detalle}">
			<tr>
				<td>${d.det_cantidad}</td>
			</tr>
		</c:forEach>
		 -->
	</table>
	
	
	<!-- 
	<a href="/EjemploPersonaWebJDBC/index.html">Regresar al index</a>
	 -->
	

</body>
</html>