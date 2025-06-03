<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/12/2025
  Time: 8:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Thêm liên hệ</title></head>
<body>
<h2>Thêm liên hệ mới</h2>
<form action="contacts?action=create" method="post">
    Họ: <input type="text" name="firstName" required><br>
    Tên: <input type="text" name="lastName" required><br>
    Email: <input type="email" name="email" required><br>
    SĐT: <input type="text" name="phone" required><br>
    <input type="submit" value="Thêm">
</form>
</body>
</html>

