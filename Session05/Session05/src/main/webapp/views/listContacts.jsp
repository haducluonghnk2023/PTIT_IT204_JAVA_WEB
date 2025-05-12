<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/12/2025
  Time: 8:31 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Danh sách liên hệ</title></head>
<body>
<h2>Danh sách liên hệ</h2>
<a href="contacts?action=add">Thêm liên hệ</a>
<table border="1">
    <tr><th>Họ</th><th>Tên</th><th>Email</th><th>Phone</th><th>Thao tác</th></tr>
    <c:forEach var="c" items="${contacts}">
        <tr>
            <td>${c.firstName}</td>
            <td>${c.lastName}</td>
            <td>${c.email}</td>
            <td>${c.phone}</td>
            <td>
                <a href="contacts?action=edit&id=${c.id}">Sửa</a>
                <form action="contacts?action=delete" method="post" style="display:inline;">
                    <input type="hidden" name="id" value="${c.id}">
                    <button type="submit" onclick="return confirm('Xác nhận xóa?')">Xóa</button>
                </form
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

