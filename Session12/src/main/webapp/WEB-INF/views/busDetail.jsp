<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chi tiết Bus</title>
</head>
<body>
<h2>Chi tiết Bus</h2>

<table border="1" cellpadding="10" cellspacing="0">
    <tr>
        <th>ID</th>
        <td>${bus.id}</td>
    </tr>
    <tr>
        <th>Biển số xe</th>
        <td>${bus.licensePlate}</td>
    </tr>
    <tr>
        <th>Loại xe</th>
        <td>${bus.busType}</td>
    </tr>
    <tr>
        <th>Số hàng ghế</th>
        <td>${bus.rowSeat}</td>
    </tr>
    <tr>
        <th>Số cột ghế</th>
        <td>${bus.colSeat}</td>
    </tr>
    <tr>
        <th>Tổng số ghế</th>
        <td>${bus.totalSeat}</td>
    </tr>
    <tr>
        <th>Hình ảnh</th>
        <td>
            <img src="${bus.image}" alt="Bus Image" width="300" />
        </td>
    </tr>
</table>

<br/>
<a href="${pageContext.request.contextPath}/bus">Quay về danh sách Bus</a>
</body>
</html>
