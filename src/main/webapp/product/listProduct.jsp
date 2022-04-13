<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 4/12/2022
  Time: 10:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products</title>

</head>
<body>
<h1><a href="/ProductServlet?action=add">Add New Product</a></h1>
<%--<form method="post">--%>
<%--    --%>
<%--</form>--%>
<form>
    <table>
        <input type="text" name="nameProduct" placeholder="enter name product">
        <input type="text" name="action" value="search" hidden>
        <input type="submit" value="Search">
        <caption><h2>Product List</h2></caption>
        <tr>
            <th>#</th>
            <th>Name</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>Color</th>
            <th>Description</th>
            <th>Category</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${products}" var="product">
            <tr>
                <td><c:out value="${product.getId()}"/></td>
                <td><c:out value="${product.getName()}"/></td>
                <td><c:out value="${product.getPrice()}"/></td>
                <td><c:out value="${product.getQuantity()}"/></td>
                <td><c:out value="${product.getColor()}"/></td>
                <td><c:out value="${product.getDescription()}"/></td>
                <td><c:out value="${product.getCategory().getName()}"/></td>
                <td>
                    <a href="/ProductServlet?action=edit&id=${product.getId()}">Edit</a>
                    <a href="/ProductServlet?action=delete&id=${product.getId()}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</form>
</body>
</html>
