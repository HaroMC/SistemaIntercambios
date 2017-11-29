
<%@ page contentType="text/html"
         pageEncoding="UTF-8"
         language="java"
         session="true"
         import="cem.modelo.entidad.Usuario" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CEL Home</title>
        <!-- Link Bootstrap CSS -->
        <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css" >
        <!--Link J.S.-->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
                integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
                crossorigin="anonymous"> </script>
    </head>
    <body>
        <%
            /**
             * Código que verifica si el usuario en sesión puede visitar esta
             * página. De no tener permiso, se le redirecciona a la página
             * "no autorizado".
             */
            if (session.getAttribute("usuarioActual") == null) {
                response.sendRedirect("no-autorizado.html");
            }
            else {
                if (((Usuario) session.getAttribute("usuarioActual"))
                        .getPerfil()
                        .compareToIgnoreCase("CEL") != 0) {
                    response.sendRedirect("no-autorizado.html");
                }
            }
        %>
        <%@include file="menuCEL.jsp" %>
        <h1>info del cel mas una imagen, todo debe quedar centrado, imagen a la izquierda e informacion a la derecha</h1>

    </body>
</html>
