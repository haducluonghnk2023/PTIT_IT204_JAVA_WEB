<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/22/2025
  Time: 8:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Đánh giá sản phẩm</title>
    <style>
        form {
            width: 400px;
            margin: 0 auto;
            padding: 20px;
            background: #fff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }

        label {
            display: block;
            margin-top: 10px;
            font-weight: bold;
        }

        input, select, textarea {
            width: 100%;
            padding: 8px;
            margin-top: 4px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        .error {
            color: red;
            font-size: 12px;
        }

        button {
            margin-top: 15px;
            background: #28a745;
            color: white;
            padding: 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        button:hover {
            background: #218838;
        }
    </style>
</head>
<body>

<h2 style="text-align: center;">Đánh giá sản phẩm</h2>

<form:form method="post" modelAttribute="review">

    <label>Tên:</label>
    <form:input path="name"/>
    <form:errors path="name" cssClass="error"/>

    <label>Email:</label>
    <form:input path="email"/>
    <form:errors path="email" cssClass="error"/>

    <label>Đánh giá (1-5 sao):</label>
    <form:select path="rating">
        <form:option value="" label="Chọn số sao"/>
        <form:option value="1" label="1 sao"/>
        <form:option value="2" label="2 sao"/>
        <form:option value="3" label="3 sao"/>
        <form:option value="4" label="4 sao"/>
        <form:option value="5" label="5 sao"/>
    </form:select>
    <form:errors path="rating" cssClass="error"/>

    <label>Bình luận:</label>
    <form:textarea path="comment" rows="4"/>
    <form:errors path="comment" cssClass="error"/>

    <button type="submit">Gửi đánh giá</button>
</form:form>

</body>
</html>
