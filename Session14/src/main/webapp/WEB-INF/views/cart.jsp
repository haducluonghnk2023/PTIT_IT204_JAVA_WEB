<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/28/2025
  Time: 9:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Giỏ hàng</title></head>
<body>
<h2>Giỏ hàng</h2>

<table border="1">
  <tr>
    <th>STT</th>
    <th>Tên sản phẩm</th>
    <th>Số lượng</th>
    <th>Hành động</th>
  </tr>
  <c:forEach var="item" items="${cart}" varStatus="status">
    <tr>
      <td>${status.index + 1}</td>
      <td>${item.name}</td>
      <td>${item.quantity}</td>
      <td><a href="/delete?index=${status.index}">Xóa</a></td>
    </tr>
  </c:forEach>
</table>

<h3>Sản phẩm ghi nhớ (từ Cookie)</h3>
<ul>
  <c:forEach var="p" items="${rememberedProducts}">
    <li>${p}</li>
  </c:forEach>
</ul>

<a href="/add">Thêm sản phẩm</a>
</body>
</html>
