<%-- 
    Document   : Familia_antecedentes
    Created on : 25-11-2017, 13:24:10
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
        <%@include file="menuFamilia.jsp" %>
        

        <div class="container">
            <h1>aqui se dene subir los antecedentes</h1>
            <br/>
            <form action="" method="" enctype="multipart/form-data">
                <h4>Cerificado de antecedentes</h4>
                <input type="file" name="file" size="50" />
                <br />
                <h4>Certificado de residencia</h4>
                <input type="file" name="file" size="50" />
                <br />
                <h4>Fotos del lugar de residencia</h4>
                <input type="file" name="file" size="50" />
                <input type="file" name="file" size="50" />
                <input type="file" name="file" size="50" />
                <br />
                <input type="submit" value="subir archivo" />
            </form>
        </div>
    </body>
</html>
