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
    <tr>
        <td>ID</td>
        <td>Username</td>
        <td>Password</td>
        <td>Email</td>
        <td>Action</td>
    </tr>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>${user.id}</td>
            <td>${user.username}</td>
            <td>${user.password}</td>
            <td>${user.email}</td>
            <td width="60px">
                <a href="<c:url value='admin/update/${user.id}'/>">Edit</a>
                <a href="<c:url value='admin/remove/${user.id}'/>">Delete</a>
            </td>
        </tr>
    </c:forEach>

</table>
<a href="/admin/add">Create new user</a>
<a href="/logout">Logout</a>
</body>
</html>
