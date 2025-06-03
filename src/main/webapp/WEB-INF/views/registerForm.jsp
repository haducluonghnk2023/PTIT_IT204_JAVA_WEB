<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
<head>
    <title>Đăng ký</title>
</head>
<body>
<h2>Form Đăng Ký</h2>

<form:form method="POST" action="/register" modelAttribute="register">
    <table>
        <tr>
            <td>Tên:</td>
            <td><form:input path="name"/></td>
            <td><form:errors path="name" cssClass="error"/></td>
        </tr>

        <tr>
            <td>Email:</td>
            <td><form:input path="email"/></td>
            <td><form:errors path="email" cssClass="error"/></td>
        </tr>

        <tr>
            <td>Mật khẩu:</td>
            <td><form:password path="password"/></td>
            <td><form:errors path="password" cssClass="error"/></td>
        </tr>

        <tr>
            <td colspan="2"><input type="submit" value="Đăng ký"/></td>
        </tr>
    </table>
</form:form>

<style>
    .error {
        color: red;
        font-style: italic;
    }
</style>
</body>
</html>
