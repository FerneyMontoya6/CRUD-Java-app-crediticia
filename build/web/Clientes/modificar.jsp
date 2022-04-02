<%-- 
    Document   : modificar
    Created on : 29/03/2022, 02:03:20 PM
    Author     : Familia Montoya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Modificar registro</h1>
        
        <form action="ClientesController?accion=actualizar" method="POST" autocomplete="off">
            
            <input id="id" name="id" type="hidden"  value="<c:out value="${cliente.id}" />" />
            
            <p>
                Nombre:
                <input id="nombre" name="nombre" type="text" value="<c:out value="${cliente.nombre}"/>">
            </p>
            
            <p>
                Cédula:
                <input id="cedula" name="cedula" type="number" value="<c:out value="${cliente.cedula}"/>">
            </p>
            
            <p>
                Edad:
                <input id="edad" name="edad" type="number" value="<c:out value="${cliente.edad}"/>">
            </p>
            
            <p>
                Trabaja:
                <input id="trabaja" name="trabaja" type="text" value="<c:out value="${cliente.trabaja}"/>">
            </p>
            
            <p>
                Estado civil:
                <input id="estadoCivil" name="estadoCivil" type="text" value="<c:out value="${cliente.estadoCivil}"/>">
            </p>
            
            <button id="guardar" name="guardar" type="submit">Guardar</button>
            
        </form>
        
    </body>
</html>
