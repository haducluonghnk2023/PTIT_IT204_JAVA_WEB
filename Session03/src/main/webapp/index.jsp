<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
    <h1>Trang chủ</h1>

    <%!
        public void jspInit(){
            System.out.println("Giai doan khoi tao trong jsp");
        };
    %>
    <%!
        public void jspDestroy(){
            System.out.println("Giai doan huy trong jsp");
        };
    %>
    <%
        System.out.println("Giai doan service");
    %>
    <a href="login.jsp">login</a>
    <a href="ex01.jsp">Ex01</a>
    <a href="ex02.jsp">Ex02</a>
    <a href="ex03.jsp">Ex03</a>
    <a href="ex04.jsp">Ex04</a>
    <a href="ex05.jsp">Ex05</a>
    <a href="ex06.jsp">Ex06</a>
    <a href="ex07.jsp">Ex07</a>
    <a href="home.jsp">Ex08</a>
    <a href="input.jsp">Ex09</a>
    <a href="ex10.jsp">Ex10</a>
</body>
</html>