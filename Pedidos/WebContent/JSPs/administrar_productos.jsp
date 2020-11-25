<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>Administrar Productos</title>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="/Pedidos/CSS/estilos.css">
    <script src="/Pedidos/JavaSs/funciones.js"></script>
</head>
<body>
	 <header>
        <img src="logo_ups.png" alt="Logo" width="700" height="100" />
        <h2>Menu de Inicio</h2>

        <nav id="list_1">
            <ul>
                <li><a href="aministrar_productos.html">Login</a></li>
                <li>Empresas</li>
                <li>Productos</li>
            </ul>
        </nav>
    </header>

    <div class="jump"></div>

    <aside>
        <nav id="column_left">
            <ul>
                <li><input type="button" value="Agregar Productos" onclick="llamar_opcion1()"></li>
                <li><input type="button" value="Modificar Productos" onclick="llamar_opcion2()"></li>
                <li><input type="button" value="Buscar Productos" onclick="llamar_opcion3()"></li>
            </ul>
        </nav>
    </aside>

    <div id=opcion1 style="display:none">
        <h1>Agregar Productos</h1>

        <form action="/Pedidos/RegistrarProductosController" method="post">
            <label for="nombre">Nombre del Producto: </label>
            <input type="text" name="nombre">

            <label for="cantidad">Cantidad en Stock: </label>
            <input type="text" name="cantidad">

            <label for="categoria">Categoria: </label>
            <select name="categoria">
                <option value="perfumeria">Perfumeria</option> 
                <option value="maquillaje">Maquillaje</option>
                <option value="moda">Moda</option>
            </select>

            <input type="submit" value="Registrar Producto">
        </form>
    </div>

    <div id=opcion2 style="display:none">
        <h1>Modificar Productos</h1>

        <form>
            <label>Nombre: </label>
            <input></input>
        </form>
    </div>

    <div id=opcion3 style="display:none">
        <h1>Buscar Productos</h1>

        <form>
            <label for="filtro">Filtro: </label>
            <select name="filtro">
                <option value="nombre">Nombre</option> 
                <option value="categoria">Categoria</option>
            </select>
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