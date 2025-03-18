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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private AccountDAO accountDAO = new AccountDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("account");
        String pass = request.getParameter("pass");
        HttpSession session = request.getSession();

        try {
            Account user = accountDAO.loginAccount(account, pass);
            if (user != null) {
                if (user.getSessionId() != null && !user.getSessionId().equals(session.getId())) {
                    response.sendRedirect("login.jsp?error=Account is already logged in on another device");
                    return;
                }
                user.setSessionId(session.getId());
                accountDAO.updateRec(user);
                session.setAttribute("account", user.getAccount());
                session.setAttribute("fullname", user.getFullName());
                session.setAttribute("role", user.getRoleInSystem());
                response.sendRedirect("Welcome.jsp");
            } else {
                response.sendRedirect("login.jsp?error=Invalid account or password");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("login.jsp?error=Login failed");
        }
    }
}