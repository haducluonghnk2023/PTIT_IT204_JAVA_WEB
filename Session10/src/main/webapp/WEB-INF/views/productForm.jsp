<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/17/2025
  Time: 12:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h4>Product Form</h4>
    <form:form action="productSave" method="post" modelAttribute="product">
        <form:input path="name" placeholder="Product Name"/>
        <form:input path="price" placeholder="Product Price"/>
        <form:input path="description" placeholder="Product Description"/>
        <input type="submit" value="Submit"/>
    </form:form>
</body>
</html>
