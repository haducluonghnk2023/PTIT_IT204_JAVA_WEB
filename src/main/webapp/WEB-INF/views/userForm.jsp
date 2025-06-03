<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/22/2025
  Time: 10:57 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
  <title>Form Người Dùng</title>
</head>
<body>
<h2>Form Nhập Thông Tin Người Dùng</h2>

<form:form method="POST" action="submitForm" modelAttribute="user">
  <table>
    <tr>
      <td>Tên:</td>
      <td><form:input path="name" /></td>
      <td><form:errors path="name" cssClass="error" /></td>
    </tr>
    <tr>
      <td>Email:</td>
      <td><form:input path="email" /></td>
      <td><form:errors path="email" cssClass="error" /></td>
    </tr>
    <tr>
      <td>Phone:</td>
      <td><form:input path="phone" /></td>
      <td><form:errors path="phone" cssClass="error" /></td>
    </tr>
    <tr>
      <td>Password:</td>
      <td><form:password path="password" /></td>
      <td><form:errors path="password" cssClass="error" /></td>
    </tr>
    <tr>
      <td>Trạng thái:</td>
      <td><form:checkbox path="status" /></td>
    </tr>
    <tr>
      <td colspan="2">
        <input type="submit" value="Gửi" />
      </td>
    </tr>
  </table>
</form:form>

<style>
  .error { color: red; font-style: italic; }
</style>

</body>
</html>
