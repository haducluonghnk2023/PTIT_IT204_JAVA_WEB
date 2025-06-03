<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/15/2025
  Time: 9:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <title>Đăng ký</title>
</head>
<body>
<h2>Đăng ký tài khoản</h2>
<form:form method="POST" modelAttribute="user" action="/Session08/game/register">
  <label>Tên đăng nhập:</label>
  <form:input path="username"/><br/><br/>

  <label>Mật khẩu:</label>
  <form:password path="password"/><br/><br/>

  <label>Email:</label>
  <form:input path="email"/><br/><br/>

  <input type="submit" value="Đăng ký"/>
</form:form>

<p>Đã có tài khoản? <a href="/Session08/game/login">Đăng nhập</a></p>
</body>
</html>
