<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
    <style>
        body { font-family: Arial, sans-serif; text-align: center; padding-top: 50px; background-color: #f0f2f5; }
        .login-container { width: 300px; margin: auto; background: white; padding: 20px; border-radius: 5px; box-shadow: 0 0 10px rgba(0,0,0,0.1); }
        input { width: 100%; padding: 10px; margin: 10px 0; border: 1px solid #ccc; border-radius: 4px; }
        button { width: 100%; padding: 10px; background-color: #007bff; color: white; border: none; border-radius: 4px; cursor: pointer; }
        button:hover { background-color: #0056b3; }
        .error { color: red; }
        .success { color: green; }
        a { color: #6c757d; text-decoration: none; }
        a:hover { text-decoration: underline; }
    </style>
</head>
<body>
    <div class="login-container">
        <h2>Login</h2>
        <% 
            String error = request.getParameter("error");
            if (error != null) { %>
                <p class="error"><%= error %></p>
            <% }
            String success = request.getParameter("success");
            if (success != null) { %>
                <p class="success"><%= success %></p>
            <% }
        %>
        <form action="LoginServlet" method="post">
            <div>
                <label>Account:</label><br>
                <input type="text" name="account" required>
            </div>
            <div>
                <label>Password:</label><br>
                <input type="password" name="pass" required>
            </div>
            <button type="submit">Login</button>
        </form>
        <p>Don't have an account? <a href="register.jsp">Register here</a></p>
        <p><a href="HomeServlet">Back to Home</a></p>
    </div>
    <footer>
        <p>&copy; 2025 Product Management System</p>
    </footer>
</body>
</html>