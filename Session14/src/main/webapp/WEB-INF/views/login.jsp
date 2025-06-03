<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Đăng nhập</title>
</head>
<body>
<h2>Đăng nhập</h2>

<c:if test="${not empty error}">
  <p style="color:red">${error}</p>
</c:if>

<form:form method="post" action="/login" modelAttribute="user">
  <label>Tên đăng nhập:</label><br/>
  <form:input path="username" /><br/>

  <label>Mật khẩu:</label><br/>
  <form:input path="password" /><br/>

  <label>
    <form:checkbox path="rememberMe" />
    Ghi nhớ tôi
  </label><br/><br/>

  <input type="submit" value="Đăng nhập" />
</form:form>

</body>
</html>
