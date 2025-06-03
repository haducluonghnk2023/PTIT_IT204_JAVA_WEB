<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/17/2025
  Time: 8:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Upload Tài liệu</h2>

<form:form modelAttribute="document" method="post"
           action="${pageContext.request.contextPath}/uploadDocument"
           enctype="multipart/form-data">

    <div>
        <label>Tiêu đề:</label>
        <form:input path="title" placeholder="Nhập tiêu đề" />
    </div>

    <div>
        <label>Mô tả:</label>
        <form:textarea path="description" placeholder="Nhập mô tả" />
    </div>

    <div>
        <label>File tài liệu:</label>
        <form:input path="file" type="file" />
    </div>

    <div>
        <button type="submit">Tải lên</button>
    </div>

</form:form>
</body>
</html>
