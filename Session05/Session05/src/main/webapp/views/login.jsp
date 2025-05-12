<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/11/2025
  Time: 8:18 PM
  To change this template use File | Settings | File Templates.
--%>
<!-- login.jsp -->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Đăng nhập</title>
</head>
<body>
<h2>Đăng nhập</h2>
<form action="LoginController" method="post">
    Tên đăng nhập: <input type="text" name="username"><br>
    Mật khẩu: <input type="password" name="password"><br>
    <input type="submit" value="Đăng nhập">
</form>
<p style="color:red">${error}</p>
</body>
</html>
