package model;

import dao.EachBookDAO;

import java.util.List;

/**
 * Created by RyomaArai on 15/04/02.
 */
public class GetEachBookPostsLogic {
    public List<Post> execute(String isbn_str, String postCount) {
        EachBookDAO dao = new EachBookDAO();
        List<Post> posts = dao.findByIsbn(isbn_str,postCount);

        return posts;
    }
}
