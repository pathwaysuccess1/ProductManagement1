<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>About Us - Product Management System</title>
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
            align-items: flex-start;
            min-height: 100vh;
            padding: 20px;
        }

        .container {
            background: #fff;
            width: 100%;
            max-width: 800px;
            padding: 30px;
            border-radius: 15px;
            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.1);
            text-align: center;
        }

        h1 {
            color: #2c3e50;
            font-size: 32px;
            margin-bottom: 20px;
            border-bottom: 3px solid #3498db;
            display: inline-block;
            padding-bottom: 5px;
        }

        .about-content {
            text-align: left;
            margin: 20px 0;
            line-height: 1.8;
            color: #34495e;
            font-size: 16px;
        }

        .about-content p {
            margin-bottom: 15px;
        }

        .mission, .team {
            background: #f8f9fa;
            padding: 20px;
            border-radius: 10px;
            margin: 20px 0;
            transition: transform 0.3s, box-shadow 0.3s;
        }

        .mission:hover, .team:hover {
            transform: translateY(-5px);
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.2);
        }

        .mission h2, .team h2 {
            color: #3498db;
            font-size: 24px;
            margin-bottom: 10px;
        }

        .team ul {
            list-style-type: none;
            padding-left: 0;
        }

        .team ul li {
            margin: 10px 0;
            font-style: italic;
            color: #7f8c8d;
        }

        .contact {
            margin-top: 20px;
            padding: 15px;
            background: #2ecc71;
            color: white;
            border-radius: 10px;
            font-size: 16px;
        }

        .contact a {
            color: #fff;
            text-decoration: underline;
            font-weight: 500;
        }

        .contact a:hover {
            color: #27ae60;
        }

        .footer {
            color: #7f8c8d;
            font-size: 14px;
            margin-top: 20px;
            border-top: 1px solid #ddd;
            padding-top: 10px;
        }

        .back-link {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            background: #3498db;
            color: white;
            text-decoration: none;
            border-radius: 5px;
            transition: background 0.3s, transform 0.3s;
        }

        .back-link:hover {
            background: #2980b9;
            transform: translateY(-3px);
        }

        @media (max-width: 600px) {
            .container {
                padding: 20px;
            }

            h1 {
                font-size: 24px;
            }

            .mission h2, .team h2 {
                font-size: 20px;
            }

            .about-content {
                font-size: 14px;
            }
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>About Us</h1>
        <div class="about-content">
            <p>Welcome to the <strong>Product Management System</strong>, a robust platform designed to streamline the management of products, categories, and user accounts. Our mission is to provide an efficient and user-friendly solution for businesses and administrators to oversee their inventory and customer interactions seamlessly.</p>
            <p>Established in 2025, our system is built with the latest technologies to ensure scalability, security, and performance. Whether you're an admin managing resources or a customer exploring products, we aim to enhance your experience with every update.</p>
        </div>

        <div class="mission">
            <h2>Our Mission</h2>
            <p>To empower businesses with a powerful tool that simplifies product management, improves decision-making, and fosters growth through innovative features and reliable support.</p>
        </div>

        <div class="team">
            <h2>Our Team</h2>
            <ul>
                <li>Nguyen Van A - Lead Developer</li>
                <li>Tran Thi B - UI/UX Designer</li>
                <li>Le Van C - Database Engineer</li>
                <li>Pham Thi D - Quality Assurance</li>
            </ul>
        </div>

        <div class="contact">
            <p>For inquiries, please contact us at: <a href="mailto:support@productmgmt.com">support@productmgmt.com</a></p>
            <p>Follow us on social media for updates: <a href="https://facebook.com/productmgmt" target="_blank">Facebook</a></p>
        </div>

        <a href="HomeServlet" class="back-link">Back to Home</a>
        <div class="footer">© 2025 Product Management System</div>
    </div>
</body>
</html>