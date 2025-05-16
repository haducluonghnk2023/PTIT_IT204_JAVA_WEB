<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/15/2025
  Time: 4:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Đăng nhập</title>
</head>
<body>
<h2>Đăng nhập</h2>

<form:form method="POST" action="${pageContext.request.contextPath}/login" modelAttribute="customer">
    <table>
        <tr>
            <td>Tên đăng nhập:</td>
            <td><form:input path="userName"/></td>
        </tr>
        <tr>
            <td>Mật khẩu:</td>
            <td><form:password path="password"/></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Đăng nhập"/>
            </td>
        </tr>
    </table>
</form:form>

<c:if test="${not empty error}">
    <p style="color:red">${error}</p>
</c:if>

</body>
</html>
