package test.model;

import model.GetUserByTwIdLogic;

/**
 * Created by RyomaArai on 15/04/22.
 */
public class GetUserByTwIdLogicTest {
    public static void main(String[] args) {
        GetUserByTwIdLogic logic = new GetUserByTwIdLogic();

        // テスト成功するはず
        String userId = logic.execute("584533532");

        /* テスト失敗するはず
        String userId = logic.execute("11111");
        */

        System.out.println(userId);
        if (userId != "") {
            System.out.println("テストに成功しました");
        } else {
            System.out.println("テストに失敗しました");
        }
    }
}
