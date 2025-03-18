package servlet;

import dao.ProductDAO;
import model.Product;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ProductManagementServlet")
public class ProductManagementServlet extends HttpServlet {
    private ProductDAO productDAO = new ProductDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String productId = request.getParameter("productId");
        String searchName = request.getParameter("searchName");

        try {
            if ("delete".equals(action) && productId != null) {
                productDAO.deleteRec(new Product(productId, null, null, null, null, 0, null, null, 0, 0));
                response.sendRedirect("ProductManagementServlet");
                return;
            }

            List<Product> productList = searchName != null && !searchName.isEmpty() ?
                productDAO.searchByName(searchName) : productDAO.listAll();
            request.setAttribute("productList", productList);
            request.getRequestDispatcher("/productManagement.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Something went wrong!");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String productId = request.getParameter("productId");
        String productName = request.getParameter("productName");
        String productImage = request.getParameter("productImage");
        String brief = request.getParameter("brief");
        int typeId = Integer.parseInt(request.getParameter("typeId"));
        String account = request.getParameter("account");
        String unit = request.getParameter("unit");
        int price = Integer.parseInt(request.getParameter("price"));
        int discount = Integer.parseInt(request.getParameter("discount"));

        try {
            Product prod = new Product(productId, productName, productImage, brief, null, typeId, account, unit, price, discount);
            if ("add".equals(action)) {
                productDAO.insertRec(prod);
            } else if ("update".equals(action)) {
                productDAO.updateRec(prod);
            }
            response.sendRedirect("ProductManagementServlet");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("productManagement.jsp?error=Operation failed");
        }
    }
}