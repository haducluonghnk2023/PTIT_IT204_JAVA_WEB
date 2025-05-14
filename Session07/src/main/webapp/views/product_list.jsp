<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/13/2025
  Time: 8:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head><title>Danh sách sản phẩm</title></head>
<body>

<h2>Danh sách sản phẩm</h2>
<c:if test="${not empty error}">
  <p style="color:red">${error}</p>
</c:if>

<c:forEach var="product" items="${products}">
  <form action="addToCart" method="post">
    <p>
        ${product.name} - ${product.price} VNĐ
      <input type="hidden" name="productId" value="${product.id}" />
      <input type="number" name="quantity" value="1" min="1"/>
      <button type="submit">Thêm vào giỏ hàng</button>
    </p>
  </form>
</c:forEach>

<a href="cart"><button>Giỏ hàng</button></a>
</body>
</html>

