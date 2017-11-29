<%-- 
    Document   : calificaciones
    Created on : 18-10-2017, 18:40:54
    Author     : Bugueño
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!-- Link Bootstrap CSS -->
        <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css" >
        <!--Link J.S.-->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

    </head>
    <body>
        <%@include file="menuCEL.jsp" %>
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