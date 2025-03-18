<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Dashboard</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }

        body {
            background: linear-gradient(to right, #e0eafc, #cfdef3);
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            padding: 20px;
        }

        .container {
            background: #fff;
            width: 100%;
            max-width: 600px;
            padding: 30px;
            border-radius: 15px;
            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.1);
            text-align: center;
        }

        h1 {
            color: #2c3e50;
            font-size: 28px;
            margin-bottom: 20px;
            border-bottom: 2px solid #3498db;
            display: inline-block;
            padding-bottom: 5px;
        }

        .user-info {
            display: flex;
            justify-content: space-between;
            align-items: center;
            background: #f8f9fa;
            padding: 10px 15px;
            border-radius: 8px;
            margin-bottom: 20px;
            font-size: 16px;
            color: #34495e;
        }

        .user-info a {
            color: #e74c3c;
            text-decoration: none;
            font-weight: 500;
            transition: color 0.3s;
        }

        .user-info a:hover {
            color: #c0392b;
            text-decoration: underline;
        }

        .stats {
            display: grid;
            grid-template-columns: repeat(3, 1fr);
            gap: 15px;
            margin-bottom: 30px;
        }

        .stats p {
            background: #3498db;
            color: white;
            padding: 15px;
            border-radius: 10px;
            font-size: 16px;
            font-weight: 500;
            transition: transform 0.3s, box-shadow 0.3s;
        }

        .stats p:hover {
            transform: translateY(-5px);
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.2);
        }

        .stats p strong {
            display: block;
            font-size: 24px;
            margin-top: 5px;
        }

        .links {
            margin-bottom: 30px;
        }

        .links a {
            display: inline-block;
            margin: 0 10px;
            padding: 10px 20px;
            background: #2ecc71;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            font-weight: 500;
            transition: background 0.3s, transform 0.3s;
        }

        .links a:hover {
            background: #27ae60;
            transform: translateY(-3px);
        }

        .footer {
            color: #7f8c8d;
            font-size: 14px;
            margin-top: 20px;
        }

        @media (max-width: 600px) {
            .container {
                padding: 20px;
            }

            .stats {
                grid-template-columns: 1fr;
            }

            .links a {
                display: block;
                margin: 10px 0;
            }
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Admin Dashboard</h1>
        <div class="user-info">
            <span>Hello, ${sessionScope.fullname}</span>
            <a href="LogoutServlet">Logout</a>
        </div>
        <div class="stats">
            <p>Total Accounts<br><strong>${totalAccounts}</strong></p>
            <p>Total Categories<br><strong>${totalCategories}</strong></p>
            <p>Total Products<br><strong>${totalProducts}</strong></p>
        </div>
        <div class="links">
            <a href="AccountManagementServlet">Manage Accounts</a>
            <a href="CategoryManagementServlet">Manage Categories</a>
            <a href="ProductManagementServlet">Manage Products</a>
            <a href="HomeServlet">Back to Home</a>
        </div>
        <div class="footer">© 2025 Product Management System</div>
    </div>
</body>
</html>