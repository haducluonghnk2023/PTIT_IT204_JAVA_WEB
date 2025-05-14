<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/13/2025
  Time: 8:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Kết quả góp ý</title>
</head>
<body>
<h2>Góp ý của bạn đã được ghi nhận!</h2>
<table border="1">
    <tr><th>Họ tên</th><td>${feedback.fullName}</td></tr>
    <tr><th>SĐT</th><td>${feedback.phone}</td></tr>
    <tr><th>Địa chỉ</th><td>${feedback.address}</td></tr>
    <tr><th>Nội dung</th><td>${feedback.content}</td></tr>
</table>

<p><a href="list">Xem danh sách góp ý</a></p>
</body>
</html>
