<%-- 
    Document   : CEM_administracion_familia
    Created on : 23-10-2017, 23:12:45
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
             * página. De no tener permiso, se le redirecciona a la página "no
             * autorizado".
             */
            if (session.getAttribute("usuarioActual") == null) {
                response.sendRedirect("no-autorizado.html");
            } else if (((Usuario) session.getAttribute("usuarioActual"))
                    .getPerfil()
                    .compareToIgnoreCase("Administrador") != 0) {
                response.sendRedirect("no-autorizado.html");
            }
        %>
        <%@include  file="menuCEM.jsp" %>
        <div class="container">
            <h2>Familias registradas</h2>
            <p>Filtrar por nombre del jefe de familia</p>
            <input class="form-control" id="myInput" type="text"
                   placeholder="Escribe aca lo que buscas..">
            <br>
            <table class="table table-bordered table-striped">
                <thead>
                    <tr>
                        <th>Nombre Jefe familia</th>
                        <th>Cantidad de integrantes</th>
                        <th>Rut</th>
                        <th>Direccion</th>
                        <th>Pais</th>
                        <th>Eliminar</th>
                        <th>Editar</th>
                    </tr>
                </thead>
                <tbody id="myTable">
                    <tr>
                        <td>Mary</td>
                        <td>5</td>
                        <td>9.805.788-6</td>
                        <td>porahi 23</td>
                        <td>EE.UU</td>
                        <td><button type="button" class="btn btn-primary">
                                <i class="glyphicon glyphicon-minus"></i>
                            </button></td>
                        <td><button type="button" class="btn btn-primary">
                                <i class="glyphicon glyphicon-pencil"></i>
                            </button></td>
                    </tr>
                    <tr>
                        <td>July</td>
                        <td>2</td>
                        <td>12.356.959-7</td>
                        <td>poraca 7</td>
                        <td>España</td>
                        <td><button type="button" class="btn btn-primary">
                                <i class="glyphicon glyphicon-minus"></i>
                            </button></td>
                        <td><button type="button" class="btn btn-primary">
                                <i class="glyphicon glyphicon-pencil"></i>
                            </button></td>
                    <tr>
                        <td>Anja</td>
                        <td>3</td>
                        <td>17.676.357-4</td>
                        <td>poracuya 80</td>              
                        <td>Canada</td>
                        <td><button type="button" class="btn btn-primary">
                                <i class="glyphicon glyphicon-minus"></i>
                            </button></td>
                        <td><button type="button" class="btn btn-primary">
                                <i class="glyphicon glyphicon-pencil"></i>
                            </button></td>
                    </tr>
                </tbody>
            </table>
            <a href="CEM_agregarFamilia.jsp" class="btn btn-primary">Registrar nueva familia</a>
        </div>


        <div class="container">
            <h2>Antecedentes</h2>      
            <p>Filtrar por...</p>
            <input class="form-control" id="myInput2" type="text" placeholder="Escribe aca lo que buscas..">
            <br>
            <table class="table table-bordered table-striped">
                <thead>
                    <tr>
                        <th>Firstname</th>
                        <th>Lastname</th>
                        <th>Email</th>
                    </tr>
                </thead>
                <tbody id="myTable2">
                    <tr>
                        <td>John</td>
                        <td>Doe</td>
                        <td>john@example.com</td>
                    </tr>
                    <tr>
                        <td>Mary</td>
                        <td>Moe</td>
                        <td>mary@mail.com</td>
                    </tr>
                    <tr>
                        <td>July</td>
                        <td>Dooley</td>
                        <td>july@greatstuff.com</td>
                    </tr>
                    <tr>
                        <td>Anja</td>
                        <td>Ravendale</td>
                        <td>a_r@test.com</td>
                    </tr>
                </tbody>
            </table>
            <button type="button" class="btn btn-primary">
                Agregar antecedente
            </button>
            <button type="button" class="btn btn-primary">
                Eliminar antecedente
            </button>
            <button type="button" class="btn btn-primary">
                Modificar antecedente
            </button>
        </div>
        <!-- <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
         <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js" integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh" crossorigin="anonymous"></script>
         <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js" integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ" crossorigin="anonymous"></script>
        -->
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
