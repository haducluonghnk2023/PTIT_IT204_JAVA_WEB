<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/25/2025
  Time: 6:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h4>Danh sach san pham</h4>

<a href="${pageContext.request.contextPath}/product/add">
    <button type="button">Thêm mới</button>
</a>
    <table border="1" cellpadding="5" cellspacing="0">
        <thead>
        <tr>
            <th>STT</th>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Image</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach var="product" items="${products}" varStatus="loop">
                <tr>
                    <td>${loop.index + 1}</td>
                    <td>${product.id}</td>
                    <td>${product.name}</td>
                    <td>${product.price}</td>
                    <td>${product.quantity}</td>
                    <td>
                        <c:if test="${not empty product.image}">
                            <img src="${pageContext.request.contextPath}/${product.image}" alt="Product Image" width="60" height="60"/>
                        </c:if>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/product/edit/${product.id}">Sửa</a> |
                        <a href="${pageContext.request.contextPath}/product/delete/${product.id}"
                           onclick="return confirm('Bạn có chắc muốn xóa sản phẩm này?');">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
