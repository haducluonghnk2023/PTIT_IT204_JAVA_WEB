<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/14/2025
  Time: 7:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Edit Product</title></head>
<body>
<h1>Edit Product</h1>
<form action="/Session07/products09/update" method="post">
    <input type="hidden" name="id" value="${product.id}"/>
    <input type="text" name="name" value="${product.name}" placeholder="Product Name"/>
    <input type="number" step="0.01" name="price" value="${product.price}" placeholder="Price"/>
    <select name="categoryId">
        <c:forEach var="category" items="${categories}">
            <option value="${category.id}" ${category.id == product.categoryId ? 'selected' : ''}>${category.name}</option>
        </c:forEach>
    </select>
    <button type="submit">Update</button>
</form>
</body>
</html>

