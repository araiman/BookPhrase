package test;

import dao.PostDAO;
import model.Post;

import java.util.List;

/**
 * Created by RyomaArai on 15/03/30.
 */
public class PostDAOTest {
    public static void main(String[] args) {
        testFindByLatestDate();
    }

    public static void testFindByLatestDate() {
        PostDAO dao = new PostDAO();
        List<Post> result = dao.findByLatestDate();

        if (result != null) {
            Post firstPost = result.get(0);
            Post secondPost = result.get(1);
            System.out.println(firstPost.getPhrase());
            System.out.println(secondPost.getPhrase());
        } else {
            System.out.println("テストに失敗しました");
        }
    }
}
