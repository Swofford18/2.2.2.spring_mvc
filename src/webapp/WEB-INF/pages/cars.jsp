<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 24.04.2020
  Time: 16:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<body>
<h1>${locale}</h1>
<table border="1px solid black">
<c:forEach var="msq" items="${cars}">
    <tr>
        <td>${msq.id}</td>
        <td>${msq.name}</td>
        <td>${msq.number}</td>
    </tr>
</c:forEach>
</table>
</body>
</html>
