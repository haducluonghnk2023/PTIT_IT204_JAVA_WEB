<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/10/2025
  Time: 8:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.data.session05.model.Student" %>
<%
    com.data.session05.model.Student student = (Student) request.getAttribute("student");
%>
<html>
<head>
    <title>Xác nhận thông tin</title>
</head>
<body>
    <h2>Thông tin sinh viên đã được gửi thành công!</h2>
    <p><strong>Tên:</strong> <%= student.getName() %></p>
    <p><strong>Tuổi:</strong> <%= student.getAge() %></p>
    <p><strong>Địa chỉ:</strong> <%= student.getAddress() %></p>
</body>
</html>
