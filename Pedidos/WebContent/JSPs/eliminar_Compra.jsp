<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<% 
		String usu_id = request.getParameter("usuario_id");
	
		out.print(String.format("<p> VER cabecera ID : <strong>%s</strong></p>", usu_id));
	%>
	
	<c:set var="listadoC" scope="request" value="${listaCabecera}" />
	
	
	<table>
		<tr>
			<td><strong>Código </strong></td>
			<td><strong>  Estado</strong></td>
		</tr>
		<c:forEach var="c" items="${listadoC}">
			<tr>
				<td>${c.id}</td>
				<td>${c.estado}</td>
				<td> <a href="/Pedidos/ListarCompraController3?id=${c.id}&usuario_id=<%= usu_id %>" >Ver Detalle	</a> </td>
				<td> <a href="/Pedidos/EliminarCompraController2?id=${c.id}&usuario_id=<%= usu_id %>">	Eliminar Pedido</a> </td>
				
			</tr>
		</c:forEach>
	</table>
	
	
    <form action="/Pedidos/BuscarUsuario" method="post">
    	<input type="text" value=<%= usu_id %>  name="usuario_id" style="display:none">
		<input type="submit" value="Regresar al menu">
    </form>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

</body>
</html>