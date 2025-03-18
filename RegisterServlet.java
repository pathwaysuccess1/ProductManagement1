package servlet;

import dao.AccountDAO;
import model.Account;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private AccountDAO accountDAO = new AccountDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("account");
        String pass = request.getParameter("pass");
        String lastName = request.getParameter("lastName");
        String firstName = request.getParameter("firstName");
        String birthday = request.getParameter("birthday");
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String phone = request.getParameter("phone");

        if (!pass.equals(request.getParameter("confirmPass"))) {
            response.sendRedirect("register.jsp?error=Passwords do not match");
            return;
        }

        try {
            accountDAO.insertRec(new Account(account, pass, lastName, firstName, birthday, gender, phone, true, "customer"));
            response.sendRedirect("login.jsp?success=Registration successful");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("register.jsp?error=Registration failed, account may already exist");
        }
    }
}