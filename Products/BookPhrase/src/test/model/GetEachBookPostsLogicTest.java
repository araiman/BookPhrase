package test.model;

import model.GetEachBookPostsLogic;
import model.Post;

import java.util.List;

/**
 * Created by RyomaArai on 15/04/02.
 */
public class GetEachBookPostsLogicTest {
    public static void main(String[] args) {
        testGetEachBookPosts();
    }

    public static void testGetEachBookPosts() {
        GetEachBookPostsLogic getEachBookPostsLogic = new GetEachBookPostsLogic();
        List<Post> result = getEachBookPostsLogic.execute("4344423046","0");

        if (result != null) {
            System.out.println("(テスト)本ごとのPostの取得に成功しました");
        } else {
            System.out.println("(テスト)本ごとのPostの取得に失敗しました");
        }
    }
}
