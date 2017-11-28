
<%@ page contentType="text/html"
         pageEncoding="UTF-8"
         import="cem.modelo.entidad.Usuario" 
         session="true" %>
        
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
            <h1>Postulasiones de los alumnos a los programas</h1>
            <p>Filtra tu busqueda aqui:</p>
            <input class="form-control" id="myInput" type="text" placeholder="Escribe aca lo que buscas..">
            <br>
            <table class="table table-bordered table-striped">
                <thead>
                    <tr>
                        <th>Nombre del programa al que postula</th>
                        <th>Postulantes</th>
                        <th>Estado</th>
                        
                        <th></th>
                    </tr>
                </thead>
                <tbody id="myTable">
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        
                        <td><button type="button" class="btn btn-primary">
                                Aceptar
                            </button></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        
                        <td></td>
                    </tr>   
                    <tr>


                    </tr>
                </tbody>
            </table>
            <!--
                        <button type="button" class="btn btn-primary">
                            Rechazar
                        </button>
            -->
        </div>
    </body>
    <script>
        $(document).ready(function () {
            $("#myInput").on("keyup", function () {
                var value = $(this).val().toLowerCase();
                $("#myTable tr").filter(function () {
                    $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
                });
            });
        });
    </script>
</html>

