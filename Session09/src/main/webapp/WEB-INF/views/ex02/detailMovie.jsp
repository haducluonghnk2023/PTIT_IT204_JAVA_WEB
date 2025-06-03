<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/15/2025
  Time: 5:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<html>
<head>
    <title>Chi tiết phim</title>
</head>
<body>
<h1>${movie.title}</h1>
<p><strong>Đạo diễn:</strong> <span>${movie.director}</span></p>
<p><strong>Thể loại:</strong> <span>${movie.genre}</span></p>
<p><strong>Thời lượng:</strong> <span>${movie.duration}</span> phút</p>
<p><strong>Ngôn ngữ:</strong> <span>${movie.language}</span></p>
<p><strong>Mô tả:</strong> <span>${movie.description}</span></p>

<h2>Lịch chiếu phim</h2>
<c:if test="${not empty schedules}">
    <table border="1" cellpadding="5" cellspacing="0">
        <thead>
        <tr>
            <th>Thời gian chiếu</th>
            <th>Phòng chiếu</th>
            <th>Định dạng</th>
            <th>Số ghế còn trống</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="schedule" items="${schedules}">
            <tr>
                <td>
                    <a href="${pageContext.request.contextPath}/book?scheduleId=${schedule.id}">
                        <fmt:formatDate value="${schedule.showTime}" pattern="dd/MM/yyyy HH:mm" />
                    </a>
                </td>
                <td>
                    <c:forEach var="room" items="${screenRooms}">
                        <c:if test="${room.id == schedule.screenRoomId}">
                            ${room.screenRoomName}
                        </c:if>
                    </c:forEach>
                </td>
                <td>${schedule.format}</td>
                <td>${schedule.availableSeats}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:if>
<c:if test="${empty schedules}">
    <p>Hiện tại chưa có lịch chiếu cho phim này.</p>
</c:if>

<br>
<a href="<%=request.getContextPath()%>/ex01/home">Quay về danh sách</a>
</body>
</html>

