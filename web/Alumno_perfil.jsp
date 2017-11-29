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
        <h1>aca va la infor del alumno y si se puede ver que programa tiene asignado y las notas que posee, si no se debe crear otra pestaña para poner esa info</h1>
         <div class="container">
            <h2>Para colocar una calificacion selecciona un programa</h2>      
            <p>Filtra tu busqueda aqui:</p>
            <input class="form-control" id="myInput" type="text" placeholder="Escribe aca lo que buscas..">
            <br>
            <table class="table table-bordered table-striped">
                <thead>
                    <tr>
                        <th>Nombre del programa </th>
                        <th>Asignatura</th>
                        <th></th>
                    </tr>
                </thead>
                <tbody id="myTable">
                    <tr>
                        <td></td>
                        <td></td>
                        <td><button type="button" class="btn btn-primary">
                                Selecccionar
                            </button></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>             
                </tbody>
            </table>
            <!--
                        <button type="button" class="btn btn-primary">
                            Rechazar
                        </button>
            -->
        </div>
        
       <br/>
       <br/>
       <div class="container">
            <h2>Notas por asignaturas segun programa</h2>                
            <p>Si necesitas buscar algo especifico puedes hacerlo aqui:</p>
            <input class="form-control" id="myInput2" type="text"
                   placeholder="Escribe aca lo que buscas..">
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

        
    </body>
</html>
