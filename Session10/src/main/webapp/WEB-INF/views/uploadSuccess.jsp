<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/18/2025
  Time: 8:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h4>Upload Success</h4>
    <p>Description : ${uploadFile.description}</p>
    <p>File Name : ${uploadFile.file}</p>
    <p>Url : ${imageUrl}</p>
    <img src="${imageUrl}" alt="">
</body>
</html>
