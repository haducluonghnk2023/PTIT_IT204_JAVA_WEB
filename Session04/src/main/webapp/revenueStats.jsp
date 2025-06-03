<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/9/2025
  Time: 7:03 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Thống kê doanh thu</title>
</head>
<body>
<h2>Thống kê doanh thu theo tháng</h2>

<table border="1">
    <thead>
    <tr>
        <th>Tháng</th>
        <th>Doanh thu</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="revenue" items="${revenues}">
        <tr>
            <td>${revenue.month}</td>
            <td>${revenue.revenue}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<c:set var="totalRevenue" value="0" />
<c:forEach var="revenue" items="${revenues}">
    <c:set var="totalRevenue" value="${totalRevenue + revenue.revenue}" />
</c:forEach>

<h3>Tổng doanh thu: ${totalRevenue}</h3>

<c:choose>
    <c:when test="${totalRevenue > 10000}">
        <p>Doanh thu tổng cộng vượt quá 10,000!</p>
    </c:when>
    <c:otherwise>
        <p>Doanh thu tổng cộng không vượt quá 10,000.</p>
    </c:otherwise>
</c:choose>
</body>
</html>

