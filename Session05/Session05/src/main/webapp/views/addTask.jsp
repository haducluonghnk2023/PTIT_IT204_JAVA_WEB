<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/11/2025
  Time: 9:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Add Task</title>
</head>
<body>
<h2>Thêm công việc mới</h2>
<form action="tasks?action=create" method="post">
  Description: <input type="text" name="description" required><br>
  Due Date: <input type="text" name="dueDate" required><br>
  <input type="submit" value="Create">
</form>
</body>
</html>
