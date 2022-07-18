<%-- 
    Document   : login
    Created on : Jul 13, 2022, 7:39:55 AM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="Login" method="POST">
            USername: <input type="text" name="user"/><br/>
            Password: <input type="password" name="pass"/> <br/>
            <input type="submit" value="Login"/>
        </form>
    </body>
</html>
