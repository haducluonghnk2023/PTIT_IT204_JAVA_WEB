<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/28/2025
  Time: 8:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Quản lý sản phẩm</title>
</head>
<body>
<h2>Thêm sản phẩm</h2>
<form:form method="post" modelAttribute="product">
    Mã sản phẩm: <form:input path="id" /><br/>
    Tên sản phẩm: <form:input path="name" /><br/>
    Giá: <form:input path="price" /><br/>
    <input type="submit" value="Thêm"/>
</form:form>

<h2>Danh sách sản phẩm</h2>
<c:forEach var="p" items="${products}">
    <p>
            ${p.id} - ${p.name} - ${p.price}
        <a href="products/delete?id=${p.id}">Xóa</a>
    </p>
</c:forEach>
</body>
</html>
