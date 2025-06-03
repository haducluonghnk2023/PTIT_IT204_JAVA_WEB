<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/18/2025
  Time: 8:25 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload</title>
</head>
<body>
<h4>Upload</h4>

<form:form
        action="${pageContext.request.contextPath}/uploadFile"
        method="post"
        modelAttribute="uploadFile"
        enctype="multipart/form-data">

    <div>Description</div>
    <form:input path="description" />

    <div>File</div>
    <input type="file" name="file" />

    <div><input type="submit" value="Upload"/></div>
</form:form>

</body>
</html>
