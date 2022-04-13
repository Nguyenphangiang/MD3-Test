<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 4/12/2022
  Time: 10:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Products</title>
</head>
<body>
<form method="post">
<table>
    <caption><h2>Edit Product</h2></caption>
    <tr>
        <th>Name:</th>
        <td><input type="text" name="nameProduct" value="${product.getName()}" ></td>
    </tr>
    <tr>
        <th>Price:</th>
        <td><input type="text" name="priceProduct" value="${product.getPrice()}"></td>
    </tr>
    <tr>
        <th>Quantity:</th>
        <td><input type="text" name="quantityProduct" value="${product.getQuantity()}"></td>
    </tr>
    <tr>
        <th>Color:</th>
        <td><input type="text" name="colorProduct" value="${product.getColor()}"></td>
    </tr>
    <tr>
        <th>Description:</th>
        <td>
            <textarea name="descriptionProduct"  cols="30" rows="10" >${product.getDescription()}</textarea>
        </td>
    </tr>
    <tr>
        <th>Category:</th>
        <td>
            <select name="categoryProduct" >
                <c:forEach items="${categories}" var="category">
                    <option value="${category.getId()}">${category.getName()}</option>
                </c:forEach>
            </select>
        </td>
    </tr>
    <tr>
        <td></td>
        <td>
            <button type="submit">Update</button>
            <button type="button" onclick="location.href='/ProductServlet?action=ProductServlet'">Back</button>
        </td>
    </tr>
</table>
</form>
</body>
</html>
