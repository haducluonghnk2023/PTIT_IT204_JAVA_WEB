<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/13/2025
  Time: 8:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.data.session06.model.ex03.Product" %>
<%@ page import="java.util.List" %>
<%
    List<Product> products = (List<Product>) request.getAttribute("products");
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách sản phẩm</title>
</head>
<body>
<h2>Danh sách sản phẩm</h2>
<table border="1">
    <tr><th>Ảnh</th><th>Tên</th><th>Giá</th><th>Thêm</th></tr>
    <% for(Product p : products) { %>
    <tr>
        <td><img src="<%=p.getImageUrl()%>" width="100"/></td>
        <td><%=p.getName()%></td>
        <td><%=p.getPrice()%></td>
        <td>
            <form action="product" method="post">
                <input type="hidden" name="productId" value="<%=p.getId()%>" />
                <input type="number" name="quantity" value="1" min="1"/>
                <button type="submit">Thêm vào giỏ</button>
            </form>
        </td>
    </tr>
    <% } %>
</table>
<a href="cart">Xem giỏ hàng</a>
</body>
</html>
