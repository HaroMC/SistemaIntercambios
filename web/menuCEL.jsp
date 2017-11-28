<%@ page contentType="text/html"
         pageEncoding="UTF-8"
         language="java"
         import="cem.modelo.entidad.Usuario" 
         session="true" %>

<%  if (session.getAttribute("usuarioActual") == null) {
        response.sendRedirect("no-autorizado.html");
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> CEL Home </title>
        <!-- Link Bootstrap CSS -->
        <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
        <!--Link J.S.-->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
                integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>
    </head>
    <body>
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">WebSiteName</a>
                </div>
                <ul class="nav navbar-nav">
                    <li><a href="CEL_home.jsp">Home</a></li>
                    <li><a href="CEL_calificaciones.jsp">Calificaciones</a></li>
                    <li><a href="cel-programas"> Postulaciones </a></li>
                </ul>
                <!-- ------------------------------------------------------- -->
                <label class="nav navbar-nav navbar-right label label-default" style="color: white; width: 10%; height: 50px">
                    <br/>
                    Bienvenido, <%= ((Usuario) (session.getAttribute("usuarioActual"))).getNombre()%>
                    <br/>
                    <br/>
                    <form  class="label label-default" style="color: #204d74" action="salir" method="get">
                        <input type="submit" value="Cerrar sesión" />
                    </form>
                </label>
                <!-- ------------------------------------------------------- -->
            </div>
        </nav>

    </body>
</html>
