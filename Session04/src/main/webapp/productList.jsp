<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/8/2025
  Time: 8:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Danh sách sản phẩm</title></head>
<body>
<h2>Danh sách sản phẩm</h2>
<table border="1" cellpadding="10">
    <tr>
        <th>ID</th>
        <th>Tên sản phẩm</th>
        <th>Giá</th>
        <th>Mô tả</th>
    </tr>
    <c:forEach var="p" items="${products}">
        <tr>
            <td>${p.id}</td>
            <td>${p.productName}</td>
            <td>${p.price}</td>
            <td>${p.description}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
