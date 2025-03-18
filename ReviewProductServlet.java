package servlet;

import dao.ReviewDAO;
import model.Review;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/ReviewProductServlet")
public class ReviewProductServlet extends HttpServlet {
    private ReviewDAO reviewDAO = new ReviewDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String account = (String) session.getAttribute("account");

        if (account == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String productId = request.getParameter("productId");
        int rating = Integer.parseInt(request.getParameter("rating"));
        String comment = request.getParameter("comment");

        try {
            reviewDAO.addReview(new Review(0, account, productId, rating, comment, null));
            response.sendRedirect("ProductViewServlet?productId=" + productId + "&success=Review submitted");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("reviewProduct.jsp?productId=" + productId + "&error=Failed to submit review");
        }
    }
}