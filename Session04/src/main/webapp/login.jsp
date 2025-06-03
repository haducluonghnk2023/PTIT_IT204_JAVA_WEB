<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/8/2025
  Time: 8:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Đăng nhập</title>
</head>
<body>
<h2>Form Đăng Nhập</h2>
<form action="login.jsp" method="post">
    <label>Username:</label>
    <input type="text" name="username" required><br><br>
    <label>Password:</label>
    <input type="password" name="password" required><br><br>
    <input type="submit" value="Đăng nhập">
</form>

<jsp:useBean id="username" class="java.lang.String" scope="request" />
<jsp:useBean id="password" class="java.lang.String" scope="request" />

<c:set var="u" value="${param.username}" />
<c:set var="p" value="${param.password}" />

<c:if test="${not empty u}">
    <c:choose>
        <c:when test="${u == 'admin' && p == '123456'}">
            <h3 style="color:green;">Đăng nhập thành công. Chào mừng, ${u}!</h3>
        </c:when>
        <c:otherwise>
            <h3 style="color:red;">Tên đăng nhập hoặc mật khẩu sai. Vui lòng thử lại.</h3>
        </c:otherwise>
    </c:choose>
</c:if>
</body>
</html>

