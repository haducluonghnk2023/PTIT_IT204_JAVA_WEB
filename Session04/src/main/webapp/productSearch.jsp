<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/8/2025
  Time: 9:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Tìm Kiếm Sản Phẩm</title>
</head>
<body>

<h1>Tìm Kiếm Sản Phẩm</h1>
<form action="productSearch" method="get">
    <label for="productId">Nhập ID sản phẩm:</label>
    <input type="text" id="productId" name="productId" required />
    <button type="submit">Tìm Kiếm</button>
</form>

<c:choose>
    <c:when test="${not empty product}">
        <h2>Thông tin sản phẩm:</h2>
        <p><strong>ID:</strong> ${product.id}</p>
        <p><strong>Tên:</strong> ${product.productName}</p>
        <p><strong>Giá:</strong> ${product.price} VND</p>
        <p><strong>Mô tả:</strong> ${product.description}</p>
    </c:when>
    <c:otherwise>
        <p>Sản phẩm không tìm thấy.</p>
    </c:otherwise>
</c:choose>

</body>
</html>
