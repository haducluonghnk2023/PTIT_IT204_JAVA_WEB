<%@ page import="com.data.session05.model.Product" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/10/2025
  Time: 6:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách sản phẩm</title>
</head>
<body>
    <h2>Danh sách sản phẩm</h2>
    <table border="1" cellpadding="5" cellspacing="0">
        <tr>
            <th>ID</th><th>Tên</th><th>Giá</th><th>Mô tả</th>
        </tr>
        <%
            List<Product> list = (List<Product>) request.getAttribute("productList");
            for (Product p : list) {
        %>
        <tr>
            <td><%= p.getProductId() %></td>
            <td><%= p.getProductName() %></td>
            <td><%= p.getPrice() %></td>
            <td><%= p.getDescription() %></td>
        </tr>
        <% } %>
    </table>
</body>
</html>
