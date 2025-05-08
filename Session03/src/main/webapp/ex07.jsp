<%@ page import="com.data.session03.model.OrderProcessor" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/7/2025
  Time: 8:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String[] products = request.getParameterValues("product");
  String[] quantities = request.getParameterValues("quantity");
  String[] prices = request.getParameterValues("price");

  double total = 0;
  boolean hasInput = products != null && quantities != null && prices != null;

  if (hasInput) {
    total = OrderProcessor.calculateTotal(quantities, prices);
  }
%>
<html>
<head>
    <title>Ex07</title>
</head>
<body>
<h2>Thông tin đơn hàng</h2>
<form method="post" action="ex07.jsp">
  <table>
    <tr>
      <th>Sản phẩm</th>
      <th>Số lượng</th>
      <th>Giá (VND)</th>
    </tr>
    <%
      int rows = 3;
      for (int i = 0; i < rows; i++) {
    %>
    <tr>
      <td><input type="text" name="product" required></td>
      <td><input type="number" name="quantity" min="1" required></td>
      <td><input type="number" step="0.01" name="price" required></td>
    </tr>
    <% } %>
  </table>
  <br>
  <input type="submit" value="Tính tổng giá trị">
</form>

<% if (hasInput) { %>
<h3>Tổng giá trị đơn hàng: <%= String.format("%.2f", total) %> VND</h3>
<% } %>
</body>
</html>
