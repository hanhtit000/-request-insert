<%-- 
    Document   : newjsp
    Created on : Jul 11, 2022, 7:50:22 AM
    Author     : ASUS
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="https://your.uri/jsp/tlds/mytags" prefix="mytags"%>
<%@page import="java.sql.Date" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="input" method="post">
            <input type="date" name="date">
            <input type="submit">
        </form> 
            <% String dt= (String) request.getAttribute("kt"); %>
            <mytags:formatDate date="<%=dt%>" format="dd/MM/yyyy"/><br><br>
    </body>
</html>
