<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/7/2025
  Time: 8:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <form action="ex05.jsp" method="post">
    <label for="name">Họ và tên:</label>
    <input type="text" name="name" required>

    <label for="email">Email:</label>
    <input type="email" name="email" required>

    <label for="password">Mật khẩu:</label>
    <input type="password" name="password" required>

    <input type="submit" value="Đăng ký">
  </form>

  <%
    String name = request.getParameter("name");
    String email = request.getParameter("email");
    String password = request.getParameter("password");

    if (request.getMethod().equalsIgnoreCase("POST") && name != null && email != null && password != null) {
  %>
  <div class="message">
    <strong>Đăng ký thành công!</strong><br>
    Cảm ơn bạn, <%= name %> đã đăng ký với email: <%= email %>.
  </div>
  <%
    }
  %>

</body>
</html>
