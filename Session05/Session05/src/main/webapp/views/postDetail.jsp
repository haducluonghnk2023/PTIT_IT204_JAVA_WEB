<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/12/2025
  Time: 7:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Chi tiết bài viết</title></head>
<body>
<h2>${post.title}</h2>
<p><strong>Tác giả:</strong> ${post.author}</p>
<p><strong>Ngày đăng:</strong> ${post.publishDate}</p>
<hr>
<p>${post.content}</p>
<a href="blog">Quay lại danh sách</a>
</body>
</html>
