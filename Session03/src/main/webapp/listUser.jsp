<%@ page import="com.data.session03.model.User" %>
<%@ page import="com.data.session03.model.UserManager" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/8/2025
  Time: 7:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  List<User> users = UserManager.getUsers();
  String message = (String) request.getAttribute("message");
%>
<html>
<head>
  <title>Danh sách người dùng</title>
  <script>
    function confirmDelete(id) {
      if (confirm("Bạn có chắc chắn muốn xóa người dùng này không?")) {
        var form = document.createElement('form');
        form.method = 'POST';
        form.action = 'user';

        var idInput = document.createElement('input');
        idInput.type = 'hidden';
        idInput.name = 'id';
        idInput.value = id;

        var actionInput = document.createElement('input');
        actionInput.type = 'hidden';
        actionInput.name = 'action';
        actionInput.value = 'delete';

        form.appendChild(idInput);
        form.appendChild(actionInput);
        document.body.appendChild(form);
        form.submit();
      }
    }
  </script>
</head>
<body>
<h2>Danh sách người dùng</h2>
<% if (message != null) { %>
<p style="color: green;"><%= message %></p>
<% } %>

<table border="1" cellpadding="5">
  <tr>
    <th>ID</th>
    <th>Tên</th>
    <th>Email</th>
    <th>Hành động</th>
  </tr>
  <%
    for (User user : users) {
  %>
  <tr>
    <td><%= user.getId() %></td>
    <td><%= user.getName() %></td>
    <td><%= user.getEmail() %></td>
    <td><button onclick="confirmDelete(<%= user.getId() %>)">Xóa</button></td>
  </tr>
  <% } %>
</table>

<br><a href="input.jsp">Thêm người dùng mới</a>
</body>
</html>
