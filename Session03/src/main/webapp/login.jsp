<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/7/2025
  Time: 4:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h1>Login Page</h1>
    <form action="result.jsp" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username"><br><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password"><br><br>

        <label for="age">Age:</label>
        <input type="number" id="age" name="age"><br><br>

        <input type="submit" value="Submit">
    </form>
</body>
</html>
