<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Category</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <div class="container">
        <h1>Add New Category</h1>
        <form action="CategoryManagementServlet" method="post">
            <input type="hidden" name="action" value="add">
            <div class="form-group">
                <label for="categoryName">Category Name:</label>
                <input type="text" id="categoryName" name="categoryName" required>
            </div>
            <div class="form-group">
                <label for="memo">Memo:</label>
                <textarea id="memo" name="memo"></textarea>
            </div>
            <button type="submit">Add Category</button>
        </form>
        <p><a href="CategoryManagementServlet">Back to Category List</a></p>
        <div class="footer">© 2025 Product Management System</div>
    </div>
</body>
</html>