<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/11/2025
  Time: 9:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Task List</title>
</head>
<body>
<h2>Danh sách công việc</h2>
<a href="tasks?action=add">Thêm công việc mới</a>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Description</th>
        <th>Due Date</th>
        <th>Completed</th>
        <th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="task" items="${tasks}">
        <tr>
            <td>${task.id}</td>
            <td>${task.description}</td>
            <td>${task.dueDate}</td>
            <td>${task.completed ? 'Yes' : 'No'}</td>
            <td>
                <a href="tasks?action=edit&id=${task.id}">Edit</a>
                <form action="tasks?action=delete" method="post" style="display:inline;">
                    <input type="hidden" name="id" value="${task.id}">
                    <input type="submit" value="Delete">
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
