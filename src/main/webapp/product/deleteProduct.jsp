<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 4/13/2022
  Time: 8:14 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
</head>
<body>
<form method="post">
    <table>
        <caption><h2>Are You Sure?</h2></caption>
        <tr>
            <th>Name</th>
            <td>${product.getName()}</td>
        </tr>
        <tr>
            <th>Price</th>
            <td>${product.getPrice()}</td>
        </tr>
        <tr>
            <th>Quantity</th>
            <td>${product.getQuantity()}</td>
        </tr>
        <tr>
            <th>Color</th>
            <td>${product.getColor()}</td>
        </tr>
        <tr>
            <th>Description</th>
            <td>${product.getDescription()}</td>
        </tr>
        <tr>
            <th>Category</th>
            <td>${product.getCategory().getName()}</td>
        </tr>
        <tr>
            <td></td>
            <td>
                <button type="submit">Delete</button>
                <button type="button" onclick="location.href='/ProductServlet?action=ProductServlet'">Back</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
