<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form action="Login" method="POST" style="text-align: center;">
            Username: <input type="text" name="user"/><br/>
            Password: <input type="password" name="pass"/> <br/>
            <input type="submit" value="Login"/>
        </form>
        <c:if test="${sessionScope.account ne null}">
            <p style="text-align: center;">Login failed</p>
        </c:if>
    </body>
</html>
