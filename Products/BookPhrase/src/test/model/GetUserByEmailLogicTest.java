package test.model;

import model.GetUserByEmailLogic;

/**
 * Created by RyomaArai on 15/04/25.
 */
public class GetUserByEmailLogicTest {
    public static void main(String[] args) {
        GetUserByEmailLogic logic = new GetUserByEmailLogic();

        // テスト成功するはず
        String userId = logic.execute("hoge@gmail.com", "hogehoge");

        /* テスト失敗するはず
        String userId = logic.execute("ho@gmail.com", "hogehoge");
        */

        System.out.println(userId);
        if (userId != "") {
            System.out.println("テストに成功しました");
        } else {
            System.out.println("テストに失敗しました");
        }
    }
}
