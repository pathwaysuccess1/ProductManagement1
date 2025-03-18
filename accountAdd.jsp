<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Account</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <div class="container">
        <h1>Add New Account</h1>
        <form action="AccountManagementServlet" method="post">
            <input type="hidden" name="action" value="add">
            <div class="form-group">
                <label for="account">Account:</label>
                <input type="text" id="account" name="account" required>
            </div>
            <div class="form-group">
                <label for "pass">Password:</label>
                <input type="password" id="pass" name="pass" required>
            </div>
            <div class="form-group">
                <label for="lastName">Last Name:</label>
                <input type="text" id="lastName" name="lastName">
            </div>
            <div class="form-group">
                <label for="firstName">First Name:</label>
                <input type="text" id="firstName" name="firstName" required>
            </div>
            <div class="form-group">
                <label for="birthday">Birthday (YYYY-MM-DD):</label>
                <input type="text" id="birthday" name="birthday" required>
            </div>
            <div class="form-group">
                <label for="gender">Gender:</label>
                <select id="gender" name="gender">
                    <option value="true">Male</option>
                    <option value="false">Female</option>
                </select>
            </div>
            <div class="form-group">
                <label for="phone">Phone:</label>
                <input type="text" id="phone" name="phone" required>
            </div>
            <div class="form-group">
                <label for="isUse">Active:</label>
                <select id="isUse" name="isUse">
                    <option value="true">Yes</option>
                    <option value="false">No</option>
                </select>
            </div>
            <div class="form-group">
                <label for="roleInSystem">Role:</label>
                <input type="text" id="roleInSystem" name="roleInSystem" value="customer">
            </div>
            <button type="submit">Add Account</button>
        </form>
        <p><a href="AccountManagementServlet">Back to Account List</a></p>
        <div class="footer">© 2025 Product Management System</div>
    </div>
</body>
</html>