<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/16/2025
  Time: 4:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h4>Book Form</h4>
    <form:form method="post" action="bookSave" modelAttribute="book" >
        <div>Title</div>
        <form:input path="title" placeholder="Title" />
        <div>Isbn</div>
        <form:input path="isbn" placeholder="Isbn" />
        <div>Price</div>
        <form:input path="price" placeholder="Price" />
<%--        <div>Image</div>--%>
<%--        <form:input path="fileImage" type="file" placeholder="Image" />--%>
        <div>PublishDate</div>
        <form:input path="publishDate" placeholder="PublishDate" type="date" />
        <div>
            <button type="submit">Submit</button>
        </div>
    </form:form>
</body>
</html>
