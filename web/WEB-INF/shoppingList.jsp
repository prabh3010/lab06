<%-- 
    Document   : shoppingList
    Created on : 30-Nov-2022, 10:57:48 AM
    Author     : prabh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <p>Hello, ${username} <a href="?action=logout">Logout</a></p>
        <h2>List</h2>
        <form method="POST">
            <label>Add Item:</label>
            <input type="text" name="Item" autofocus></input>
            <input type="submit" value="Add">
            <input type="hidden" name="action" value="add">
        </form>
        <form method="POST">
            <div>
                <c:forEach var="items" items="${list}">
                    <input type="radio" name="item" value="${items}"> ${items}<br></input>
                </c:forEach>
            </div>
            <div>
                <c:if test="${list.size() > 0}">
                    <input type="submit" value="Delete">
                    <input type="hidden" name="action"  value="delete">
                    
                </c:if>
            </div>
        </form>
        <p>${message}</p>
    </body>
</html>
