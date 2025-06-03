<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/25/2025
  Time: 6:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>
        <c:choose>
            <c:when test="${product.id == null || product.id == 0}">Thêm Sản Phẩm</c:when>
            <c:otherwise>Sửa Sản Phẩm</c:otherwise>
        </c:choose>
    </h2>
    <form:form modelAttribute="product" method="post" action="${pageContext.request.contextPath}/product/save" >
        <form:hidden path="id" />

        <table>
            <tr>
                <td>Name:</td>
                <td><form:input path="name" /></td>
            </tr>

            <tr>
                <td>Price:</td>
                <td><form:input path="price" /></td>
            </tr>

            <tr>
                <td>Quantity:</td>
                <td><form:input path="quantity" /></td>
            </tr>
            <tr>
                <td>Image (tên file hoặc URL):</td>
                <td><form:input path="image" /></td>
            </tr>

            <tr>
                <td colspan="2">
                    <input type="submit"
                           value="<c:choose><c:when test='${product.id == null || product.id == 0}'>Thêm mới</c:when><c:otherwise>Cập nhật</c:otherwise></c:choose>" />
                </td>
            </tr>
        </table>
    </form:form>
</body>
</html>
