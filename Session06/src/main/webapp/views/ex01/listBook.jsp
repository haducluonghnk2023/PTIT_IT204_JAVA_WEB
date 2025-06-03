<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/12/2025
  Time: 5:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Book Search</title>
</head>
<body>
<form action="BookController?action=search" method="get">
    <label for="search">Search:</label>
    <input type="text" name="keyword" id="search" value="${param.keyword}">
    <button type="submit">Search</button>
</form>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Author</th>
        <th>Category</th>
        <th>Quantity</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${empty books}">
        <tr>
            <td colspan="6">No books found</td>
        </tr>
    </c:if>
    <c:forEach items="${books}" var="book" varStatus="loop">
        <tr>
            <td>${loop.index + 1}</td>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>${book.category}</td>
            <td>${book.quantity}</td>
            <td>
                <a href="BookController?action=edit&id=${book.id}">Edit</a>
                <a href="BookController?action=delete&id=${book.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>

    </tbody>
</table>
<a href="views/ex01/formAdd.jsp">Create new book</a>
</body>
</html>

