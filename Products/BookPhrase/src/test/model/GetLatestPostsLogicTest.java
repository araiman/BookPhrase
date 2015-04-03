package test.model;

import model.GetLatestPostsLogic;
import model.Post;

import java.util.List;

/**
 * Created by RyomaArai on 15/03/30.
 */
public class GetLatestPostsLogicTest {
    public static void main(String[] args) {
        testGetLatestPosts();
    }

    public static void testGetLatestPosts() {
        GetLatestPostsLogic getLatestPostsLogic = new GetLatestPostsLogic();
        List<Post> posts = getLatestPostsLogic.execute("20");

        if (posts != null) {
            System.out.println("(テスト)最新のPostの取得に成功しました");
        } else {
            System.out.println("(テスト)最新のPostの取得に失敗しました");
        }
    }
}
