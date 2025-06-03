<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/15/2025
  Time: 4:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh sách phim</title>
</head>
<body>
<h1>Danh sách phim đang chiếu</h1>
<ul>
    <c:forEach var="movie" items="${movies}">
        <li>
            <strong>${movie.title}</strong> -
            Đạo diễn: <span>${movie.director}</span> -
            Thể loại: <span>${movie.genre}</span>
            <a href="<%=request.getContextPath()%>/ex02/detailMovie?id=${movie.id}">Chi tiết</a>
        </li>
    </c:forEach>
</ul>
</body>
</html>
