<%-- 
    Document   : agregarAlumno
    Created on : 29-10-2017, 09:48:19 PM
    Author     : David
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
   
        <%-- formulario de ingreso de un alumno--%>
        <div class="container-fluid">

            <h1>Agregar Alumno</h1>

            <form action="cem-alumnos?accion=agregar" method="post" class="form-horizontal">
                <div class="form-group">
                    <label class="col-sm-2 control-label">Fecha de nacimiento</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" name="numeroMatricula" 
                               placeholder="fecha de nacimiento" required="">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Digito verificador</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" name="digito" 
                               placeholder="digito verificador" required="">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Rut </label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" name="rutPersona" 
                               placeholder="Ingrese el Rut jefe de familia" required="">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Nombre completo</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" name="nombres" 
                               placeholder="Ingrese Nombre completo" required="">
                    </div>
                </div>

                <div class="form-group">
                    <label class="col-sm-2 control-label">Domicilio</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" name="domicilio" required=""
                               placeholder="Ingrese el domicilio"> 
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Ciudad</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" name="ciudad" required=""
                               placeholder="Ingrese la ciudad"> 
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Pais</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" name="pais" required=""
                               placeholder="Ingrese el pais"> 
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Correo</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" name="correo" required=""
                               placeholder="Ingrese el Correo"> 
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Telefono</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" name="telefono" required=""
                               placeholder="Ingrese el telefono"> 
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Numero de matricula</label>
                    <div class="col-sm-5">
                        <input type="text" class="form-control" name="ingrese cantidad de integrantes " required=""
                               placeholder="Ingrese el telefono"> 
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">Fecha de matricula</label>
                    <div class="col-sm-5">
                        <input type="date" class="form-control" name="fechaMatricula" 
                               placeholder="fecha de nacimiento" required="">
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-2 control-label">${mensaje}</label>
                    <div class="col-sm-5 control-label">
                        <button type="submit" class="btn btn-default">Agregar</button>
                    </div>
                </div>

            </form>
        </div>
    </body>
</html>
