<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/28/2025
  Time: 9:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head><title>Thêm sản phẩm</title></head>
<body>
<h2>Thêm sản phẩm vào giỏ hàng</h2>
<form:form method="post" modelAttribute="item">
    Tên sản phẩm: <form:input path="name"/><br/>
    Số lượng: <form:input path="quantity"/><br/>
    <input type="submit" value="Thêm"/>
</form:form>
<a href="/cart">Xem giỏ hàng</a>
</body>
</html>
