<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/19/2025
  Time: 7:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Danh sách dự án</title>
    <style>
        table {
            width: 90%;
            border-collapse: collapse;
            margin: 20px auto;
        }
        th, td {
            border: 1px solid #888;
            padding: 10px;
            text-align: center;
        }
        a.button {
            padding: 5px 10px;
            background-color: #28a745;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }
        a.button:hover {
            background-color: #218838;
        }
        .delete-btn {
            background-color: #dc3545;
        }
        .delete-btn:hover {
            background-color: #c82333;
        }
    </style>
</head>
<body>

<h2 style="text-align:center;">Danh sách các dự án</h2>

<div style="text-align:center; margin-bottom: 20px;">
    <a href="${pageContext.request.contextPath}/createProject" class="button">+ Thêm Dự Án</a>
</div>

<table>
    <thead>
    <tr>
        <th>Tên dự án</th>
        <th>Mô tả</th>
        <th>Tài liệu</th>
        <th>Hành động</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="project" items="${projects}">
        <tr>
            <td>${project.name}</td>
            <td>${project.description}</td>
            <td>
                <ul>
                    <c:forEach var="doc" items="${project.documents}">
                        <li>${doc.fileName}</li>
                    </c:forEach>
                </ul>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/editProject?name=${project.name}" class="button">Sửa</a>
                <form action="${pageContext.request.contextPath}/deleteProject" method="post" style="display:inline;">
                    <input type="hidden" name="projectName" value="${project.name}">
                    <button type="submit" class="button delete-btn" onclick="return confirm('Bạn có chắc muốn xóa dự án này?');">Xóa</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
