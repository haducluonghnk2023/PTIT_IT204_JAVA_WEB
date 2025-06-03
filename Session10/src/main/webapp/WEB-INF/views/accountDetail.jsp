<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/17/2025
  Time: 4:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h4>Information Account</h4>
    <table border="1">
        <tr>
            <th>Account Name</th>
            <th>Account Password</th>
            <th>Account Email</th>
        </tr>
        <tr>
            <td>${account.username}</td>
            <td>${account.password}</td>
            <td>${account.email}</td>
        </tr>
</body>
</html>
