
<%@ page import="com.data.session05.model.Student04" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/11/2025
  Time: 7:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Student04 student = (Student04) request.getAttribute("student");
    if (student == null) {
        out.println("<p style='color:red'>Không tìm thấy sinh viên.</p>");
        return;
    }

%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Sửa sinh viên</h2>
    <form action="UpdateStudentController" method="post">
        <input type="hidden" name="id" value="<%= student.getId() %>" />
        Tên: <input type="text" name="name" value="<%= student.getName() %>" /><br/>
        Tuổi: <input type="number" name="age" value="<%= student.getAge() %>" /><br/>
        Địa chỉ: <input type="text" name="address" value="<%= student.getAddress() %>" /><br/>
        <input type="submit" value="Cập nhật" />
    </form>
</body>
</html>
