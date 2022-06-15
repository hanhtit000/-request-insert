<%-- 
    Document   : search
    Created on : Jun 13, 2022, 8:08:20 AM
    Author     : ASUS
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Emp"%>
<%@page import="model.Dept"%>
<%@page import="model.AnualRequest"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="insert" method="post">
            Reason: <input type="text" name="reason"><br>
            From:<input type="date" name="from"><br>
            To:<input type="date" name="to"><br>
            Created by: <select name="create">
                <option value="0">All</option>
                <c:forEach items="${requestScope.listEmp}" var="e">
                    <option value="${e.id}">${e.id}</option>
                </c:forEach>
            </select>
            <br>
            Reviewed by: <select name="review">
                <<option value="0">All</option>
                <c:forEach items="${requestScope.listEmp}" var="e">
                    <option value="${e.id}">${e.id}</option>
                </c:forEach>
            </select>
            <br>
            <input type="submit" value="Save">
        </form>
        <c:if test="${requestScope.added ne null}">
            <p> Added Successfully</p>
        </c:if>
        <c:if test="${requestScope.added eq null}">
            <p> Added Fail</p>
        </c:if>
    </body>
</html>
