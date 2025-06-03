<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/7/2025
  Time: 4:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Result</h1>
    <%
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username.equals("admin") && password.equals("123")) {
            try {
                int age = Integer.parseInt(request.getParameter("age"));
                if (age >= 18) {
                    response.sendRedirect("adult.jsp");
                } else {
                    response.sendRedirect("teen.jsp");
                }
            } catch (NumberFormatException e) {
                out.println("<h2>Invalid age input!</h2>");
            }
        } else {
            out.println("<h2>Login failed!</h2>");
        }
    %>
</body>
</html>
