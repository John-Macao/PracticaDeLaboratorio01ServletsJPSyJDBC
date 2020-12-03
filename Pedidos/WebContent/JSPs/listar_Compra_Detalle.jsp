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
		
		out.print(String.format("<p> VER USUARIO ID : <strong>%s</strong></p>", usu_id));
	
	%>
	
	<c:set var="listadoD2" scope="request" value="${listaDetalle2}" />
	
	
	<table>
		<tr>
			<td><strong>ID      </strong></td>
			<td><strong>    Cantidad</strong></td>
			<td><strong>    Producto</strong></td>
			
		</tr>
		<c:forEach var="d2" items="${listadoD2}">
			<tr>
				<td>${d2.id}</td>
				<td>${d2.cantidad}</td>
				<td>${d2.producto.getNombre()}</td>
				
			</tr>
		</c:forEach>
	</table>
	
    <form action="/Pedidos/ListarCompraController" method="post">
    	<input type="text" value=<%= usu_id %>  name="usuario_id" style="display:none">
		<input type="submit" value="Regresar ">
    </form>

	

</body>
</html>