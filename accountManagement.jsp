<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Account Management</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <div class="container">
        <header>
            <h1>Account Management</h1>
            <p><a href="ProductViewServlet" class="back-link">Back to Product List</a></p>
        </header>
        <main>
            <form action="AccountManagementServlet" method="get" class="search-form">
                <input type="text" name="searchName" placeholder="Search by name">
                <button type="submit">Search</button>
            </form>
            <h2>All Accounts</h2>
            <table class="account-table">
                <thead>
                    <tr>
                        <th>Account</th>
                        <th>Full Name</th>
                        <th>Phone</th>
                        <th>Role</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="account" items="${accountList}">
                        <tr>
                            <td>${account.account}</td>
                            <td>${account.fullName}</td>
                            <td>${account.phone}</td>
                            <td>${account.roleInSystem}</td>
                            <td>
                                <a href="accountEdit.jsp?account=${account.account}" class="action-link">Edit</a> |
                                <a href="AccountManagementServlet?action=delete&account=${account.account}" 
                                   onclick="return confirm('Are you sure?')" class="action-link delete-link">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <p><a href="accountAdd.jsp" class="add-link">Add New Account</a></p>
        </main>
        <footer class="footer">
            © 2025 Product Management System
        </footer>
    </div>
</body>
</html>