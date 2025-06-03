<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/17/2025
  Time: 12:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h4>Register Form</h4>
    <form:form action="register" method="post" modelAttribute="account" >
        <form:input path="username" placeholder="Username" />
        <form:input path="password" type="password" placeholder="Password" />
        <form:input path="email" placeholder="Email" />
        <button type="submit">Register</button>
    </form:form>
</body>
</html>
