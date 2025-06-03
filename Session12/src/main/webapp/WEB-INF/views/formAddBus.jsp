<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thêm mới Bus</title>
</head>
<body>
<h2>Thêm mới Bus</h2>
<form action="${pageContext.request.contextPath}/bus/save" method="post">
    <input type="hidden" name="id" value="${bus.id != null ? bus.id : ''}" />

    <label for="licensePlate">Biển số xe:</label><br/>
    <input type="text" id="licensePlate" name="licensePlate" value="${bus.licensePlate != null ? bus.licensePlate : ''}" required /><br/><br/>

    <label for="busType">Loại xe:</label><br/>
    <select id="busType" name="busType" required>
        <option value="">--Chọn loại xe--</option>
        <option value="NORMAL" ${bus.busType == 'NORMAL' ? 'selected' : ''}>NORMAL</option>
        <option value="VIP" ${bus.busType == 'VIP' ? 'selected' : ''}>VIP</option>
        <option value="LUXURY" ${bus.busType == 'LUXURY' ? 'selected' : ''}>LUXURY</option>
    </select><br/><br/>

    <label for="rowSeat">Số hàng ghế:</label><br/>
    <input type="number" id="rowSeat" name="rowSeat" min="1" value="${bus.rowSeat != null ? bus.rowSeat : ''}" required /><br/><br/>

    <label for="colSeat">Số cột ghế:</label><br/>
    <input type="number" id="colSeat" name="colSeat" min="1" value="${bus.colSeat != null ? bus.colSeat : ''}" required /><br/><br/>

    <label for="image">URL hình ảnh:</label><br/>
    <input type="text" id="image" name="image" value="${bus.image != null ? bus.image : ''}" /><br/><br/>

    <button type="submit">Lưu</button>
    <a href="${pageContext.request.contextPath}/bus">Hủy</a>
</form>
</body>
</html>
