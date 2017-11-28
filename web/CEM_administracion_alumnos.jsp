<%-- 
    Document   : CEM_administracion_alumnos
    Created on : 25-10-2017, 19:37:39
    Author     : Bugueño
--%>
<%@ page contentType="text/html"
         pageEncoding="UTF-8"
         import="cem.modelo.entidad.Usuario" 
         session="true" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


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

        <!--  EJEMPLO DE COMO DARLE UNA CLASE A UN BOTON, aveces lo olvido :V
           <a href="CEM_agregarAlumno.jsp" class="btn btn-primary">agregar alumno</a>
        -->

        <!--tabla que representa el listado de alumnos-->
        <br/>
        <div class="container">
            <h2>Alumnos existentes</h2>      
            <p>Si necesitas buscar un Alumno en especifico puedes hacerlo aqui:</p>
            <input class="form-control" id="myInput" type="text" placeholder="Escribe aca lo que buscas..">
            <br/>
            <table class="table table-bordered table-striped">
                <thead>
                    <tr>
                        <th>Rut</th>
                        <th>Nombre Completo</th>
                        <th>Nombre de Usuario</th>
                        <th>Telefono</th>                       
                        <th>Eliminar</th>
                        <th>Ver Datos</th>
                    </tr>
                </thead>
                <!--<form action="cem-alumnos?accion=eliminar" method="get">-->
                <tbody id="myTable">
                    <c:forEach var="p" items="${listadoAlumnos}">
                        <tr>
                            <td> <c:out value="${p.rut}" /> </td>
                            <td> <c:out value="${p.nombreCompleto}" /> </td>
                            <td> <c:out value="${p.usuario.nombre}" /> </td>
                            <td> <c:out value="${p.telefono}" /> </td>
                            <td>
                                <input type="hidden"
                                       value="<c:out value="${p.rut}"/>"
                                       name="rutBusqueda"/>
                            </td>
                            <td>
                                <button type="button" class="btn btn-primary">
                                    <i class="glyphicon glyphicon-minus"></i>
                                </button>
                            </td>
                            <td>
                                <button type="button" class="btn btn-primary">
                                    <i class="">Ver notas</i>
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <!--</form>-->
        </div>

        <div class="container">
            <h2>Notas por asignaturas segun programa</h2>                
            <p>Si necesitas buscar algo especifico puedes hacerlo aqui:</p>
            <input class="form-control" id="myInput2" type="text" placeholder="Escribe aca lo que buscas..">
            <br/>
            <table class="table table-bordered table-striped">
                <thead>
                    <tr>
                        <th>Nombre  Completo</th>
                        <th>Programa</th>
                        <th>Estado</th>
                        <th>Asignatura</th>
                        <th>Nota 1</th>
                        <th>Nota 2</th>
                        <th>Nota 3</th>
                        <th>Nota Final</th>
                    </tr>
                </thead>
                <tbody id="myTable2">
                    <tr>
                        <td>Cecilia Fernanda Moreno Lira</td>
                        <td>Programa1</td>  
                        <td>Terminado</td>
                        <td>Asignatura 1</td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td>Asignatura 2</td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td>Asignatura 3</td> 
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                       <tr>
                        <td>Cecilia Fernanda Moreno Lira</td>
                        <td>Programa2</td>  
                        <td>Cursando</td>
                        <td>Asignatura 1</td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td>Asignatura 2</td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td>Asignatura 3</td> 
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                </tbody>
            </table>           
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
     <script>
        $(document).ready(function () {
            $("#myInput2").on("keyup", function () {
                var value = $(this).val().toLowerCase();
                $("#myTable2 tr").filter(function () {
                    $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
                });
            });
        });
    </script>
</html>
