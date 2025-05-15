<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/15/2025
  Time: 8:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Shop Hạt Giống</title>
</head>
<body>
<h2>Danh sách hạt giống</h2>

<c:forEach var="seed" items="${seeds}">
  <div style="border: 1px solid #ccc; padding: 10px; margin-bottom: 10px;">
    <img src="${seed.imageUrl}" width="100" height="100"/><br/>
    <strong>${seed.seedsName}</strong><br/>
    Giá: ${seed.price} VNĐ
  </div>
</c:forEach>

<p><a href="home">Quay lại Home</a></p>
</body>
</html>
