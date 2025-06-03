<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/14/2025
  Time: 7:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Add Product</title></head>
<body>
<h1>Add Product</h1>
<form action="save" method="post">
    <input type="text" name="name" placeholder="Product Name"/>
    <input type="number" step="0.01" name="price" placeholder="Price"/>
    <select name="categoryId">
        <c:forEach var="category" items="${categories}">
            <option value="${category.id}">${category.name}</option>
        </c:forEach>
    </select>
    <button type="submit">Save</button>
</form>
</body>
</html>
