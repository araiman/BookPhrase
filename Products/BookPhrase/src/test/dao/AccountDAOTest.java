package test.dao;

import dao.AccountDAO;

/**
 * Created by RyomaArai on 15/04/15.
 */
public class AccountDAOTest {
    public static void main(String[] args) {
        /* Facebookテスト
        AccountDAO dao = new AccountDAO();
        String userId = dao.findByFbId("634884089989415");

        if (userId != null) {
            System.out.println(userId);
            System.out.println("テストに成功しました");
        } else {
            System.out.println("テストに失敗しました");
        }
        */

        /* twitterテスト
        AccountDAO dao = new AccountDAO();
        String userId = dao.findByTwId("584533532");

        if (userId != null) {
            System.out.println(userId);
            System.out.println("テストに成功しました");
        } else {
            System.out.println("テストに失敗しました");
        }
        */

        /* Emailテスト */
        AccountDAO dao = new AccountDAO();

        // 成功するはず
         String userId = dao.findByEmail("hoge@gmail.com", "hogehoge");

        // 失敗するはず
        // String userId = dao.findByEmail("hoge@gmail.co", "hogehoge");
        // String userId = dao.findByEmail("hoge@gmail.com", "ogehoge");


        if (userId != null) {
            System.out.println(userId);
            System.out.println("テストに成功しました");
        } else {
            System.out.println("テストに失敗しました");
        }
    }
}
