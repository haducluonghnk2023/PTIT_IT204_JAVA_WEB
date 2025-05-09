<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/8/2025
  Time: 9:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Danh Sách Sản Phẩm</title>
</head>
<body>
<h2>Danh Sách Sản Phẩm</h2>

<form method="get" action="ProductList07">
    <label for="minPrice">Giá Tối Thiểu:</label>
    <input type="number" id="minPrice" name="minPrice" step="0.01" min="0">

    <label for="maxPrice">Giá Tối Đa:</label>
    <input type="number" id="maxPrice" name="maxPrice" step="0.01" min="0">

    <button type="submit">Lọc</button>
</form>

<h3>Kết quả lọc:</h3>

<c:if test="${empty filteredProducts}">
    <p>Không có sản phẩm nào trong khoảng giá này.</p>
</c:if>

<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Tên Sản Phẩm</th>
        <th>Giá</th>
        <th>Mô tả</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="product" items="${filteredProducts}">
        <tr>
            <td>${product.id}</td>
            <td>${product.productName}</td>
            <td>${product.price}</td>
            <td>${product.description}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
