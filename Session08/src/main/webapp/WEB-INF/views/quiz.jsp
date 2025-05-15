<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/14/2025
  Time: 8:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Đoán Câu Hỏi</h1>

<div>
  <img style="width: 100px;height: 100px" src="${question.imageUrl}" alt="Image question">
  <form action="guess" method="post">
    <input type="hidden" name="question.id" value="${question.id}">
    <input type="text" name="userAnswer" placeholder="Nhập câu trả lời" required>
    <input type="hidden" name="guessCount" value="${guessCount}">
    <button type="submit">Đoán</button>
  </form>
</div>

<div>
  <p>${message}</p>
</div>

<c:if test="${message == 'Đã đoán đúng!' || message == 'Bạn hết lượt đoán'}">
  <form action="quiz" method="get">
    <button type="submit">Chơi lại</button>
  </form>
</c:if>
</body>
</html>
