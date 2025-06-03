<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/17/2025
  Time: 12:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h4>User Form</h4>
<form:form method="post" action="userSave" modelAttribute="user">
    <div>Name</div>
    <form:input path="name" placeholder="name" />
    <div>Age</div>
    <form:input path="age" placeholder="age" />
    <div>Address</div>
    <form:input path="address" placeholder="address" />
    <div>
        <button type="submit">Submit</button>
    </div>
</form:form>
</body>
</html>
