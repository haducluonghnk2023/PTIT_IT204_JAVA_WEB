<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <title>Thêm / Sửa danh mục</title>
    <style>
        form {
            width: 400px;
            margin: 30px auto;
            padding: 20px;
            background: #f9f9f9;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        label {
            display: block;
            font-weight: bold;
            margin-top: 10px;
        }
        input {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .error {
            color: red;
            font-size: 12px;
            margin-top: 3px;
        }
        button {
            margin-top: 15px;
            padding: 10px;
            width: 100%;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }
        button:hover {
            background-color: #0056b3;
        }
        .back-link {
            display: block;
            margin-top: 10px;
            text-align: center;
            text-decoration: none;
            color: #007bff;
        }
        .back-link:hover {
            text-decoration: underline;
        }
        .message {
            text-align: center;
            color: red;
            font-weight: bold;
            margin-top: 10px;
        }
    </style>
</head>
<body>

<h2 style="text-align: center;">
    <c:choose>
        <c:when test="${not empty categoryId}">
            Cập nhật danh mục
        </c:when>
        <c:otherwise>
            Thêm danh mục
        </c:otherwise>
    </c:choose>
</h2>

<c:if test="${not empty errorMessage}">
    <div class="message">${errorMessage}</div>
</c:if>

<!-- Sử dụng action động dựa vào categoryId -->
<form:form method="post" modelAttribute="categoryDto"
           action="${pageContext.request.contextPath}${not empty categoryId ? '/edit/' += categoryId : '/add'}">

    <label for="categoryName">Tên danh mục:</label>
    <form:input path="categoryName" id="categoryName"/>
    <form:errors path="categoryName" cssClass="error"/>

    <button type="submit">
        <c:choose>
            <c:when test="${not empty categoryId}">Cập nhật</c:when>
            <c:otherwise>Thêm mới</c:otherwise>
        </c:choose>
    </button>
</form:form>

<a href="${pageContext.request.contextPath}/categories" class="back-link">← Quay lại danh sách</a>

</body>
</html>
