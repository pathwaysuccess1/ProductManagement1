<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Product List</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <div class="container">
        <h1>Product List</h1>
        <p>Hello, ${sessionScope.fullname} | <a href="login.jsp">Logout</a></p>
        <table>
            <tr><th>ID</th><th>Name</th><th>Price</th><th>Discount</th><th>Action</th></tr>
            <c:forEach var="product" items="${productList}">
                <tr>
                    <td>${product.productId}</td>
                    <td>${product.productName}</td>
                    <td>${product.price}</td>
                    <td>${product.discount}%</td>
                    <td><a href="ProductViewServlet?productId=${product.productId}">View</a> | <a href="reviewProduct.jsp?productId=${product.productId}">Review</a></td>
                </tr>
            </c:forEach>
        </table>
        <p>
            <a href="CustomerViewedProductsServlet">Viewed Products</a> | 
            <a href="CustomerAnalyticsServlet">Analytics</a> | 
            <a href="AccountManagementServlet">Manage Accounts</a> | 
            <a href="CategoryManagementServlet">Manage Categories</a> | 
            <a href="ProductManagementServlet">Manage Products</a> | 
            <a href="about.jsp">About</a> | 
            <a href="contact.jsp">Contact</a>
        </p>
        <div class="footer">© 2025 Product Management System</div>
    </div>
</body>
</html>