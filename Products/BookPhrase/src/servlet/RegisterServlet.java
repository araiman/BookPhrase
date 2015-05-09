package servlet;

import model.*;
import model.Error;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by RyomaArai on 15/05/04.
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    public static final long serialVesionUID = 1L;

    // 登録画面への遷移
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    // TODO 入力チェックのコードを、別ファイルに分ける。(登録受付のためのコードであるのに、入力チェックの部分が長すぎる。)
    // メールアドレス登録の処理
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name").trim();
        String email = request.getParameter("email").trim();
        String userPassword = request.getParameter("password").trim();
        List<Error> errorMsgs = new ArrayList<Error>();
        boolean hasError = false;

        if (name == null || name.equals("") ) {
            Error error = new Error("名前が入力されていません");
            errorMsgs.add(error);
            hasError = true;
        } else if (email == null || email.equals("")) {
            Error error = new Error("メールアドレスが入力されていません");
            errorMsgs.add(error);
            hasError = true;
        } else if (userPassword == null || userPassword.equals("")) {
            Error error = new Error("パスワードが入力されていません");
            errorMsgs.add(error);
            hasError = true;
        }

        if (hasError) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/LoginServlet");
            dispatcher.forward(request,response);
        }



    }

}
