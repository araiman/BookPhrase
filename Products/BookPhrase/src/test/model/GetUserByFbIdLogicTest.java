package test.model;

import model.GetUserByFbIdLogic;

/**
 * Created by RyomaArai on 15/04/18.
 */
public class GetUserByFbIdLogicTest {
    public static void main(String[] args) {
        GetUserByFbIdLogic logic = new GetUserByFbIdLogic();

        // テスト成功するはず
        String userId = logic.execute("634884089989415");

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
