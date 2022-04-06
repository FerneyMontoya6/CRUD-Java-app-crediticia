<%-- 
    Document   : nuevo
    Created on : 29/03/2022, 02:03:11 PM
    Author     : Familia Montoya
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head lang="es">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="icon" type="image/png" href="Bank-PNG-Clipart-Background.png png"/>
        <title>Nuevo registro</title>
        
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
        
        <form action="ClientesController?accion=insertar" method="POST" autocomplete="off">
            
            <h1>Nuevo registro</h1>
            <input id="nombre" name="nombre" type="text" placeholder="Nombre">
            
            <input id="cedula" name="cedula" type="number" placeholder="Cédula">
            
            <input id="edad" name="edad" type="number" placeholder="Edad">
            
            <input id="trabaja" name="trabaja" type="text" placeholder="¿Trabaja?">
            
            <input id="estadoCivil" name="estadoCivil" type="text" placeholder="Estado civil">
            
            <button id="guardar" name="guardar" type="submit">Guardar</button>
            
        </form>
    </body>
</html>
