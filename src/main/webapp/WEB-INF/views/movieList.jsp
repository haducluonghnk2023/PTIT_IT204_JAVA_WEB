<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/23/2025
  Time: 7:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Danh sách phim</title>
    <style>
        table { border-collapse: collapse; width: 90%; margin: 20px auto; }
        th, td { border: 1px solid #ccc; padding: 8px; text-align: left; }
        th { background-color: #f4f4f4; }
        img { max-height: 100px; }
        .action-buttons a { margin-right: 10px; }
    </style>
</head>
<body>
<h2 style="text-align:center;">Danh sách phim</h2>
<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Tiêu đề</th>
        <th>Đạo diễn</th>
        <th>Ngày phát hành</th>
        <th>Thể loại</th>
        <th>Áp phích</th>
        <th>Thao tác</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="movie" items="${movies}">
        <tr>
            <td>${movie.id}</td>
            <td>${movie.title}</td>
            <td>${movie.director}</td>
            <td>
                <c:choose>
                    <c:when test="${not empty movie.release_date}">
                        <fmt:formatDate value="${movie.release_date}" pattern="yyyy-MM-dd" />
                    </c:when>
                    <c:otherwise>
                        N/A
                    </c:otherwise>
                </c:choose>
            </td>
            <td>${movie.genre}</td>
            <td>
                <c:if test="${not empty movie.poster}">
                    <img src="${movie.poster}" alt="Poster" />
                </c:if>
            </td>
            <td class="action-buttons">
                <a href="edit-movie?id=${movie.id}">Sửa</a>
                <a href="delete-movie?id=${movie.id}" onclick="return confirm('Bạn có chắc muốn xóa phim này?');">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
