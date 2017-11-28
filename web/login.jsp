
<%@ page contentType="text/html"
         pageEncoding="UTF-8"
         language="java"
         session="true"
         import="cem.modelo.entidad.Usuario" %>

<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Bienvenido </title>
        <!-- Link Bootstrap CSS -->
        <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
        <!--Link J.S.-->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
                integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
                crossorigin="anonymous"> </script>
    </head>
    <body>
        <%/*
            if ((Usuario) session.getAttribute("usuarioAcual") != null) {
                String perfil = ((Usuario) session
                        .getAttribute("usuarioActual"))
                        .getPerfil();

                if (perfil.compareToIgnoreCase("Administrador") == 0) {
                    response.sendRedirect("menuCEM.jsp");
                }
                else {
                    if (perfil.compareToIgnoreCase("CEL") == 0) {
                        response.sendRedirect("CEL_home.jsp");
                    }
                    else {
                        if (perfil.compareToIgnoreCase("Alumno") == 0) {
                            response.sendRedirect("Alumno_perfil.jsp");
                        }
                        else {
                            if (perfil.compareToIgnoreCase("Familia") == 0) {
                                response.sendRedirect("Familia_perfil.jsp");
                            }
                        }
                    }
                }
            }*/
        %>
        <h1>
            Sistema de intercambios estudiantiles
            <br />
            Centro de Estudios Montreal
        </h1>
        <div class="container">
            <div class="row vertical-offset-100">
                <div class="panel panel-default">
                    <!--
                    <div class="panel-heading">
                        <h3 class="panel-title"> Ingrese al sistema :)</h3>
                    </div>
                    -->
                    <div class="panel-body">
                        <form class="form-horizontal" action="ingresar" method="post">
                            <fieldset>
                                <div class="form-group">
                                    <label for="nombreUsuario" class="col-lg-2 control-label">Nombre de Usuario:</label>
                                    <div class="col-xs-3">
                                        <input type="text" class="form-control" name="nombreUsuario"
                                               required="true" id="nombreUsuario"
                                               placeholder="nombre Usuario">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label for="ejemplo_password_3" class="col-lg-2 control-label">Contraseña</label>
                                    <div class="col-xs-3">
                                        <input type="password" class="form-control" name="contrasena"
                                               required="true" id="ejemplo_password_3" 
                                               placeholder="Contraseña">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-lg-offset-2 col-lg-10">
                                        <button type="submit" class="btn btn-default">Entrar</button>
                                    </div>
                                </div>   
                                <h5>Si no estas registrado y eres alumno o familia anfitriona elije una opcion</h5>
                                <div class="row">
                                    <div class="col-xs-3 col-sm-6 col-md-6">
                                        <a href="registro/alumno.jsp" class="btn btn-lg btn-primary btn-block">Si eres alumno matriculado, regístrate aquí</a>
                                    </div>                                  
                                </div>
                                <br/>   
                                <div class="row">
                                    <div class="col-xs-3 col-sm-6 col-md-6">
                                        <a href="registro/familia.jsp" class="btn btn-lg btn-primary btn-block">Si deseas ser una familia anfitriona, regístrate aquí</a>
                                    </div>   
                                </div>
                                <label> ${mensaje} </label>         
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
