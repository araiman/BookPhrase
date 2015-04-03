package model;

import dao.PostDAO;

import java.util.List;

/**
 * Created by RyomaArai on 15/03/30.
 */
public class GetLatestPostsLogic {
    public List<Post> execute(String postCount) {
        PostDAO dao = new PostDAO();
        List<Post> posts = dao.findByLatestDate(postCount);

        return posts;
    }
}
