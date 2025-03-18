package servlet;

import dao.AccountDAO;
import model.Account;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/LogoutServlet")
public class LogOutServlet extends HttpServlet {
    private AccountDAO accountDAO = new AccountDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null) {
            String account = (String) session.getAttribute("account");
            if (account != null) {
                Account user = accountDAO.getObjectById(account);
                if (user != null) {
                    user.setSessionId(null);
                    accountDAO.updateRec(user);
                }
            }
            session.invalidate();
        }
        response.sendRedirect("HomeServlet");
    }
}