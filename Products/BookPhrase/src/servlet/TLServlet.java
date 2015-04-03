package servlet;

import model.GetLatestPostsLogic;
import model.Post;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by RyomaArai on 15/03/29.
 */

@WebServlet("/TlServlet")
public class TlServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GetLatestPostsLogic getLatestPostsLogic = new GetLatestPostsLogic();
        List<Post> latestTlList = null;

        // 表示するPostの数を取得
        String postCount = request.getParameter("postcount");

        // postCountによる場合わけ
        if (postCount == null) {
            latestTlList = getLatestPostsLogic.execute("0");
        } else {
            // 最新のポストの取得
            latestTlList = getLatestPostsLogic.execute(postCount);
        }
        // 最新のポストをリクエストスコープに保存
        request.setAttribute("latestTlList", latestTlList);

        // ページの遷移
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/timeline.jsp");
        dispatcher.forward(request, response);
    }

    public void doPost() {

    }
}
