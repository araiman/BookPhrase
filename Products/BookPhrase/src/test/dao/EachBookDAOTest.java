package test.dao;

import dao.EachBookDAO;
import model.Post;

import java.util.List;

/**
 * Created by RyomaArai on 15/04/02.
 */
public class EachBookDAOTest {
    public static void main(String[] args) {
        testFindByIsbn();
    }

    public static void testFindByIsbn() {
        EachBookDAO dao = new EachBookDAO();
        List<Post> result = dao.findByIsbn("4344423046","0");

        if (result != null) {
            System.out.println(result.get(0).getPhrase());
            System.out.println("テストに成功しました");
        } else {
            System.out.println("テストに失敗しました");
        }
    }
}
