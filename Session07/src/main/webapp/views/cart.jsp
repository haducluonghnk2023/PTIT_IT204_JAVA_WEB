<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/13/2025
  Time: 9:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Giỏ hàng</title></head>
<body>

<h2>Giỏ hàng</h2>

<c:forEach var="item" items="${cart}">
    <p>
            ${item.product.name} - ${item.product.price} VNĐ x ${item.quantity}
        = ${item.product.price * item.quantity} VNĐ
        <a href="increase?id=${item.product.id}">[+]</a>
        <a href="decrease?id=${item.product.id}">[-]</a>
        <a href="remove?id=${item.product.id}">[Xóa]</a>
    </p>
</c:forEach>

<h3>Tổng cộng: ${total} VNĐ</h3>
<a href="products"><button>Quay lại</button></a>

</body>
</html>