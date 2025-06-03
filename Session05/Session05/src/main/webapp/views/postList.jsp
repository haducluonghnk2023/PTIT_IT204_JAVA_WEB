<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/12/2025
  Time: 7:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Danh sách bài viết</title></head>
<body>
<h2>Danh sách bài viết</h2>
<ul>
  <c:forEach var="post" items="${posts}">
    <li>
      <a href="blog?id=${post.id}">
        <strong>${post.title}</strong>
      </a> - Tác giả: ${post.author} - Ngày: ${post.publishDate}
    </li>
  </c:forEach>
</ul>
</body>
</html>
