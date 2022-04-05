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
                background-image: url("./images/bussisnes-image.jpg");
                margin: 0;
                text-align: center;
            }
            header {
                display: flex;
                justify-content: space-between;
                align-items: center;
                padding: 0.2rem 4rem;
                margin-bottom: 4rem;
                background-color: #0f2545;
                color: white;
                -webkit-box-shadow: 1px 0px 17px -5px rgba(0,0,0,1);
                -moz-box-shadow: 1px 0px 17px -5px rgba(0,0,0,1);
                box-shadow: 1px 0px 17px -5px rgba(0,0,0,1);
            }
            a {
                text-decoration: none;
                outline: none;
                color: white;
                font-weight: bold;
            }
            header a:hover {
                opacity: .7;
            }
            table {
                margin: 0 auto;
                padding: 0;
                border-collapse: collapse;
                border: 3px solid #0f2545;
                text-align: left;
                -webkit-box-shadow: 1px 0px 17px -5px rgba(0,0,0,1);
                -moz-box-shadow: 1px 0px 17px -5px rgba(0,0,0,1);
                box-shadow: 1px 0px 17px -5px rgba(0,0,0,1);
            }
            th, td {
                padding: 20px;
            }
            thead {
                background-color: #0f2545;
                border-bottom: solid 3px #0f2545;
                color: white;
            }
            tr:nth-child(even){
                background-color: #ddd;
            }
            table .btn {
                display: flex;
                justify-content: center;
                align-items: center;
                width: 5.5rem;
                height: 2.3rem;
                border-radius: 0.5rem;
            }
            table .btn:active {
                transform: scale(0.9);
            }
            table .btn-modificar {
                background-color: #0d6efd;
            }
            table .btn-modificar:hover {
                background-color: #5376fe;
            }
            table .btn-eliminar {
                background-color: #dc3545;
            }
            table .btn-eliminar:hover {
                background-color: #e91327;
            }
        </style>
    </head>
    <body>
        <header>       
            <h1>Clientes</h1>
            <a href="ClientesController?accion=nuevo">Nuevo registro</a>
        </header>
        
        
        
        
        <table width="80%">
            <thead>
                <tr>                 
                    <th>IDcliente</th>
                    <th>Nombre</th>
                    <th>Cédula</th>
                    <th>Edad</th>
                    <th>Trabaja</th>
                    <th>Estado civil</th>
                    <th>puntuación</th>
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
                        <td><c:out value="${cliente.puntuacion}" /></td>
                        <td>
                            <a href="ClientesController?accion=modificar&id=<c:out value="${cliente.id}" />">
                                <div class="btn btn-modificar">
                                    <span>Modificar</span>
                                </div>
                            </a>
                        </td>
                        <td>
                            <a href="ClientesController?accion=eliminar&id=<c:out value="${cliente.id}" />">
                                <div class="btn btn-eliminar">
                                    <span>
                                        Eliminar
                                    </span>
                                </div>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
                    
            </tbody>
        </table>
    </body>
</html>
