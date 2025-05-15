<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/14/2025
  Time: 8:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Thêm nhân viên mới</h1>

<form action="/Session08/employees" method="post">
    <label for="name">Tên:</label>
    <input type="text" id="name" name="name" required>
    <br>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" required>
    <br>

    <label for="position">Vị trí:</label>
    <input type="text" id="position" name="position" required>
    <br>

    <button type="submit">Thêm nhân viên</button>
</form>

<br>
<a href="employees">Trở lại danh sách nhân viên</a>
</body>
</html>
