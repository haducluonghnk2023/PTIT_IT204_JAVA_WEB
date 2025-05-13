<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/12/2025
  Time: 5:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Book</title>
</head>
<body>
<h2>Edit Book</h2>

<form action="BookController?action=update" method="post">
    <input type="hidden" name="id" value="<%= request.getAttribute("bookId") %>" />

    <table>
        <tr>
            <td>Title</td>
            <td><input type="text" name="title" value="<%= request.getAttribute("title") %>" /></td>
        </tr>
        <tr>
            <td>Author</td>
            <td><input type="text" name="author" value="<%= request.getAttribute("author") %>" /></td>
        </tr>
        <tr>
            <td>Category</td>
            <td><input type="text" name="category" value="<%= request.getAttribute("category") %>" /></td>
        </tr>
        <tr>
            <td>Quantity</td>
            <td><input type="number" name="quantity" value="<%= request.getAttribute("quantity") %>" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Update Book" />
                <a href="<%= request.getContextPath() %>/BookController?action=findAll">Cancel</a>
            </td>
        </tr>
    </table>
</form>
</body>
</html>

