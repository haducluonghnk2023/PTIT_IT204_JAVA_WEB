<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Trang Sinh Viên</title>
</head>
<body>
<h4>Danh sach sinh vien</h4>

<a href="${pageContext.request.contextPath}/student/add">
    <button type="button">Thêm mới</button>
</a>

<table border="1" cellpadding="5" cellspacing="0">
    <thead>
    <tr>
        <th>STT</th>
        <th>ID</th>
        <th>Họ tên</th>
        <th>Email</th>
        <th>Số điện thoại</th>
        <th>Giới tính</th>
        <th>Ngày sinh</th>
        <th>Avatar</th>
        <th>Trạng thái</th>
        <th>Chức năng</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="student" items="${students}" varStatus="loop">
        <tr>
            <td>${loop.index + 1}</td>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.email}</td>
            <td>${student.phone}</td>
            <td>
                <c:choose>
                    <c:when test="${student.sex}">Nam</c:when>
                    <c:otherwise>Nữ</c:otherwise>
                </c:choose>
            </td>
            <td>${student.birthday}</td>
            <td>
                <c:if test="${not empty student.avatar}">
                    <img src="${pageContext.request.contextPath}/${student.avatar}" alt="Avatar" width="60" height="60"/>
                </c:if>
            </td>
            <td>${student.status}</td>
            <td>
                <a href="${pageContext.request.contextPath}/student/edit/${student.id}">Sửa</a> |
                <a href="${pageContext.request.contextPath}/student/delete/${student.id}"
                   onclick="return confirm('Bạn có chắc muốn xóa sinh viên này?');">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
