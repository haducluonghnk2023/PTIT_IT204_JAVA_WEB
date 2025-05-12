<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/10/2025
  Time: 8:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Nhập thông tin sinh viên</title>
</head>
<body>
    <h2>Form Nhập Thông Tin Sinh Viên</h2>
    <form action="${pageContext.request.contextPath}/submitStudent" method="post">
        Tên: <input type="text" name="name" required><br><br>
        Tuổi: <input type="number" name="age" required><br><br>
        Địa chỉ: <input type="text" name="address" required><br><br>
        <input type="submit" value="Gửi">
    </form>
</body>
</html>
