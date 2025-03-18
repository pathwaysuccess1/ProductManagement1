<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.pathwaysuccess1.dao.CategoryDAO" %>
<%@ page import="com.pathwaysuccess1.model.Category" %>
<%@ page import="java.util.List" %>
<% 
    CategoryDAO categoryDAO = new CategoryDAO();
    List<Category> categories = categoryDAO.listAll();
    request.setAttribute("categories", categories);
%>
<html>
<head>
    <title>Add Product</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <div class="container">
        <h1>Add New Product</h1>
        <form action="ProductManagementServlet" method="post">
            <input type="hidden" name="action" value="add">
            <div class="form-group">
                <label for="productId">Product ID:</label>
                <input type="text" id="productId" name="productId" required>
            </div>
            <div class="form-group">
                <label for="productName">Product Name:</label>
                <input type="text" id="productName" name="productName" required>
            </div>
            <div class="form-group">
                <label for="productImage">Image URL:</label>
                <input type="text" id="productImage" name="productImage">
            </div>
            <div class="form-group">
                <label for="brief">Brief:</label>
                <textarea id="brief" name="brief"></textarea>
            </div>
            <div class="form-group">
                <label for="typeId">Category:</label>
                <select id="typeId" name="typeId" required>
                    <c:forEach var="category" items="${categories}">
                        <option value="${category.typeId}">${category.categoryName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="account">Account:</label>
                <input type="text" id="account" name="account" required>
            </div>
            <div class="form-group">
                <label for="unit">Unit:</label>
                <input type="text" id="unit" name="unit" value="pcs">
            </div>
            <div class="form-group">
                <label for="price">Price:</label>
                <input type="number" id="price" name="price" required>
            </div>
            <div class="form-group">
                <label for="discount">Discount (%):</label>
                <input type="number" id="discount" name="discount" value="0" min="0" max="100">
            </div>
            <button type="submit">Add Product</button>
        </form>
        <p><a href="ProductManagementServlet">Back to Product List</a></p>
        <div class="footer">© 2025 Product Management System</div>
    </div>
</body>
</html>