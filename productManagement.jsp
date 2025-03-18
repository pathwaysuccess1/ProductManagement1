<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product Management</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <div class="container">
        <h1>Product Management</h1>
        <p><a href="ProductViewServlet">Back to Product List</a></p>
        <form action="ProductManagementServlet" method="get">
            <input type="text" name="searchName" placeholder="Search by name">
            <button type="submit">Search</button>
            <a href="ProductManagementServlet?sortBy=rating">Sort by Rating</a> |
            <a href="ProductManagementServlet?sortBy=views">Sort by Views</a>
        </form>
        <h2>All Products</h2>
        <table>
            <tr><th>ID</th><th>Name</th><th>Price</th><th>Discount</th><th>Actions</th></tr>
            <c:forEach var="product" items="${productList}">
                <tr>
                    <td>${product.productId}</td>
                    <td>${product.productName}</td>
                    <td>${product.price}</td>
                    <td>${product.discount}%</td>
                    <td>
                        <a href="productEdit.jsp?productId=${product.productId}">Edit</a> |
                        <a href="ProductManagementServlet?action=delete&productId=${product.productId}" onclick="return confirm('Are you sure?')">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <p><a href="productAdd.jsp">Add New Product</a></p>
        <div class="footer">© 2025 Product Management System</div>
    </div>
</body>
</html>