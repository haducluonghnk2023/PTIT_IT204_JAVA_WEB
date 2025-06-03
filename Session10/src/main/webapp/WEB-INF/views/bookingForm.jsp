<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/18/2025
  Time: 10:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>Đặt Vé Xem Phim</title>
</head>
<body>
<h2>Form Đặt Vé</h2>

<form:form modelAttribute="ticket" method="post" action="${pageContext.request.contextPath}/bookTicket">
  <div>
    <label>Tên phim:</label><br/>
    <form:input path="movieTitle"/>
  </div>

  <div>
    <label>Giờ chiếu (yyyy-MM-dd HH:mm):</label><br/>
    <form:input path="showTime"/>
  </div>

  <div>
    <label>Chọn ghế (ví dụ: A1, A2):</label><br/>
    <input type="text" name="seatNumbers" placeholder="Ngăn cách bằng dấu phẩy" />
  </div>

  <div style="margin-top: 10px;">
    <button type="submit">Đặt vé</button>
  </div>
</form:form>
</body>
</html>
