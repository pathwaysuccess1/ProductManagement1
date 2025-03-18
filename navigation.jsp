<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navigation">
    <a href="HomeServlet">Home</a> |
    <a href="ProductViewServlet">Products</a> |
    <a href="about.jsp">About</a> |
    <a href="contact.jsp">Contact</a> |
    <% if (session.getAttribute("account") == null) { %>
        <a href="login.jsp">Login</a>
    <% } else { %>
        <a href="AccountManagementServlet">Accounts</a> |
        <a href="CategoryManagementServlet">Categories</a> |
        <a href="ProductManagementServlet">Product Management</a> |
        <a href="CustomerAnalyticsServlet">Analytics</a> |
        <a href="LogoutServlet">Logout</a>
    <% } %>
</nav>