<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post" action="ProcesaBusquedaRut">
            <table class="table table-bordered table-striped">
                <thead>
                    <tr>
                        <th>Rut</th>
                        <th>Nombre Completo</th>
                        <th>Nombre de Usuario</th>
                        <th>Telefono</th>                                             
                    </tr>
                </thead>
                <tbody id="myTable">           
                    <tr>
                        <td> <c:out value="${alumnoEncontrado.rut}" /> </td>
                        <td> <c:out value="${alumnoEncontrado.nombreCompleto}" /> </td>
                        <td> <c:out value="${alumnoEncontrado.usuario.nombre}" /> </td>
                        <td> <c:out value="${alumnoEncontrado.telefono}" /> </td>
                        <input type="hidden" value="<c:out value="${alumnoEncontrado.rut}"/>"
                               name="rutAlumnoEliminado"/>
                        <td>
                            <button type="submit" class="btn btn-primary">
                                <i class="">Eliminar</i>
                            </button>
                        </td>
                    </tr>
                </tbody>
            </table> 
        </form>
    </body>
</html>
