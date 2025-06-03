<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/14/2025
  Time: 8:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Đăng ký</title>
</head>
<body>
<h2>Form đăng ký người dùng</h2>
<form:form action="/Session08/register" method="post" modelAttribute="user">
  Tên: <form:input path="name" />
  <div style="color:red">${errors.nameError}</div><br>

  Email: <form:input path="email" />
  <div style="color:red">${errors.emailError}</div><br>

  Số điện thoại: <form:input path="phone" />
  <div style="color:red">${errors.phoneError}</div><br>

  <input type="submit" value="Đăng ký">
</form:form>
</body>
</html>
