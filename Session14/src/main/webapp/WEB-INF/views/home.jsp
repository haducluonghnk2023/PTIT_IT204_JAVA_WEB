<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/28/2025
  Time: 8:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>${title}</title>
</head>
<body>
<h1>${title}</h1>
<p>${greeting}</p>

<label>${instruction}</label>
<form method="get" action="home">
    <select name="lang" onchange="this.form.submit()">
        <option value="en" ${currentLang == 'en' ? 'selected' : ''}>English</option>
        <option value="vi" ${currentLang == 'vi' ? 'selected' : ''}>Tiếng Việt</option>
    </select>
</form>
</body>
</html>
