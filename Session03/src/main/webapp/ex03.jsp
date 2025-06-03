<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/7/2025
  Time: 8:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ex03</title>
</head>
<body>
  <form action="ex03.jsp" method="post">
    <input type="submit" name="go" value="Đến trang chào mừng">
  </form>
  <%
    String go = request.getParameter("go");
    if (go != null) {
  %>
  <jsp:forward page="welcome.jsp" />
  <%
    }
  %>
</body>
</html>
