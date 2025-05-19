<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/18/2025
  Time: 10:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Form Tạo Dự Án</title>
</head>
<body>

<h2>Tạo Dự Án Mới</h2>

<!-- Hiển thị thông báo nếu có -->
<c:if test="${not empty message}">
    <div style="color: green; font-weight: bold; margin-bottom: 10px;">
            ${message}
    </div>
</c:if>

<!-- Form tạo dự án -->
<form:form modelAttribute="project" method="post"
           action="${pageContext.request.contextPath}/createProject"
           enctype="multipart/form-data">

    <div>
        <label>Tên dự án:</label><br/>
        <form:input path="name"/>
    </div>

    <div>
        <label>Mô tả:</label><br/>
        <form:textarea path="description"/>
    </div>

    <div>
        <label>Tài liệu (PDF):</label><br/>
        <input type="file" name="files" multiple />
    </div>

    <div style="margin-top: 10px;">
        <button type="submit">Tạo dự án</button>
    </div>
</form:form>

</body>
</html>

