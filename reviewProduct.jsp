<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Review Product</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <div class="container">
        <h1>Review Product</h1>
        <form action="ReviewProductServlet" method="post">
            <input type="hidden" name="productId" value="${param.productId}">
            <div class="form-group">
                <label for="rating">Rating (1-5):</label>
                <select id="rating" name="rating" required>
                    <option value="1">1</option>
                    <option value="2">2</option>
                    <option value="3">3</option>
                    <option value="4">4</option>
                    <option value="5">5</option>
                </select>
            </div>
            <div class="form-group">
                <label for="comment">Comment:</label>
                <textarea id="comment" name="comment"></textarea>
            </div>
            <button type="submit">Submit Review</button>
        </form>
        <% if (request.getParameter("error") != null) { %>
            <p class="error"><%= request.getParameter("error") %></p>
        <% } %>
        <p><a href="ProductViewServlet?productId=${param.productId}">Back to Product Details</a></p>
        <div class="footer">© 2025 Product Management System</div>
    </div>
</body>
</html>