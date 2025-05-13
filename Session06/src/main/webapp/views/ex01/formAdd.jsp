<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/12/2025
  Time: 5:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="<%= request.getContextPath() %>/BookController?action=add" method="post">
    <table>
            <tr>
                <td>Title</td>
                <td><input type="text" name="title"/></td>
            </tr>
            <tr>
                <td>Author</td>
                <td><input type="text" name="author"/></td>
            </tr>
            <tr>
                <td>Category</td>
                <td><input type="text" name="category"/></td>
            </tr>
            <tr>
                <td>Quantity</td>
                <td><input type="number" name="quantity"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Add Book"/>
                    <a href="<%request.getContextPath();%>/Session06/BookController?action=findAll">Cancel</a>
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
