<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title><c:choose>
        <c:when test="${student.id == 0}">Thêm Sinh Viên</c:when>
        <c:otherwise>Sửa Sinh Viên</c:otherwise>
    </c:choose></title>
</head>
<body>

<h2>
    <c:choose>
        <c:when test="${student.id == null || student.id == 0}">Thêm Sinh Viên</c:when>
        <c:otherwise>Sửa Sinh Viên</c:otherwise>
    </c:choose>
</h2>

<form:form modelAttribute="student" method="post" action="${pageContext.request.contextPath}/student/save" enctype="multipart/form-data" >
    <form:hidden path="id" />

    <table>
        <tr>
            <td>Họ và tên:</td>
            <td><form:input path="name" /></td>
        </tr>

        <tr>
            <td>Email:</td>
            <td><form:input path="email" /></td>
        </tr>

        <tr>
            <td>Số điện thoại:</td>
            <td><form:input path="phone" /></td>
        </tr>

        <tr>
            <td>Giới tính:</td>
            <td>
                <form:radiobutton path="sex" value="true" /> Nam
                <form:radiobutton path="sex" value="false" /> Nữ
            </td>
        </tr>

        <tr>
            <td>Ngày sinh:</td>
            <td><form:input path="birthday" type="date" /></td>
        </tr>

        <tr>
            <td>Avatar (tên file hoặc URL):</td>
            <td><form:input path="avatarFile" type="file" /></td>
        </tr>

        <tr>
            <td>Trạng thái:</td>
            <td>
                <form:select path="status">
                    <form:option value="ACTIVE" label="Đang hoạt động" />
                    <form:option value="INACTIVE" label="Ngưng hoạt động" />
                </form:select>
            </td>
        </tr>

        <tr>
            <td colspan="2">
                <input type="submit"
                       value="<c:choose><c:when test='${student.id == null}'>Thêm mới</c:when><c:otherwise>Cập nhật</c:otherwise></c:choose>" />
            </td>
        </tr>
    </table>
</form:form>

</body>
</html>
