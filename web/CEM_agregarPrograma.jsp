
<%@ page contentType="text/html"
         pageEncoding="UTF-8"
         import="cem.modelo.entidad.Usuario" 
         session="true" %>
        
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Link Bootstrap CSS -->
        <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css" >
        <!--Link J.S.-->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
        <title>Agregar Programa</title>
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
                        .compareToIgnoreCase("Administrador") != 0) {
                    response.sendRedirect("no-autorizado.html");
                }
            }
        %>
        <%@include file="menuCEM.jsp" %>
        <div class="container">
            <h1>Agregar Programa</h1>
            <br/>
            <form action="cem-programas?accion=agregar" method="post" class="form-horizontal">
                <div class="form-group">
                    <label class="col-sm-2 control-label">Nombre Programa</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" name="nombrePrograma" 
                               placeholder="Ingrese el nombre del programa" required="">
                    </div>
                </div>
               
                <div class="form-group">
                    <label class="col-sm-2 control-label">Fecha Término</label>
                    <div class="col-sm-5">
                        <input type="date" class="form-control" name="fechaTermino" 
                               required="">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Valor</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" name="valor" 
                               placeholder="Ingrese el valor del programa" required="">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">${mensaje}</label>
                    <div class="col-sm-5 control-label">
                        <button type="submit" class="btn btn-default">Agregar</button>
                    </div>
                </div>
                <!--<input type="text" name="accion" value="agregarPrograma" hidden="true" />-->
            </form>
        </div>
    </body>
</html>
