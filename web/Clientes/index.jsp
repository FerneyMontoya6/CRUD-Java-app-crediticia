<%-- 
    Document   : index
    Created on : 29/03/2022, 02:02:49 PM
    Author     : Ferney Montoya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>App crediticia</title>
        
        <style>
            html {
                font-family: sans-serif;
            }
            body {
                margin: 0;
                text-align: center;
            }
            header {
                padding: 0.2rem 0;
                margin-bottom: 4rem;
                background-color: #2b4050;
                color: white;
            }
            table {
                margin: 0 auto;
            }
        </style>
    </head>
    <body>
        <header>       
            <h1>Clientes</h1>
        </header>
        
        <a href="ClientesController?accion=nuevo">Nuevo registro</a>
        
        
        
        <table border="1" width="80%">
            <thead>
                <tr>                 
                    <th>IDcliente</th>
                    <th>Nombre</th>
                    <th>Cedula</th>
                    <th>Edad</th>
                    <th>Trabaja</th>
                    <th>Estado civil</th>
                    <th>puntuacion</th>
                    <th>Modificar</th>
                    <th>Eliminar</th>
                </tr>
            </thead>
            
            <tbody>
                
                <c:forEach var="cliente" items="${lista}">
                    <tr>
                        <td><c:out value="${cliente.id}" /></td>
                        <td><c:out value="${cliente.nombre}" /></td>
                        <td><c:out value="${cliente.cedula}" /></td>
                        <td><c:out value="${cliente.edad}" /></td>
                        <td><c:out value="${cliente.trabaja}" /></td>
                        <td><c:out value="${cliente.estadoCivil}" /></td>
                        <td></td>
                        <td><a href="ClientesController?accion=modificar&id=<c:out value="${cliente.id}" />">Modificar</a></td>
                        <td><a href="ClientesController?accion=eliminar&id=<c:out value="${cliente.id}" />">Eliminar</td>
                    </tr>
                </c:forEach>
                    
            </tbody>
        </table>
    </body>
</html>
