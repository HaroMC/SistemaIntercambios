
<%@ page contentType="text/html"
         pageEncoding="UTF-8"
         language="java"
         session="true"
         import="cem.modelo.entidad.Usuario" %>
 <%@include file="menuCEL.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CEL Home</title>
        <!-- Link Bootstrap CSS -->
        <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css" >
        <!--Link J.S.-->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>
        <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/estiloFinal.css">
    </head>
    <body>
           <div class="row">            
            <div class="col-sm-3 col-md-4">                  
                <img id="logoUsuario" src="img/logo_alumnos.jpg" style="width:30%; margin-left:70%" >
            </div>
            <div class="col-sm-3 col-md-4">
                <p> Nombre del alumno: "LLENAR CAMPO"</p>
                <p> Pais: "LLenar Campo"</p>
                <p>Ciudad: "LLenar Campo"</p>
                <p>Correo: "LLenar Campo"</p>
                <p>Telefono: "LLenar Campo"</p>
            </div>
        </div>
    </body>
</html>
