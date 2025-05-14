<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/13/2025
  Time: 8:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Góp ý khách hàng</title>
</head>
<body>
<h2>Form Góp Ý</h2>
<form action="submitForm" method="post">
    Họ và tên: <input type="text" name="fullName" /><br/><br/>
    Số điện thoại: <input type="text" name="phone" /><br/><br/>
    Địa chỉ: <input type="text" name="address" /><br/><br/>
    Nội dung góp ý:<br/>
    <textarea name="content" rows="5" cols="40"></textarea><br/><br/>
    <input type="submit" value="Gửi góp ý" />
</form>
</body>
</html>
