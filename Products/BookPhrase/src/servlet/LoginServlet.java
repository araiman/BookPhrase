package servlet;

import model.*;
import model.Error;

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
 * ブクフレへの、ログイン処理をするクラスです。
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    public static final long serialVersionUID = 1L;

    // ログインしていない / FBログイン / Twログイン の場合の処理
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
            return;
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

    // Emailログインの場合の処理
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String userId_str;

        if (email == "" || password == "") {
            String errorMsg = "Email、パスワードの、どちらか、もしくは両方に、入力の不備があります。";
            Error error = new Error(errorMsg);
            request.setAttribute("error", error);
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
            dispatcher.forward(request, response);
            return;
        } else {
            GetUserByEmailLogic logic = new GetUserByEmailLogic();
            userId_str = logic.execute(email, password);
        }

        if (userId_str == null) {
            String errorMsg = "Email、パスワードのどちらか、もしくは両方が、間違っています。";
            Error error = new Error(errorMsg);
            request.setAttribute("error", error);
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/login.jsp");
            dispatcher.forward(request, response);
            return;
        } else {
            Account account = new Account(Long.parseLong(userId_str));
            HttpSession session = request.getSession();
            session.setAttribute("account", account);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/TlServlet");
            dispatcher.forward(request, response);
        }
    }

}
