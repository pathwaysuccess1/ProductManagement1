package servlet;

import dao.CategoryDAO;
import model.Category;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/CategoryManagementServlet")
public class CategoryManagementServlet extends HttpServlet {
    private CategoryDAO categoryDAO = new CategoryDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String typeId = request.getParameter("typeId");
        String searchName = request.getParameter("searchName");

        try {
            if ("delete".equals(action) && typeId != null) {
                categoryDAO.deleteRec(new Category(Integer.parseInt(typeId), null, null));
                response.sendRedirect("CategoryManagementServlet");
                return;
            }

            List<Category> categoryList = searchName != null && !searchName.isEmpty() ?
                categoryDAO.searchByName(searchName) : categoryDAO.listAll();
            request.setAttribute("categoryList", categoryList);
            request.getRequestDispatcher("/categoryManagement.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Something went wrong!");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String typeId = request.getParameter("typeId");
        String categoryName = request.getParameter("categoryName");
        String memo = request.getParameter("memo");

        try {
            Category cat = new Category(typeId != null ? Integer.parseInt(typeId) : 0, categoryName, memo);
            if ("add".equals(action)) {
                categoryDAO.insertRec(cat);
            } else if ("update".equals(action)) {
                categoryDAO.updateRec(cat);
            }
            response.sendRedirect("CategoryManagementServlet");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("categoryManagement.jsp?error=Operation failed");
        }
    }
}