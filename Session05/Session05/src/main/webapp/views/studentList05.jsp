<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/11/2025
  Time: 8:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head><title>Danh sách sinh viên</title></head>
<body>
<h2>Danh sách sinh viên</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Tên</th>
        <th>Tuổi</th>
        <th>Địa chỉ</th>
        <th>Hành động</th>
    </tr>
    <c:forEach var="student" items="${studentLists}">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.age}</td>
            <td>${student.address}</td>
            <td>
                <form action="EditStudentController" method="get">
                    <input type="hidden" name="id" value="${student.id}" />
                    <input type="submit" value="Sửa" />
                </form>
                <form action="DeleteStudentController" method="post">
                    <input type="hidden" name="id" value="${student.id}" />
                    <input type="submit" value="Xóa" />
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
