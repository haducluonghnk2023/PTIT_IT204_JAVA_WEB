<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/8/2025
  Time: 9:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Danh sách sinh viên</title>
</head>
<body>
<h2>Danh Sách Sinh Viên</h2>

<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Tên</th>
        <th>Tuổi</th>
        <th>Điểm Trung Bình</th>
    </tr>
    </thead>
    <tbody>
    <c:set var="count" value="0" /> <!-- Biến đếm số sinh viên có điểm trung bình > 7.0 -->
    <c:forEach var="student" items="${students}">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.age}</td>
            <td>${student.gpa}</td>
        </tr>
        <!-- Kiểm tra điểm trung bình và tăng biến đếm nếu điểm > 7.0 -->
        <c:if test="${student.gpa > 7.0}">
            <c:set var="count" value="${count + 1}" />
        </c:if>
    </c:forEach>
    </tbody>
</table>

<p>Số sinh viên có điểm trung bình lớn hơn 7.0: ${count}</p>
</body>
</html>

