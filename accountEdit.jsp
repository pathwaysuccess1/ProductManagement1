<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.pathwaysuccess1.dao.AccountDAO" %>
<%@ page import="com.pathwaysuccess1.model.Account" %>
<% 
    AccountDAO accountDAO = new AccountDAO();
    String accountId = request.getParameter("account");
    Account account = accountDAO.getObjectById(accountId);
    request.setAttribute("account", account);
%>
<html>
<head>
    <title>Edit Account</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <div class="container">
        <h1>Edit Account</h1>
        <form action="AccountManagementServlet" method="post">
            <input type="hidden" name="action" value="update">
            <input type="hidden" name="account" value="${account.account}">
            <div class="form-group">
                <label for="pass">Password:</label>
                <input type="password" id="pass" name="pass" value="${account.pass}" required>
            </div>
            <div class="form-group">
                <label for="lastName">Last Name:</label>
                <input type="text" id="lastName" name="lastName" value="${account.lastName}">
            </div>
            <div class="form-group">
                <label for="firstName">First Name:</label>
                <input type="text" id="firstName" name="firstName" value="${account.firstName}" required>
            </div>
            <div class="form-group">
                <label for="birthday">Birthday (YYYY-MM-DD):</label>
                <input type="text" id="birthday" name="birthday" value="${account.birthday}" required>
            </div>
            <div class="form-group">
                <label for="gender">Gender:</label>
                <select id="gender" name="gender">
                    <option value="true" ${account.gender ? 'selected' : ''}>Male</option>
                    <option value="false" ${!account.gender ? 'selected' : ''}>Female</option>
                </select>
            </div>
            <div class="form-group">
                <label for="phone">Phone:</label>
                <input type="text" id="phone" name="phone" value="${account.phone}" required>
            </div>
            <div class="form-group">
                <label for="isUse">Active:</label>
                <select id="isUse" name="isUse">
                    <option value="true" ${account.isUse ? 'selected' : ''}>Yes</option>
                    <option value="false" ${!account.isUse ? 'selected' : ''}>No</option>
                </select>
            </div>
            <div class="form-group">
                <label for="roleInSystem">Role:</label>
                <input type="text" id="roleInSystem" name="roleInSystem" value="${account.roleInSystem}">
            </div>
            <button type="submit">Update Account</button>
        </form>
        <% if (request.getParameter("error") != null) { %>
            <p class="error"><%= request.getParameter("error") %></p>
        <% } %>
        <p><a href="AccountManagementServlet">Back to Account List</a></p>
        <div class="footer">© 2025 Product Management System</div>
    </div>
</body>
</html>