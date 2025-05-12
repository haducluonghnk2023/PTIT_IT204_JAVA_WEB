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
  <title>Edit Task</title>
</head>
<body>
<h2>Chỉnh sửa công việc</h2>
<form action="tasks?action=update" method="post">
  <input type="hidden" name="id" value="${task.id}">
  Description: <input type="text" name="description" value="${task.description}" required><br>
  Due Date: <input type="text" name="dueDate" value="${task.dueDate}" required><br>
  Completed: <input type="checkbox" name="completed" ${task.completed ? 'checked' : ''}><br>
  <input type="submit" value="Update">
</form>
</body>
</html>
