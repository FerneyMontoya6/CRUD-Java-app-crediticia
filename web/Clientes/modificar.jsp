<%-- 
    Document   : modificar
    Created on : 29/03/2022, 02:03:20 PM
    Author     : Familia Montoya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Modificar registro</h1>
        
        <form action="" method="POST" autocomplete="off">
            
            <input id="id" name="id" type="hidden" />
            
            <p>
                Nombre:
                <input id="nombre" name="nombre" type="text">
            </p>
            
            <p>
                Cédula:
                <input id="cedula" name="cedula" type="number">
            </p>
            
            <p>
                Edad:
                <input id="edad" name="edad" type="number">
            </p>
            
            <p>
                Trabaja:
                <input id="trabaja" name="trabaja" type="text">
            </p>
            
            <p>
                Estado civil:
                <input id="estadoCivil" name="estadoCivil" type="text">
            </p>
            
            <button id="guardar" name="guardar" type="submit">Guardar</button>
            
        </form>
        
    </body>
</html>
