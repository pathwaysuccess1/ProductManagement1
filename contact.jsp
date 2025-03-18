<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Contact Us</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <div class="container">
        <h1>Contact Us</h1>
        <nav>
            <a href="HomeServlet">Home</a> |
            <a href="ProductViewServlet">Products</a> |
            <a href="about.jsp">About</a> |
            <% if (session.getAttribute("account") == null) { %>
                <a href="login.jsp">Login</a>
            <% } else { %>
                <a href="LogoutServlet">Logout</a>
            <% } %>
        </nav>
        <p>Email: support@productmanagement.com</p>
        <p>Phone: +84 123 456 789</p>
        <div class="footer">© 2025 Product Management System</div>
    </div>
</body>
</html>