<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/19/2025
  Time: 4:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form modelAttribute="movieDTO" action="/movie-save" method="post">
    <div>
        <label for="title">Title:</label>
        <form:input path="title" />
        <br>
        <form:errors path="title" cssStyle="color: red;" />
    </div>
    <div>
        <label for="email">Email:</label>
        <form:input path="email" />
        <br>
        <form:errors path="email" cssStyle="color: red;" />
    </div>
    <div>
        <label for="quantity">Quantity:</label>
        <form:input path="quantity" type="number" />
        <br>
        <form:errors path="quantity" cssStyle="color: red;" />
    </div>
    <div>
        <label for="birthday">Birthday:</label>
        <form:input path="birthday" type="date" />
        <br>
        <form:errors path="birthday" cssStyle="color: red;" />
    </div>
    <div>
        <label for="eventDate">Event Date:</label>
        <form:input path="eventDate" type="date" />
        <br>
        <form:errors path="eventDate" cssStyle="color: red;" />
    </div>
    <div>
        <input type="submit" value="Submit" />
    </div>
</form:form>
</body>
</html>
