<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/14/2025
  Time: 8:06 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Trang sản phẩm</title>
</head>
<body>
    <h4>Danh sách sản phẩm</h4>
    <table border="1">
        <tr>
            <th>STT</th>
            <th>Tên sản phẩm</th>
            <th>Giá</th>
            <th>So luong</th>
        </tr>
        <c:forEach var="product" items="${products}">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td>${product.quantity}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
