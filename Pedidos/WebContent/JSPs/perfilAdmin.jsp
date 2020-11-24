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

	<h1>Persona encontrada</h1>		
		
	<p>Id: ${usuA.id}</p>
	<p>Nombre: ${usuA.nombre}</p>
	<p>Apellid: ${usuA.apellido}</p>
</body>
</html>