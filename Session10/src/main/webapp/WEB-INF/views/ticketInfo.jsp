<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/18/2025
  Time: 10:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title>Thông Tin Vé</title>
</head>
<body>
<h2>Thông Tin Vé Đã Đặt</h2>

<p><strong>Phim:</strong> ${ticket.movieTitle}</p>
<p><strong>Giờ chiếu:</strong> ${ticket.showTime}</p>
<p><strong>Ghế:</strong>
  <c:forEach items="${ticket.seats}" var="seat">
    ${seat.seatNumber}
  </c:forEach>
</p>
<p><strong>Tổng tiền:</strong> ${ticket.totalAmount} VND</p>

</body>
</html>
