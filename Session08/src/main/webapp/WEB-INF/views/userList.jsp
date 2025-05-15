<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/14/2025
  Time: 8:36 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Danh sách người dùng</title>
</head>
<body>
<h2>Danh sách người dùng</h2>
<table border="1">
    <thead>
    <tr>
        <th>Tên</th>
        <th>Tuổi</th>
        <th>Ngày sinh</th>
        <th>Email</th>
        <th>Số điện thoại</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>${user.name}</td>
            <td>${user.age}</td>
            <td>${user.birthday}</td>
            <td>${user.email}</td>
            <td>${user.phone}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
