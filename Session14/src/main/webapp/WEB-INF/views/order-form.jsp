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
  <title>Đặt hàng</title>
</head>
<body>
<h2>Đặt hàng sản phẩm</h2>

<c:if test="${not empty successMessage}">
  <div style="color: green;">${successMessage}</div>
</c:if>

<form action="${pageContext.request.contextPath}/order" method="post">
  <label>Tên người dùng:</label><br/>
  <input type="text" name="username" required/><br/><br/>

  <label>Sản phẩm:</label><br/>
  <select name="product">
    <option value="Laptop">Laptop</option>
    <option value="Điện thoại">Điện thoại</option>
    <option value="Tai nghe">Tai nghe</option>
  </select><br/><br/>

  <label>Số lượng:</label><br/>
  <input type="number" name="quantity" min="1" required/><br/><br/>

  <input type="submit" value="Đặt hàng"/>
</form>

<br/>
<a href="${pageContext.request.contextPath}/order8">Xem đơn hàng đã đặt</a>
</body>
</html>
