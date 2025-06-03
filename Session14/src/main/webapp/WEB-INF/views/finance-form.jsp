<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/29/2025
  Time: 8:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<fmt:setBundle basename="messages" />
<html>
<head>
    <title><fmt:message key="form.title"/></title></head>
<body>
<h2><fmt:message key="form.heading"/></h2>

<c:if test="${success}">
    <p style="color:green;"><fmt:message key="form.success"/></p>
</c:if>

<form method="post" action="${pageContext.request.contextPath}/finance">
    <label><fmt:message key="form.username"/></label><br/>
    <input type="text" name="username" value="${username}" required/><br/><br/>

    <label><fmt:message key="form.description"/></label><br/>
    <input type="text" name="description" required/><br/><br/>

    <label><fmt:message key="form.amount"/></label><br/>
    <input type="number" name="amount" step="0.01" required/><br/><br/>

    <label><fmt:message key="form.type"/></label><br/>
    <select name="type">
        <option value="income"><fmt:message key="form.income"/></option>
        <option value="expense"><fmt:message key="form.expense"/></option>
    </select><br/><br/>

    <input type="submit" value="<fmt:message key='form.submit'/>"/>
</form>

<br/>
<a href="${pageContext.request.contextPath}/transactions"><fmt:message key="form.viewList"/></a>
</body>
</html>
