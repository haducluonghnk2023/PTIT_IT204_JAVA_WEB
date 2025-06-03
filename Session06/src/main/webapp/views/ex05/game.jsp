<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/13/2025
  Time: 11:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Trò Chơi Oẳn Tù Tì</title>
</head>
<body>
<h1>Trò Chơi Oẳn Tù Tì</h1>

<form action="<%= request.getContextPath()%>/GameServlet" method="post">
    <p><strong>Lựa Chọn Của Bạn:</strong></p>
    <input type="radio" name="playerChoice" value="Búa" required> Búa
    <input type="radio" name="playerChoice" value="Kéo"> Kéo
    <input type="radio" name="playerChoice" value="Lá"> Lá
    <br><br>
    <button type="submit">Chơi</button>
</form>

<%
    String user = (String) request.getAttribute("playerChoice");
    String computer = (String) request.getAttribute("computerChoice");
    String result = (String) request.getAttribute("result");
    if (user != null && computer != null && result != null) {
%>
<h2>Kết Quả:</h2>
<p>Lựa Chọn Của Bạn: <%= user %></p>
<p>Lựa Chọn Của Máy Tính: <%= computer %></p>
<p><strong><%= result %></strong></p>
<% } %>
</body>
</html>
