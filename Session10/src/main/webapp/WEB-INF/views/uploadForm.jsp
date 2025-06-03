<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/17/2025
  Time: 8:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h4>Upload Profile</h4>
    <form:form action="${pageContext.request.contextPath}/upload" method="post" enctype="multipart/form-data" modelAttribute="userProfile">
        <div>Name</div>
       <form:input path="username" type="text"/>
        <div>File</div>
        <form:input path="profilePicture" type="file" />
        <input type="submit" value="Upload" />
    </form:form>
</body>
</html>
