<%@ page import="com.data.session06.model.ex03.ProductCart" %>
<%@ page import="java.util.List" %>
<%@ page import="com.data.session06.model.ex03.Product" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/13/2025
  Time: 8:21 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.data.session06.model.ex03.Product" %>
<%@ page import="com.data.session06.model.ex03.ProductCart" %>

<%
    List<ProductCart> cartList = (List<ProductCart>) request.getAttribute("cartList");
    Map<Integer, Product> productMap = (Map<Integer, Product>) request.getAttribute("productMap");
    double total = 0;
%>

<html>
<head>
    <meta charset="UTF-8">
    <title>Giỏ hàng</title>
</head>
<body>
<h2>Giỏ hàng</h2>

<table border="1" cellpadding="10">
    <tr>
        <th>Tên SP</th>
        <th>Giá</th>
        <th>Số lượng</th>
        <th>Tổng</th>
        <th>Xóa</th>
    </tr>

    <% if (cartList != null && !cartList.isEmpty()) {
        for (ProductCart cart : cartList) {
            Product p = productMap.get(cart.getProductId());
            if (p != null) {
                double sum = p.getPrice() * cart.getQuantity();
                total += sum;
    %>
    <tr>
        <td><%= p.getName() %></td>
        <td><%= p.getPrice() %></td>
        <td><%= cart.getQuantity() %></td>
        <td><%= sum %></td>
        <td>
            <form action="cart" method="post" style="display:inline;">
                <input type="hidden" name="cartId" value="<%= cart.getId() %>"/>
                <button type="submit">Xóa</button>
            </form>
        </td>
    </tr>
    <%
            }
        }
    %>
    <tr>
        <td colspan="3" align="right"><strong>Tổng tiền:</strong></td>
        <td colspan="2"><strong><%= total %></strong></td>
    </tr>
    <% } else { %>
    <tr>
        <td colspan="5" align="center">Giỏ hàng trống</td>
    </tr>
    <% } %>
</table>

<br/>
<a href="product">Quay lại danh sách sản phẩm</a>
</body>
</html>

