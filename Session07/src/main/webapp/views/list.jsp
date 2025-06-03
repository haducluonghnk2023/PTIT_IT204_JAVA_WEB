<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/13/2025
  Time: 8:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>Danh sách góp ý</title>
</head>
<body>
<h2>Danh sách góp ý đã nhận</h2>

<c:if test="${empty feedbackList}">
  <p>Chưa có góp ý nào.</p>
</c:if>

<c:if test="${not empty feedbackList}">
  <table border="1">
    <tr>
      <th>Họ tên</th>
      <th>SĐT</th>
      <th>Địa chỉ</th>
      <th>Nội dung</th>
    </tr>
    <c:forEach var="f" items="${feedbackList}">
      <tr>
        <td>${f.fullName}</td>
        <td>${f.phone}</td>
        <td>${f.address}</td>
        <td>${f.content}</td>
      </tr>
    </c:forEach>
  </table>
</c:if>

<p><a href="form">Gửi góp ý mới</a></p>
</body>
</html>
