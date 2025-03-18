<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="/WEB-INF/tags/FormatPrice.tag" %>
<html>
<head>
    <title>${product.productName} - Details</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <div class="container">
        <h1>${product.productName}</h1>
        <nav>
            <a href="HomeServlet">Home</a> |
            <a href="ProductViewServlet">Products</a> |
            <a href="about.jsp">About</a> |
            <a href="contact.jsp">Contact</a> |
            <% if (session.getAttribute("account") == null) { %>
                <a href="login.jsp">Login</a> |
                <a href="register.jsp">Register</a>
            <% } else { %>
                Hello, ${sessionScope.fullname} |
                <a href="CustomerViewedProductsServlet">Viewed Products</a> |
                <a href="CustomerAnalyticsServlet">Analytics</a> |
                <a href="LogoutServlet">Logout</a>
            <% } %>
        </nav>
        <div class="product-details">
            <img src="${product.productImage}" alt="${product.productName}">
            <div class="details">
                <p><strong>Price:</strong> <fmt:formatPrice value="${product.finalPrice}"/> VNĐ <c:if test="${product.discount > 0}"><span class="discount">(-${product.discount}%)</span></c:if></p>
                <p><strong>Brief:</strong> ${product.brief}</p>
                <p><strong>Posted Date:</strong> ${product.postedDate}</p>
                <p><strong>Unit:</strong> ${product.unit}</p>
                <c:if test="${sessionScope.account != null}">
                    <a href="reviewProduct.jsp?productId=${product.productId}">Write a Review</a>
                </c:if>
            </div>
        </div>
        <h2>Reviews</h2>
        <c:forEach var="review" items="${reviews}">
            <div class="review">
                <p><strong>${review.account}</strong> - Rating: ${review.rating}/5</p>
                <p>${review.comment}</p>
                <p><em>${review.reviewDate}</em></p>
            </div>
        </c:forEach>
        <p><a href="ProductViewServlet">Back to Product List</a></p>
        <div class="footer">© 2025 Product Management System</div>
    </div>
</body>
</html>