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
	
	
	<c:set var="listadoSinD" scope="request" value="${listaCabeceraSinDelete2}" />


	<table>
		<tr>
			<td><strong>C�digo   </strong></td>
			<td><strong>    Estado </strong></td>
		</tr>
		<c:forEach var="SinD" items="${listadoSinD}">
			<tr>
				<td>${SinD.id}</td>
				<td>${SinD.estado}</td>
				<td> <a href="/Pedidos/ListarCompraController2?id=${SinD.id}&usuario_id=<%= usu_id %>" >Ver Detalle	</a> </td>
			</tr>
		</c:forEach>
	</table>
	
    <form action="/Pedidos/BuscarUsuario" method="post">
    	<input type="text" value=<%= usu_id %>  name="usuario_id" style="display:none">
		<input type="submit" value="Regresar al menu">
    </form>




</body>
</html>