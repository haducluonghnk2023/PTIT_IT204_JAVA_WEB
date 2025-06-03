<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/12/2025
  Time: 8:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Sửa liên hệ</title></head>
<body>
<h2>Sửa liên hệ</h2>
<form action="contacts?action=update" method="post">
  <input type="hidden" name="id" value="${contact.id}">
  Họ: <input type="text" name="firstName" value="${contact.firstName}" required><br>
  Tên: <input type="text" name="lastName" value="${contact.lastName}" required><br>
  Email: <input type="email" name="email" value="${contact.email}" required><br>
  SĐT: <input type="text" name="phone" value="${contact.phone}" required><br>
  <input type="submit" value="Cập nhật">
</form>
</body>
</html>
