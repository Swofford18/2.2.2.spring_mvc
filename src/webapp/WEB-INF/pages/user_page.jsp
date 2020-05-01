<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 30.04.2020
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <td>ID</td>
        <td>Username</td>
        <td>Password</td>
        <td>Email</td>
    </tr>
    <tr>
        <td>${user.id}</td>
        <td>${user.username}</td>
        <td>${user.password}</td>
        <td>${user.email}</td>
    </tr>
</table>
<a href="/logout">Logout</a>
</body>
</html>
