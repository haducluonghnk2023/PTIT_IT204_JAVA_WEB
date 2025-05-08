<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/7/2025
  Time: 7:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ex02</title>
</head>
<body>
    <form action="ex02.jsp" method="post">
        name <input type="text" name="name"><br>
        email <input type="text" name="email"><br>
       <input type="submit" value="submit"><br>
    </form>
    <%
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        if (name != null && email != null) {
            application.setAttribute("userName", name);
            application.setAttribute("userEmail", email);
        }
        String savedName = (String) application.getAttribute("userName");
        String savedEmail = (String) application.getAttribute("userEmail");

        if (savedName != null && savedEmail != null) {
    %>
    <h3>Thông tin đã lưu:</h3>
    <p><strong>Họ và tên:</strong> <%= savedName %></p>
    <p><strong>Email:</strong> <%= savedEmail %></p>
    <%
    } else {
    %>
    <p>Chưa có thông tin người dùng nào được lưu.</p>
    <%
        }
    %>
</body>
</html>
