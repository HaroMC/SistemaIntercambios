<%-- 
    Document   : Alumno_perfil
    Created on : 21-11-2017, 12:42:01
    Author     : Bugueño
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8" session="true" %>

<%  if (session.getAttribute("usuarioActual") == null) {
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
        <%@include file="menuAlumno.jsp" %>
        <div class="row">
            <div class="col-md-8">Aca ira la informacion del alumno</div>
            
        </div>
        
    </body>
</html>
