package test;

import model.GetLatestPosts;
import model.Post;

import java.util.List;

/**
 * Created by RyomaArai on 15/03/30.
 */
public class GetLatestPostsTest {
    public static void main(String[] args) {
        getlatestPosts();
    }

    public static void getlatestPosts() {
        GetLatestPosts getLatestPosts = new GetLatestPosts();
        List<Post> posts = getLatestPosts.execute();

        if (posts != null) {
            System.out.println("(テスト)最新のPostの取得に成功しました");
        } else {
            System.out.println("(テスト)最新のPostの取得に失敗しました");
        }
    }
}
