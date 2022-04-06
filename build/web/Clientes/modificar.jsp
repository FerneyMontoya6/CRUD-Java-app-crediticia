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
        <title>Modificar usuario</title>
        <link rel="icon" type="image/png" href="Bank-PNG-Clipart-Background.png png"/>
        
        <style>

            html {
                font-family: sans-serif;
            }
            body {
                height: 100vh;
                display: flex;
                align-items: center;
                margin: 0;
                background-color: #0f2545;
            }
            
            form {
                display: flex;
                flex-direction: column;
                width: 35%;
                height: 30rem;
                margin: 0 auto;
                padding-top: 2rem;
                text-align: center;
                background-color: white;
                border-radius: 0.7rem;
            }
            form h1 {
                font-weight: bold;
            }
            form input {
                width: 80%;
                height: 2rem;
                margin: 0.7rem auto;
                font-size: 0.9rem;
            }
            form button {
                width: 6.3rem;
                height: 2.3rem;
                margin: 2rem auto;
                background-color: #0f2545;
                color: white;
                font-size: 1rem;
                font-weight: bold;
                border: none;
                border-radius: 0.3rem;
                cursor: pointer;
            }
            form button:active {
                transform: scale(0.9);
            }
            form input {
                border: none;
                border-bottom: 1px solid gray;
            }
            form input:focus-visible {
                outline: none;
            }

        </style>
    </head>
    <body>
        
        <form action="ClientesController?accion=actualizar" method="POST" autocomplete="off">
            <h1>Modificar registro</h1>
            
            <input id="id" name="id" type="hidden"  value="<c:out value="${cliente.id}" />" />
            
                <input id="nombre" name="nombre" type="text" required="true" maxlength="20" value="<c:out value="${cliente.nombre}"/>">
     
                <input id="cedula" name="cedula" type="number" required="true" maxlength="12" value="<c:out value="${cliente.cedula}"/>">
            
                <input id="edad" name="edad" type="number" required="true" maxlength="2" value="<c:out value="${cliente.edad}"/>">
            
                <input id="trabaja" name="trabaja" type="text" required="true" maxlength="2" value="<c:out value="${cliente.trabaja}"/>">

                <input id="estadoCivil" name="estadoCivil" type="text" required="true" maxlength="10" value="<c:out value="${cliente.estadoCivil}"/>">
            
                <button id="guardar" name="guardar" type="submit">Guardar</button>
        </form>
        
    </body>
</html>
