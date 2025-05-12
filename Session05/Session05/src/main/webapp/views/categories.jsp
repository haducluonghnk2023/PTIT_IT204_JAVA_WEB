<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/9/2025
  Time: 4:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Categories</title>
</head>
<body>
    <h3>List Categories</h3>
    <table border="1">
        <thead>
            <tr>
                <th>No</th>
                <th>Category ID</th>
                <th>Category Name</th>
                <th>Category Description</th>
                <th>Status</th>
                <th colspan="2">Action</th>
            </tr>
        </thead>
        <c:forEach items="${listCategories}" var="categories" varStatus="status">
            <tbody>
                <tr>
                    <td>${status.index + 1}</td>
                    <td>${categories.catalogId}</td>
                    <td>${categories.catalogName}</td>
                    <td>${categories.description}</td>
                    <td>${categories.status}</td>
                    <td>Sửa</td>
                    <td>Xoá</td>
                </tr>
            </tbody>
        </c:forEach>
    </table>
    <a href="views/newCatalog.jsp">Create new catalog</a>
</body>
</html>
