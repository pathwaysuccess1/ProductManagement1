package servlet;

import dao.AccountDAO;
import dao.CategoryDAO;
import dao.ProductDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/MainDashboardServlet")
public class MainDashboardServlet extends HttpServlet {
    private AccountDAO accountDAO = new AccountDAO();
    private CategoryDAO categoryDAO = new CategoryDAO();
    private ProductDAO productDAO = new ProductDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int totalAccounts = accountDAO.listAll().size();
            int totalCategories = categoryDAO.listAll().size();
            int totalProducts = productDAO.listAll().size();

            request.setAttribute("totalAccounts", totalAccounts);
            request.setAttribute("totalCategories", totalCategories);
            request.setAttribute("totalProducts", totalProducts);
            request.getRequestDispatcher("/MainDashboard.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Something went wrong!");
        }
    }
}