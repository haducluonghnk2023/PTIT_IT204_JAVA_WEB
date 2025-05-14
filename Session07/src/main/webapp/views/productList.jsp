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
<head><title>Product List</title></head>
<body>
<h1>Product List</h1>

<a href="products09/add">Add New Product</a>

<form method="get" action="products09">
    <input type="text" name="search" placeholder="Search products"/>
    <button type="submit">Search</button>
</form>

<table>
    <tr>
        <th>Product Name</th>
        <th>Price</th>
        <th>Category</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="product" items="${products}">
        <tr>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>${product.categoryId}</td>
            <td>
                <a href="/Session07/products09/${product.id}">Details</a>
                <a href="/Session07/products09/edit/${product.id}">Edit</a>
                <a href="/Session07/products09/delete/${product.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

