<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="/WEB-INF/tags/FormatPrice.tag" %>
<html>
<head>
    <title>Viewed Products</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <div class="container">
        <h1>Products You've Viewed</h1>
        <nav>
            <a href="HomeServlet">Home</a> |
            <a href="ProductViewServlet">Products</a> |
            <a href="LogoutServlet">Logout</a>
        </nav>
        <div class="product-grid">
            <c:forEach var="product" items="${viewedProducts}">
                <div class="product-card">
                    <img src="${product.productImage}" alt="${product.productName}">
                    <h3>${product.productName}</h3>
                    <p><fmt:formatPrice value="${product.finalPrice}"/> VNĐ</p>
                    <a href="ProductViewServlet?productId=${product.productId}">View Details</a>
                </div>
            </c:forEach>
        </div>
        <p><a href="ProductViewServlet">Back to Product List</a></p>
        <div class="footer">© 2025 Product Management System</div>
    </div>
</body>
</html>