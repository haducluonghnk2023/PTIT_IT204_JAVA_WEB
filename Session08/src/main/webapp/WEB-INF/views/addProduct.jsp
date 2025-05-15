<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/14/2025
  Time: 8:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Thêm sản phẩm</title>
</head>
<body>
<h2>Nhập thông tin sản phẩm mới</h2>
<form:form action="/Session08/product/add" method="post" modelAttribute="product">
    <label>Tên sản phẩm:</label>
    <form:input path="name"/><br><br>

    <label>Số lượng:</label>
    <form:input path="quantity"/><br><br>

    <label>Giá:</label>
    <form:input path="price"/><br><br>

    <input type="submit" value="Thêm mới"/>
</form:form>
</body>
</html>
