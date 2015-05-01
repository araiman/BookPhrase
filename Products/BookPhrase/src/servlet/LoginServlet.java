package servlet;

import model.Account;
import model.GetUserByFbIdLogic;
import model.GetUserByTwIdLogic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by RyomaArai on 15/04/12.
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    public static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userId_str = "";

        if (request.getParameter("fb-user-id") != null) {
            GetUserByFbIdLogic logic = new GetUserByFbIdLogic();
            String fbUserId = request.getParameter("fb-user-id");
            userId_str = logic.execute(fbUserId);
        } else if (request.getParameter("tw-user-id") != null) {
            GetUserByTwIdLogic logic = new GetUserByTwIdLogic();
            String twUserId = request.getParameter("tw-user-id");
            userId_str = logic.execute(twUserId);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
            dispatcher.forward(request, response);
        }

        if (userId_str != "") {
            Account account = new Account(Long.parseLong(userId_str));
            HttpSession session = request.getSession();
            session.setAttribute("account", account);
            RequestDispatcher dispatcher = request.getRequestDispatcher("TlServlet");
            dispatcher.forward(request, response);
        } else {
            System.out.println("ログインに失敗しました");
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
            dispatcher.forward(request, response);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/TlServlet");
        dispatcher.forward(request, response);
    }

}
