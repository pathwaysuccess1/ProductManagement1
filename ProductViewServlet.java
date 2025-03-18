package servlet;

import dao.CategoryDAO;
import dao.ProductDAO;
import dao.ReviewDAO;
import model.Category;
import model.Product;
import model.Review;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/ProductViewServlet")
public class ProductViewServlet extends HttpServlet {
    private ProductDAO productDAO = new ProductDAO();
    private CategoryDAO categoryDAO = new CategoryDAO();
    private ReviewDAO reviewDAO = new ReviewDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String account = (String) session.getAttribute("account");
        String productId = request.getParameter("productId");
        String typeId = request.getParameter("typeId");
        String searchName = request.getParameter("searchName");
        String minPrice = request.getParameter("minPrice");
        String maxPrice = request.getParameter("maxPrice");
        String sortBy = request.getParameter("sortBy");
        String discountFilter = request.getParameter("discountFilter");

        try {
            if (productId != null && !productId.isEmpty()) {
                Product product = productDAO.getObjectById(productId);
                if (account != null) productDAO.addView(account, productId);
                List<Review> reviews = reviewDAO.getReviewsByProduct(productId);
                request.setAttribute("product", product);
                request.setAttribute("reviews", reviews);
                request.getRequestDispatcher("/productDetails.jsp").forward(request, response);
                return;
            }

            List<Category> categories = categoryDAO.listAll();
            Integer typeIdInt = typeId != null && !typeId.isEmpty() ? Integer.parseInt(typeId) : null;
            Integer minPriceInt = minPrice != null && !minPrice.isEmpty() ? Integer.parseInt(minPrice) : null;
            Integer maxPriceInt = maxPrice != null && !maxPrice.isEmpty() ? Integer.parseInt(maxPrice) : null;
            String sortBySql = "price".equals(sortBy) ? "price ASC" : null;

            List<Product> productList = typeIdInt != null ? 
                productDAO.getProductsByCategory(typeIdInt) : 
                productDAO.getFilteredProducts(searchName, null, minPriceInt, maxPriceInt, sortBySql);

            if ("on".equals(discountFilter)) {
                productList.removeIf(p -> p.getDiscount() == 0);
            }

            request.setAttribute("categories", categories);
            request.setAttribute("productList", productList);
            request.getRequestDispatcher("/listProducts.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Something went wrong!");
        }
    }
}