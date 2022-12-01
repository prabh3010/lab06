<%-- 
    Document   : register
    Created on : 30-Nov-2022, 10:57:26 AM
    Author     : prabh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register page</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <form  method="POST">
            <label>Username:</label>
            <input type="text" name="username" autofocus></input> 
            <input type="hidden"name="action" value="register"></input>
            <button type="submit">Register name</button>
            <input type="hidden" name="action" value="register">
        </form>
        <p>${message}</p>
    </body>
</html>
