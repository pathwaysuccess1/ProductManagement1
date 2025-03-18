<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Category Management</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <div class="container">
        <h1>Category Management</h1>
        <p><a href="ProductViewServlet">Back to Product List</a></p>
        <form action="CategoryManagementServlet" method="get">
            <input type="text" name="searchName" placeholder="Search by name">
            <button type="submit">Search</button>
        </form>
        <h2>All Categories</h2>
        <table>
            <tr><th>ID</th><th>Name</th><th>Memo</th><th>Actions</th></tr>
            <c:forEach var="category" items="${categoryList}">
                <tr>
                    <td>${category.typeId}</td>
                    <td>${category.categoryName}</td>
                    <td>${category.memo}</td>
                    <td>
                        <a href="categoryEdit.jsp?typeId=${category.typeId}">Edit</a> |
                        <a href="CategoryManagementServlet?action=delete&typeId=${category.typeId}" onclick="return confirm('Are you sure?')">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <p><a href="categoryAdd.jsp">Add New Category</a></p>
        <div class="footer">© 2025 Product Management System</div>
    </div>
</body>
</html>