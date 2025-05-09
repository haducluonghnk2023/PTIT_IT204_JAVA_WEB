<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/8/2025
  Time: 9:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Chi tiết sản phẩm</title>
</head>
<body>

<h2>Chi tiết sản phẩm</h2>

<c:choose>
    <c:when test="${not empty product}">
        <p><strong>ID:</strong> ${product.id}</p>
        <p><strong>Tên sản phẩm:</strong> ${product.productName}</p>
        <p><strong>Giá:</strong> ${product.price}</p>
        <p><strong>Mô tả:</strong> ${product.description}</p>
    </c:when>
    <c:otherwise>
        <p style="color:red;">Sản phẩm không có thông tin</p>
    </c:otherwise>
</c:choose>

</body>
</html>
