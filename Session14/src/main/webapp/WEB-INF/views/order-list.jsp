<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/29/2025
  Time: 8:07 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
  <title>Danh sách đơn hàng</title>
</head>
<body>
<h2>Đơn hàng đã đặt</h2>

<table border="1">
  <thead>
  <tr>
    <th>Tên người dùng</th>
    <th>Sản phẩm</th>
    <th>Số lượng</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="order" items="${orders}">
    <tr>
      <td>${order.username}</td>
      <td>${order.product}</td>
      <td>${order.quantity}</td>
    </tr>
  </c:forEach>
  </tbody>
</table>

<br/>
<a href="${pageContext.request.contextPath}/order">Quay lại đặt hàng</a>
</body>
</html>
