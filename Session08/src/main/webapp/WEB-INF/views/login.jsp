<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/15/2025
  Time: 9:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Đăng nhập</title>
</head>
<body>
<h2>Đăng nhập</h2>

<form:form method="POST" modelAttribute="user" action="/Session08/game/login">
  <label>Tên đăng nhập:</label>
  <form:input path="username"/><br/><br/>

  <label>Mật khẩu:</label>
  <form:password path="password"/><br/><br/>

  <input type="submit" value="Đăng nhập"/>
</form:form>

<c:if test="${not empty error}">
  <p style="color:red;">${error}</p>
</c:if>

<p>Chưa có tài khoản? <a href="/Session08/game/register">Đăng ký</a></p>
</body>
</html>
