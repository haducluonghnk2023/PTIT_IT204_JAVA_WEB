<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/7/2025
  Time: 7:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ex01</title>
</head>
<body>
    <%
        String name = "Ha Duc Luong";
        String university = "PTIT";
        String interests = "Java, sports, music";
    %>
    <h1>Welcome to my page!</h1>
    <p>My name is <%= name %></p>
    <p>I study at <%= university %></p>
    <p>My interests are: <%= interests %></p>
</body>
</html>
