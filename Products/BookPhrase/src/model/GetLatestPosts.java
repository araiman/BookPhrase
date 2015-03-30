package model;

import dao.PostDAO;

import java.util.List;

/**
 * Created by RyomaArai on 15/03/30.
 */
public class GetLatestPosts {
    public List<Post> execute() {
        PostDAO postDAO = new PostDAO();
        List<Post> posts = postDAO.findByLatestDate();

        return posts;
    }
}
