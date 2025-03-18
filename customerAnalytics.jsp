<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<canvas id="analyticsChart"></canvas>
<script>
    var ctx = document.getElementById('analyticsChart').getContext('2d');
    var chart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: ['Total Views', 'Income Segment'],
            datasets: [{
                    label: 'Your Stats',
                    data: [${totalViews}, ${incomeSegment.equals("High") ? 3 : incomeSegment.equals("Medium") ? 2 : 1}],
                    backgroundColor: ['#3498db', '#2ecc71']
                }]
        }
    });
</script>
<html>
    <head>
        <title>Customer Analytics</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    </head>
    <body>
        <div class="container">
            <h1>Your Analytics</h1>
            <nav>
                <a href="HomeServlet">Home</a> |
                <a href="ProductViewServlet">Products</a> |
                <a href="LogoutServlet">Logout</a>
            </nav>
            <div class="stats">
                <p>Total Products Viewed: <strong>${totalViews}</strong></p>
                <p>Income Segment: <strong>${incomeSegment}</strong></p>
            </div>
            <p><a href="ProductViewServlet">Back to Product List</a></p>
            <div class="footer">© 2025 Product Management System</div>
        </div>
    </body>
</html>