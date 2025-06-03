<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/28/2025
  Time: 9:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head><title>Thêm/Sửa đơn hàng</title></head>
<body>
<h2>Thêm/Sửa đơn hàng</h2>
<form:form method="post" action="/orders/save" modelAttribute="order">
    Mã đơn hàng: <form:input path="orderId"/><br/><br/>
    Tên sản phẩm: <form:input path="productName"/><br/><br/>
    Số lượng: <form:input path="quantity" type="number"/><br/><br/>
    <input type="submit" value="Lưu đơn hàng"/>
</form:form>
<a href="/orders">Quay lại danh sách</a>
</body>
</html>
