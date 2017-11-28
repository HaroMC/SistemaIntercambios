<%-- 
    Document   : menuAlumno
    Created on : 20-11-2017, 23:11:45
    Author     : Bugueño
--%>

<%@ page contentType="text/html"
         pageEncoding="UTF-8"
         language="java"
         session="true"
         import="cem.modelo.entidad.Usuario" %>

<!--
    Scriptlet que verifica el permiso de visualización de la página según el
    perfil del usuario.
-->
<%  if (session.getAttribute("usuarioActual") == null) {
        response.sendRedirect("no-autorizado.html");
    } else if (((Usuario) session.getAttribute("usuarioActual"))
            .getPerfil().compareToIgnoreCase("Alumno") != 0) {
        response.sendRedirect("no-autorizado.html");
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> 
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    </head>
    <body>
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#"> WebSiteName </a>
                </div>
                <ul class="nav navbar-nav">
                    <li><a href="Alumno_perfil.jsp"> Perfil </a></li>                    
                    <li><a href="alumnos-programas"> Postulaciones </a></li>
                </ul>
                <label class="nav navbar-nav navbar-right label label-default" style="color: white; width: 10%; height: 50px">
                    <br/>
                    Bienvenido, <%= ((Usuario) (session.getAttribute("usuarioActual"))).getNombre()%>
                    <br/>
                    <br/>
                    <form  class="label label-default" style="color: #204d74" action="salir" method="get">
                        <input type="submit" value="Cerrar sesión" />
                    </form>
                </label>
            </div>
        </nav>
    </body>
</html>
