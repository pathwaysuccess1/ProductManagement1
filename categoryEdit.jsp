<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.pathwaysuccess1.dao.CategoryDAO" %>
<%@ page import="com.pathwaysuccess1.model.Category" %>
<% 
    CategoryDAO categoryDAO = new CategoryDAO();
    String typeId = request.getParameter("typeId");
    Category category = categoryDAO.getObjectById(typeId);
    request.setAttribute("category", category);
%>
<html>
<head>
    <title>Edit Category</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <div class="container">
        <h1>Edit Category</h1>
        <form action="CategoryManagementServlet" method="post">
            <input type="hidden" name="action" value="update">
            <input type="hidden" name="typeId" value="${category.typeId}">
            <div class="form-group">
                <label for="categoryName">Category Name:</label>
                <input type="text" id="categoryName" name="categoryName" value="${category.categoryName}" required>
            </div>
            <div class="form-group">
                <label for="memo">Memo:</label>
                <textarea id="memo" name="memo">${category.memo}</textarea>
            </div>
            <button type="submit">Update Category</button>
        </form>
        <% if (request.getParameter("error") != null) { %>
            <p class="error"><%= request.getParameter("error") %></p>
        <% } %>
        <p><a href="CategoryManagementServlet">Back to Category List</a></p>
        <div class="footer">© 2025 Product Management System</div>
    </div>
</body>
</html>