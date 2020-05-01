<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 29.04.2020
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ADD</title>
</head>
<body>
<form method="post" action="/admin/add">
    <input type="text" required placeholder="username" name="username"><br>
    <input type="text" required placeholder="password" name="password"><br>
    <input type="text" required placeholder="email" name="email"><br>
    <input type="submit" value="ADD">
</form>
</body>
</html>
