
<%@ page import="java.util.List" %>
<%@ page import="com.data.session05.model.Student04" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/11/2025
  Time: 7:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách sinh viên</title>
</head>
<body>
<h2>Danh sách sinh viên</h2>
<%
    List<Student04> students = (List<Student04>) request.getAttribute("studentList");
    if (students != null && !students.isEmpty()) {
%>
<table border="1">
    <tr><th>ID</th><th>Tên</th><th>Tuổi</th><th>Địa chỉ</th></tr>
    <%
        for (Student04 s : students) {
    %>
    <tr>
        <td><%= s.getId() %></td>
        <td><%= s.getName() %></td>
        <td><%= s.getAge() %></td>
        <td><%= s.getAddress() %></td>
    </tr>
    <% } %>
</table>
<% } else { %>
<p>Không có sinh viên nào.</p>
<% } %>
<div>
    <c:if test="${currentPage > 1}">
        <a href="StudentListController?page=${currentPage - 1}">Trước</a>
    </c:if>

    <span>Trang ${currentPage} của ${totalPages}</span>

    <c:if test="${currentPage < totalPages}">
        <a href="StudentListController?page=${currentPage + 1}">Tiếp Theo</a>
    </c:if>
</div>
</body>
</html>
