<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <div class="container">
        <h1>Welcome, ${sessionScope.fullname}!</h1>
        <p>You have successfully logged in.</p>
        <p>
            <a href="HomeServlet">Go to Home Page</a> |
            <% if ("admin".equals(session.getAttribute("role"))) { %>
                <a href="MainDashboardServlet">Go to Dashboard</a> |
            <% } %>
            <a href="LogoutServlet">Logout</a>
        </p>
        <div class="footer">© 2025 Product Management System</div>
    </div>
</body>
</html>