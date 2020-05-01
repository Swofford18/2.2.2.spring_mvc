<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 29.04.2020
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>UPDATE</title>
</head>
<body>
<form method="post" action="/admin/update">
    <table>
        <tr>
            <td>ID:</td>
            <td><input type="text" disabled required name="id" value="${user.id}"></td>
        </tr>
        <tr>
            <td>Username:</td>
            <td><input type="text" required name="username" value="${user.username}"><br></td>
        </tr>
        <tr>
            <td>Password:</td>
            <td><input type="text" required placeholder="password" name="password" value="${user.password}"></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><input type="text" required placeholder="email" name="email" value="${user.email}"></td>
        </tr>
    </table>
    <input type="submit" value="UPDATE">
</form>
</body>
</html>
