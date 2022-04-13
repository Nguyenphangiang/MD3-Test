<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 4/12/2022
  Time: 10:51 AM
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
        <caption><h2>Add New Product</h2></caption>
        <tr>
            <th>Name</th>
            <td><input type="text" name ="nameProduct"></td>
        </tr>
        <tr>
            <th>Price</th>
            <td><input type="text" name ="priceProduct"></td>
        </tr>
        <tr>
            <th>Quantity</th>
            <td><input type="text" name ="quantityProduct"></td>
        </tr>
        <tr>
            <th>Color</th>
            <td><input type="text" name ="colorProduct"></td>
        </tr>
        <tr>
            <th>Description</th>
            <td><textarea name="descriptionProduct" cols="30" rows="10"></textarea></td>
        </tr>
        <tr>
            <th>Category</th>
            <td>
                <select name="categoryProduct">
                    <c:forEach items="${categories}" var="category">
                        <option value="<c:out value="${category.getId()}"/>"><c:out value="${category.getName()}"/></option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <button type="submit">Add</button>
                <button type="button" onclick="location.href='/ProductServlet?action=ProductServlet'">Back</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
