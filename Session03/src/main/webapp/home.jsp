<%@ page import="com.data.session03.model.Book" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/7/2025
  Time: 8:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    HttpSession session1 = request.getSession();
    ArrayList<Book> books = (ArrayList<Book>) session1.getAttribute("books");
    ArrayList<Book> searchResults = (ArrayList<Book>) request.getAttribute("searchResults");
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Thêm sách mới</h2>
<form method="post" action="book">
    <input type="hidden" name="action" value="add">
    Tên sách: <input type="text" name="title" required><br>
    Tác giả: <input type="text" name="author" required><br>
    Năm xuất bản: <input type="number" name="year" required><br>
    <input type="submit" value="Thêm sách">
</form>

<h2>Tìm kiếm sách</h2>
<form method="post" action="book">
    <input type="hidden" name="action" value="search">
    Từ khóa tên sách: <input type="text" name="keyword">
    <input type="submit" value="Tìm kiếm">
</form>

<h2>Danh sách sách</h2>
<ul>
    <%
        List<Book> displayBooks = (searchResults != null) ? searchResults : books;
        if (displayBooks != null && !displayBooks.isEmpty()) {
            for (Book book : displayBooks) {
    %>
    <li>
        <strong><%= book.getTitle() %></strong> - <%= book.getAuthor() %> - <%= book.getYear() %>
    </li>
    <%
        }
    } else {
    %>
    <li>Không có sách nào để hiển thị.</li>
    <%
        }
    %>
</ul>
</body>
</html>
