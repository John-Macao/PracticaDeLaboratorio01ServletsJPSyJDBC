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

<script type="text/javascript" src="/Pedidos/funciones.js"></script>
<script type="text/javascript">
       var tID = '${otherVars}';
</script>

	<% 
	String cab_id = request.getParameter("cabecera_id");	
	String usu_id = request.getParameter("usuario_id");
		
		out.print(String.format("<p> VER CABECERA ID : <strong>%s</strong></p>", cab_id));
		out.print(String.format("<p> VER CABECERA ID : <strong>%s</strong></p>", usu_id));
	
	%>

<div> llega JSP correcto</div>
	<c:set var="listadoP" scope="request" value="${listaProductos}" />
	
	<h1>Registro </h1>
	
	<div id=opcion1>
        <h1>Agregar Compra</h1>
        
        
        <form action="/Pedidos/TEST" method="post">
            
            <label for="producto">Productos: </label>
            
				<select name="item">
					<c:forEach items="${listadoP}" var="id">
       				<option>${id.nombre}</option>
					</c:forEach>
				</select>
				
				<label for="nombre">Cantidad: </label>
            	<input type="text" name="cantidad">
            	
				<input type="text" value=<%= usu_id %>  name="usuario_id" style="display:none">
            	<input type="text" value=<%= cab_id %>  name="ver_id" style="display:none">
            
            <input type="submit" value="Registrar Producto">
        </form>
    </div>
    
    
    <%
       String number1 = (String) request.getAttribute("number1");

       if (number1 != null ) {
    	   out.print(String.format("<p> AGREGADO AL CARRITO +1 </p>"));
    	   out.print(String.format("<p> CARRITO : <strong>%s</strong></p>", number1));
    	   
       }
%>


</body>
</html>



