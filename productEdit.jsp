<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.pathwaysuccess1.dao.ProductDAO" %>
<%@ page import="com.pathwaysuccess1.dao.CategoryDAO" %>
<%@ page import="com.pathwaysuccess1.model.Product" %>
<%@ page import="com.pathwaysuccess1.model.Category" %>
<%@ page import="java.util.List" %>
<% 
    ProductDAO productDAO = new ProductDAO();
    CategoryDAO categoryDAO = new CategoryDAO();
    String productId = request.getParameter("productId");
    Product product = productDAO.getObjectById(productId);
    List<Category> categories = categoryDAO.listAll();
    request.setAttribute("product", product);
    request.setAttribute("categories", categories);
%>
<html>
<head>
    <title>Edit Product</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <div class="container">
        <h1>Edit Product</h1>
        <form action="ProductManagementServlet" method="post">
            <input type="hidden" name="action" value="update">
            <input type="hidden" name="productId" value="${product.productId}">
            <div class="form-group">
                <label for="productName">Product Name:</label>
                <input type="text" id="productName" name="productName" value="${product.productName}" required>
            </div>
            <div class="form-group">
                <label for="productImage">Image URL:</label>
                <input type="text" id="productImage" name="productImage" value="${product.productImage}">
            </div>
            <div class="form-group">
                <label for="brief">Brief:</label>
                <textarea id="brief" name="brief">${product.brief}</textarea>
            </div>
            <div class="form-group">
                <label for="typeId">Category:</label>
                <select id="typeId" name="typeId" required>
                    <c:forEach var="category" items="${categories}">
                        <option value="${category.typeId}" ${category.typeId == product.typeId ? 'selected' : ''}>${category.categoryName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="account">Account:</label>
                <input type="text" id="account" name="account" value="${product.account}" required>
            </div>
            <div class="form-group">
                <label for="unit">Unit:</label>
                <input type="text" id="unit" name="unit" value="${product.unit}">
            </div>
            <div class="form-group">
                <label for="price">Price:</label>
                <input type="number" id="price" name="price" value="${product.price}" required>
            </div>
            <div class="form-group">
                <label for="discount">Discount (%):</label>
                <input type="number" id="discount" name="discount" value="${product.discount}" min="0" max="100">
            </div>
            <button type="submit">Update Product</button>
        </form>
        <% if (request.getParameter("error") != null) { %>
            <p class="error"><%= request.getParameter("error") %></p>
        <% } %>
        <p><a href="ProductManagementServlet">Back to Product List</a></p>
        <div class="footer">© 2025 Product Management System</div>
    </div>
</body>
</html>