<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/7/2025
  Time: 8:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ex04</title>
</head>
<body>
    <form action="ex04.jsp" method="get">
        Số thứ nhất: <input type="number" name="num1" required><br><br>
        Số thứ hai: <input type="number" name="num2" required><br><br>
        <input type="submit" value="Tính tổng">
    </form>
    <%
        String n1 = request.getParameter("num1");
        String n2 = request.getParameter("num2");

        if (n1 != null && n2 != null) {
            try {
                int num1 = Integer.parseInt(n1);
                int num2 = Integer.parseInt(n2);
                int sum = num1 + num2;
    %>
    <h3>Kết quả:</h3>
    <p><strong><%= num1 %> + <%= num2 %> = <%= sum %></strong></p>
    <%
    } catch (NumberFormatException e) {
    %>
    <p style="color: red;">Vui lòng nhập số hợp lệ.</p>
    <%
            }
        }
    %>
</body>
</html>
