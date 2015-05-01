package servlet;

/**
 * Created by RyomaArai on 15/04/21.
 */

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.User;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/callback")
public class TwCallbackServlet extends HttpServlet {
    private static final long serialVersionUID = 1657390011452788111L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Twitter twitter = (Twitter) request.getSession().getAttribute("twitter");
        RequestToken requestToken = (RequestToken) request.getSession().getAttribute("requestToken");
        String verifier = request.getParameter("oauth_verifier");
        long userId_long;
        try {
            AccessToken accessToken = twitter.getOAuthAccessToken(requestToken, verifier);
            request.getSession().removeAttribute("requestToken");
            twitter.setOAuthAccessToken(accessToken);

            User user = twitter.verifyCredentials();
            userId_long = user.getId();
        } catch (TwitterException e) {
            throw new ServletException(e);
        }
        response.sendRedirect(request.getContextPath() + "/LoginServlet?tw-user-id=" + String.valueOf(userId_long));
    }
}
