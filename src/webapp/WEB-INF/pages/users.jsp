<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 27.04.2020
  Time: 12:32
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>spring mvc with hiber</title>
</head>
<body>
<table border="1">
    <thead>
    <td>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Email</th>
    </td>
    </thead>

    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.email}</td>
            <td width="60px"><a href="<c:url value='users/remove/${user.id}'/>">Delete</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<table border="1">
    <tr>
        <td>
            <form method="post" action="/users/add">
                <input type="text" required placeholder="email" name="email"><br>
                <input type="text" required placeholder="firstName" name="firstName"><br>
                <input type="text" required placeholder="lastName" name="lastName"><br>
                <input type="submit" value="ADD">
            </form>
        </td>
        <td>
            <form method="post" action="/users/update">
                <input type="text" required placeholder="id" name="id"><br>
                <input type="text" required placeholder="email" name="email"><br>
                <input type="text" required placeholder="firstName" name="firstName"><br>
                <input type="text" required placeholder="lastName" name="lastName"><br>
                <input type="submit" value="UPDATE">
            </form>
        </td>
    </tr>
</table>
</body>
</html>
