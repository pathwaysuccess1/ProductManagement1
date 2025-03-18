<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Home - Product Management</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <div class="container">
        <h1>Welcome to Product Management</h1>
        <%@ include file="navigation.jsp" %>
        
        <h2>Featured Products</h2>
        <div class="product-grid">
            <c:forEach var="product" items="${featuredProducts}">
                <div class="product-card">
                    <img src="${product.productImage}" alt="${product.productName}">
                    <h3>${product.productName}</h3>
                    <p>
                        <c:set var="finalPrice" value="${product.price - (product.price * product.discount / 100)}" />
                        <fmt:formatNumber value="${finalPrice}" type="currency" currencySymbol="VNĐ " />
                    </p>
                    <a href="ProductViewServlet?productId=${product.productId}" class="action-link">View Details</a>
                </div>
            </c:forEach>
        </div>
        <p><a href="ProductViewServlet" class="add-link">View All Products</a></p>
        
        <h2>Categories</h2>
        <ul>
            <c:forEach var="category" items="${categories}">
                <li><a href="ProductViewServlet?typeId=${category.typeId}">${category.categoryName}</a></li>
            </c:forEach>
        </ul>
        
        <div class="footer">© 2025 Product Management System</div>
    </div>
</body>
</html>