<%-- 
    Document   : index
    Created on : 23/08/2018, 08:53:31 PM
    Author     : Administrador
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
        <meta name="description" content="Multicines Cinestar es una empresa pionera en el formato de multicines en el Perú. Información de películas, estrenos, concursos y más">
        <link rel="shortcut icon" href="CineStar/img/varios/favicon.ico">
        <link href="css/estilos.css" rel="stylesheet" type="text/css">
        <title>Multicines Cinestar</title>

    </head>
    <body>
        <%@include file="WEB-INF/header.jspf" %>
        <% 
            Object id = session.getAttribute("id");
            if (id == null){
        %>
        <%@include file="inicio.jspf" %>
        <%}else if (id.equals("4")){%>
        <%@include file="WEB-INF/verCines.jspf" %>
        <%}%>
        <%@include file="WEB-INF/footer.jspf" %>
    </body>
</html>
