<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/22/2025
  Time: 9:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <title>Danh sách danh mục</title>
    <style>
        table {
            border-collapse: collapse;
            width: 80%;
            margin: 20px auto;
        }
        th, td {
            border: 1px solid #ccc;
            padding: 10px;
            text-align: center;
        }
        th {
            background-color: #f7f7f7;
        }
        a.button {
            padding: 6px 12px;
            background-color: #28a745;
            color: white;
            text-decoration: none;
            border-radius: 4px;
            margin: 0 5px;
        }
        a.button:hover {
            background-color: #218838;
        }
        .message {
            width: 80%;
            margin: 20px auto;
            padding: 10px;
            background-color: #d4edda;
            color: #155724;
            border-radius: 4px;
            border: 1px solid #c3e6cb;
        }
    </style>
</head>
<body>

<h2 style="text-align: center;">Danh sách danh mục sản phẩm</h2>

<c:if test="${not empty message}">
    <div class="message">${message}</div>
</c:if>

<div style="width: 80%; margin: 10px auto; text-align: right;">
    <a href="${pageContext.request.contextPath}/add" class="button">Thêm danh mục mới</a>
</div>

<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Tên danh mục</th>
        <th>Trạng thái</th>
        <th>Hành động</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="category" items="${categories}">
        <tr>
            <td>${category.id}</td>
            <td>${category.categoryName}</td>
            <td>
                <c:choose>
                    <c:when test="${category.status}">
                        Hoạt động
                    </c:when>
                    <c:otherwise>
                        Không hoạt động
                    </c:otherwise>
                </c:choose>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/edit/${category.id}" class="button" style="background-color:#007bff;">Sửa</a>
                <a href="${pageContext.request.contextPath}/delete/${category.id}" class="button" style="background-color:#dc3545;"
                   onclick="return confirm('Bạn có chắc muốn xóa danh mục này?');">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    <c:if test="${empty categories}">
        <tr>
            <td colspan="4">Chưa có danh mục nào.</td>
        </tr>
    </c:if>
    </tbody>
</table>

</body>
</html>
