package servlet;

import dao.AccountDAO;
import model.Account;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/AccountManagementServlet")
public class AccountManagementServlet extends HttpServlet {
    private AccountDAO accountDAO = new AccountDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String accountId = request.getParameter("account");
        String searchName = request.getParameter("searchName");

        try {
            if ("delete".equals(action) && accountId != null) {
                accountDAO.deleteRec(new Account(accountId, null, null, null, null, false, null, false, null));
                response.sendRedirect("AccountManagementServlet");
                return;
            }

            List<Account> accountList = searchName != null && !searchName.isEmpty() ?
                accountDAO.searchByName(searchName) : accountDAO.listAll();
            request.setAttribute("accountList", accountList);
            request.getRequestDispatcher("/accountManagement.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Something went wrong!");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String account = request.getParameter("account");
        String pass = request.getParameter("pass");
        String lastName = request.getParameter("lastName");
        String firstName = request.getParameter("firstName");
        String birthday = request.getParameter("birthday");
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String phone = request.getParameter("phone");
        boolean isUse = Boolean.parseBoolean(request.getParameter("isUse"));
        String roleInSystem = request.getParameter("roleInSystem");

        try {
            Account acc = new Account(account, pass, lastName, firstName, birthday, gender, phone, isUse, roleInSystem);
            if ("add".equals(action)) {
                accountDAO.insertRec(acc);
            } else if ("update".equals(action)) {
                accountDAO.updateRec(acc);
            }
            response.sendRedirect("AccountManagementServlet");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("accountManagement.jsp?error=Operation failed");
        }
    }
}