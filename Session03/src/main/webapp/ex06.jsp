<%@ page import="java.util.List" %>
<%@ page import="com.data.session03.Product" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/7/2025
  Time: 8:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    ServletContext context = request.getServletContext();
    List<Product> products = (List<Product>) context.getAttribute("products");
    if (products == null) {
        products = new ArrayList<>();
        context.setAttribute("products", products);
    }
    String name = request.getParameter("productName");
    String priceStr = request.getParameter("price");
    String description = request.getParameter("description");
    String stockStr = request.getParameter("stock");
    String status = request.getParameter("status");

    if (name != null && priceStr != null && stockStr != null && status != null) {
        try {
            int id = products.size() + 1;
            double price = Double.parseDouble(priceStr);
            int stock = Integer.parseInt(stockStr);

            Product newProduct = new Product(id, name, price, description, stock, status);
            products.add(newProduct);

            context.setAttribute("productList", products);
        } catch (Exception e) {
            out.println("<p style='color:red;'>Dữ liệu không hợp lệ!</p>");
        }
    }
%>
<html>
<head>
    <title>Ex06</title>
</head>
<body>
    <form method="post" action="ex06.jsp">
        Tên sản phẩm: <input type="text" name="productName" required><br><br>
        Giá: <input type="text" name="price" required><br><br>
        Mô tả: <input type="text" name="description"><br><br>
        Số lượng: <input type="number" name="stock" required><br><br>
        Trạng thái:
        <select name="status">
            <option value="Còn hàng">Còn hàng</option>
            <option value="Hết hàng">Hết hàng</option>
        </select><br><br>
        <input type="submit" value="Thêm sản phẩm">
    </form>

    <h3>Danh sách sản phẩm:</h3>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th><th>Tên</th><th>Giá</th><th>Mô tả</th><th>Số lượng</th><th>Trạng thái</th>
        </tr>
        <%
            for (Product p : products) {
        %>
        <tr>
            <td><%= p.getId() %></td>
            <td><%= p.getProductName() %></td>
            <td><%= p.getPrice() %></td>
            <td><%= p.getDescription() %></td>
            <td><%= p.getStock() %></td>
            <td><%= p.getStatus() %></td>
        </tr>
        <%
            }
        %>
    </table>
</body>
</html>
