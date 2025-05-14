<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/13/2025
  Time: 8:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Chi tiết sản phẩm</title></head>
<body>
<h2>Chi tiết sản phẩm</h2>
<div>
    <img src="${product.image}" alt="${product.name}" width="150"/><br>
    <strong>Tên:</strong> ${product.name}<br>
    <strong>Giá:</strong> $${product.price}<br>
    <strong>Tồn kho:</strong> ${product.stock}<br>
    <strong>Mô tả:</strong> ${product.description}<br><br>
    <a href="<%= request.getContextPath()%>/products">Quay lại danh sách</a>
</div>
</body>
</html>

