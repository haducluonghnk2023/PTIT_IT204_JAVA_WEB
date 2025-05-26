<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/26/2025
  Time: 6:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h4>Bus List</h4>
    <a href="${pageContext.request.contextPath}/bus/add" style="display:inline-block; margin-bottom:10px; padding:6px 12px; background-color:#4CAF50; color:white; text-decoration:none; border-radius:4px;">
        Thêm Bus Mới
    </a>
    <table border="1">
        <thead>
            <tr>
                <th>Bus ID</th>
                <th>Bus License_plate</th>
                <th>Bus Type</th>
                <th>Bus Row Seat</th>
                <th>Bus Col Seat</th>
                <th>Bus Total Set</th>
                <th>Image</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="bus" items="${bus}">
                <tr>
                    <td>${bus.id}</td>
                    <td>${bus.licensePlate}</td>
                    <td>${bus.busType}</td>
                    <td>${bus.rowSeat}</td>
                    <td>${bus.colSeat}</td>
                    <td>${bus.totalSeat}</td>
                    <td><img src="${bus.image}" alt="Bus Image" width="100"/></td>
                    <td>
                        <a href="${pageContext.request.contextPath}/bus/detail/${bus.id}">View</a> |
                        <a href="${pageContext.request.contextPath}/bus/edit/${bus.id}">Edit</a> |
                        <a href="${pageContext.request.contextPath}/bus/delete/${bus.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
