<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/8/2025
  Time: 7:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <title>Thêm người dùng</title>
</head>
<body>
<h2>Thêm thông tin người dùng</h2>
<form method="post" action="user">
  <input type="hidden" name="action" value="add">
  Tên: <input type="text" name="name" required><br>
  Email: <input type="email" name="email" required><br>
  <input type="submit" value="Thêm người dùng">
</form>
</body>
</html>

