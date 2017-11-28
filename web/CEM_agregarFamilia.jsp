<%-- 
    Document   : CEM_agregarFamilia
    Created on : 30-10-2017, 5:18:28
    Author     : Bugueño
--%>
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
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
                integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
                crossorigin="anonymous"> </script>
        <title> JSP Page </title>
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
        <h1>Formulario de familia</h1>
        <h5>Los datos ingresados corresponden al jefe de familia</h5>
        <br/>
        <form action="cem-familias?accion=agregar" method="post" class="form-horizontal">

            <div class="form-group">
                <label class="col-sm-2 control-label">Fecha de nacimiento</label>
                <div class="col-sm-5">
                    <input type="date" class="form-control" name="fechaNacimiento" 
                           placeholder="fecha de nacimiento" required="true">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Digito verificador</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" name="digito" 
                           placeholder="digito verificador" required="true">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Rut</label>
                <div class="col-sm-5">
                    <input type="number" class="form-control" name="rutPersona" 
                           placeholder="Ingrese el Rut jefe de familia" required="">
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Nombre completo</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" name="nombres" 
                           placeholder="Ingrese Nombre completo" required="true">
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-2 control-label">Domicilio</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" name="domicilio" required="true"
                           placeholder="Ingrese el domicilio"> 
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Ciudad</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" name="ciudad" required="true"
                           placeholder="Ingrese la ciudad"> 
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Pais</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" name="pais" required="true"
                           placeholder="Ingrese el país"> 
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Correo</label>
                <div class="col-sm-5">
                    <input type="email" class="form-control" name="correo" required="true"
                           placeholder="Ingrese el Correo"> 
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Telefono</label>
                <div class="col-sm-5">
                    <input type="text" class="form-control" name="telefono" required="true"
                           placeholder="Ingrese el telefono"> 
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">Cantidad de integrantes</label>
                <div class="col-sm-5">
                    <input type="number" class="form-control" name="ingrese cantidad de integrantes " required="true"
                           placeholder="Cantidad de integrantes"> 
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-2 control-label">${mensaje}</label>
                <div class="col-sm-5 control-label">
                    <button type="submit" class="btn btn-default">Agregar</button>
                </div>
            </div>
            <input type="text" name="accion" value="agregarFamilia" hidden="true" />
        </form>
    </body>
</html>
