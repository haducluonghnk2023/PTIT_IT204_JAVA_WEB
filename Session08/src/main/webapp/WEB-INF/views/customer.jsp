<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/14/2025
  Time: 4:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Trang customer</title>
</head>
<body>
    <h4>List custommer</h4>
    <table border="1">
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Email</th>
            <th>Gender</th>
            <th>Customer Type</th>
        </tr>
        <c:forEach var="customer" items="${customers}">
            <tr>
                <td>${customer.id}</td>
                <td>${customer.name}</td>
                <td>${customer.email}</td>
                <td>${customer.gender}</td>
                <td>${customer.customerType}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
