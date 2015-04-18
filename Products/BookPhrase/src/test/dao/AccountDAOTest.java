package test.dao;

import dao.AccountDAO;

/**
 * Created by RyomaArai on 15/04/15.
 */
public class AccountDAOTest {
    public static void main(String[] args) {
        AccountDAO dao = new AccountDAO();
        String userId = dao.findByFbId("634884089989415");

        if (userId != null) {
            System.out.println(userId);
            System.out.println("テストに成功しました");
        } else {
            System.out.println("テストに失敗しました");
        }
    }
}
