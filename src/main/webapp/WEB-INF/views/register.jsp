<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
  <title>Đăng ký người dùng</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f5f5f5;
    }

    h2 {
      text-align: center;
      color: #333;
    }

    form {
      width: 400px;
      margin: 0 auto;
      background: #fff;
      padding: 20px;
      border-radius: 8px;
      box-shadow: 0 0 10px rgba(0,0,0,0.1);
    }

    label {
      display: block;
      margin-top: 10px;
      font-weight: bold;
    }

    input, select {
      width: 100%;
      padding: 8px;
      margin-top: 4px;
      box-sizing: border-box;
      border: 1px solid #ccc;
      border-radius: 4px;
    }

    .error {
      color: red;
      font-size: 12px;
      margin-top: 2px;
    }

    button {
      margin-top: 15px;
      padding: 10px 15px;
      background-color: #007BFF;
      color: white;
      border: none;
      border-radius: 4px;
      cursor: pointer;
    }

    button:hover {
      background-color: #0056b3;
    }
  </style>
</head>
<body>
<h2>Form Đăng Ký</h2>

<form:form modelAttribute="user" action="${pageContext.request.contextPath}/registration" method="post">

  <label>Tên:</label>
  <form:input path="name"/>
  <form:errors path="name" cssClass="error"/>

  <label>Email:</label>
  <form:input path="email"/>
  <form:errors path="email" cssClass="error"/>

  <label>Phone Number:</label>
  <form:input path="phoneNumber"/>
  <form:errors path="phoneNumber" cssClass="error"/>

  <label>Vai trò:</label>
  <form:select path="role">
    <form:option value="" label="Chọn vai trò"/>
    <form:option value="user" label="Người dùng"/>
    <form:option value="admin" label="Quản trị"/>
  </form:select>
  <form:errors path="role" cssClass="error"/>

  <c:if test="${user.role == 'admin'}">
    <label>Mã quản trị:</label>
    <form:input path="adminCode"/>
    <form:errors path="adminCode" cssClass="error"/>
  </c:if>

  <c:if test="${user.role == 'user'}">
    <label>Tuổi:</label>
    <form:input path="age" type="number"/>
    <form:errors path="age" cssClass="error"/>
  </c:if>

  <button type="submit">Đăng ký</button>
</form:form>
</body>
</html>
