package servlet;

import model.BookInfo;
import model.GetBookURLsLogic;
import model.GetEachBookPostsLogic;
import model.Post;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by RyomaArai on 15/04/05.
 */
@WebServlet("/EachBookServlet")
public class EachBookServlet extends HttpServlet {
    public static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GetBookURLsLogic getBookURLsLogic = new GetBookURLsLogic();
        GetEachBookPostsLogic getEachBookPostsLogic = new GetEachBookPostsLogic();
        String isbn_str = request.getParameter("isbn-str");

        // ISBNによって、Amazonから本のページ・表紙画像のアドレスを取得する
        Map<String, String> bookInfoMap = getBookURLsLogic.execute(isbn_str);
        String detailPageURL = bookInfoMap.get("detailPageURL");
        String imgAddress = bookInfoMap.get("imgAddress");

        BookInfo bookInfo = new BookInfo(detailPageURL, imgAddress, isbn_str);

        // データベースから、特定のISBNのフレーズを取り出す。
        String postCount_str = request.getParameter("post-count");
        List<Post> eachBookPostsList = getEachBookPostsLogic.execute(isbn_str, postCount_str);

        request.setAttribute("bookInfo", bookInfo);
        request.setAttribute("eachBookPostsList", eachBookPostsList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/eachBook.jsp");
        dispatcher.forward(request, response);
    }

    public void doPost() {

    }
}
