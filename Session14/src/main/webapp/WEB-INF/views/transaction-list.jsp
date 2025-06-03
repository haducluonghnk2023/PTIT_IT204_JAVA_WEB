<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/29/2025
  Time: 8:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<fmt:setBundle basename="messages" />
<html>
<head><title><fmt:message key="list.title"/></title></head>
<body>
<h2><fmt:message key="list.heading"/></h2>

<table border="1">
    <tr>
        <th><fmt:message key="form.description"/></th>
        <th><fmt:message key="form.amount"/></th>
        <th><fmt:message key="form.type"/></th>
        <th><fmt:message key="list.action"/></th>
    </tr>
    <c:forEach items="${transactions}" var="tx" varStatus="status">
        <tr>
            <td>${tx.description}</td>
            <td>${tx.amount}</td>
            <td>${tx.type}</td>
            <td><a href="transactions/delete?index=${status.index}"><fmt:message key="list.delete"/></a></td>
        </tr>
    </c:forEach>
</table>

<br/>
<a href="${pageContext.request.contextPath}/finance"><fmt:message key="form.back"/></a>
</body>
</html>
