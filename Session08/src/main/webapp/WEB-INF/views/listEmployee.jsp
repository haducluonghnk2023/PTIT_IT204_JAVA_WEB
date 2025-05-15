<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/14/2025
  Time: 8:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Danh sách nhân viên</h1>

<table border="1">
    <thead>
    <tr>
        <th>Tên</th>
        <th>Email</th>
        <th>Vị trí</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="employee" items="${employees}">
        <tr>
            <td>${employee.name}</td>
            <td>${employee.email}</td>
            <td>${employee.position}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<br>
<a href="/Session08/employees/add">Thêm nhân viên mới</a>
</body>
</html>
