<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/16/2025
  Time: 7:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Đặt vé xem phim</title>
    <style>
        .seat {
            width: 30px;
            height: 30px;
            margin: 5px;
            display: inline-block;
            text-align: center;
            line-height: 30px;
            cursor: pointer;
            border-radius: 5px;
        }
        .seat.available {
            background-color: #90ee90;
        }
        .seat.booked {
            background-color: #ff4d4d;
            cursor: not-allowed;
        }
        .seat.selected {
            background-color: #007bff;
            color: white;
        }
    </style>

    <script>
        var selectedSeats = [];

        function toggleSeat(seatId, element) {
            if (element.classList.contains('booked')) {
                alert("Ghế này đã được đặt.");
                return;
            }

            var index = selectedSeats.indexOf(seatId);
            if (index > -1) {
                selectedSeats.splice(index, 1);
                element.classList.remove('selected');
            } else {
                selectedSeats.push(seatId);
                element.classList.add('selected');
            }

            document.getElementById('selectedSeatIds').value = selectedSeats.join(',');
        }

        function validateForm() {
            if (selectedSeats.length === 0) {
                alert("Vui lòng chọn ít nhất một ghế.");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>

<h1>Đặt vé xem phim</h1>

<p><strong>Thời gian chiếu:</strong> ${schedule.showTime}</p>
<p><strong>Phòng chiếu:</strong> ${screenRoom.screenRoomName}</p>
<p><strong>Định dạng:</strong> ${schedule.format}</p>

<h3>Chọn ghế:</h3>
<div>
    <c:forEach var="seat" items="${seatList}">
        <div
                class="seat ${seat.status == 'BOOKED' ? 'booked' : 'available'}"
                onclick="toggleSeat('${seat.id}', this)"
                title="Ghế số ${seat.seatNumber}, Giá: ${seat.price} VND">
                ${seat.seatNumber}
        </div>
    </c:forEach>
</div>

<form action="${pageContext.request.contextPath}/book" method="post" onsubmit="return validateForm();">
    <input type="hidden" name="scheduleId" value="${schedule.id}" />
    <input type="hidden" name="customerId" value="${customerId}" />
    <input type="hidden" id="selectedSeatIds" name="seatIds" />
    <br><br>
    <button type="submit">Đặt vé</button>
</form>

<br>
<a href="${pageContext.request.contextPath}/ex01/home">Quay về danh sách phim</a>

</body>
</html>
