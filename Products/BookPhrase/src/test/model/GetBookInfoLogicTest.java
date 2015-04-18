package test.model;

import model.GetBookURLsLogic;

import java.util.Map;

/**
 * Created by RyomaArai on 15/04/03.
 */
public class GetBookInfoLogicTest {
    public static void main(String[] args) {
        GetBookURLsLogic getBookURLsLogic = new GetBookURLsLogic();
        Map<String, String> bookInfoMap = getBookURLsLogic.execute("4344423046");
        if (bookInfoMap != null) {
            System.out.println(bookInfoMap.get("detailPageURL"));
            System.out.println(bookInfoMap.get("imgAddress"));
            System.out.println("テストに成功しました");
        } else {
            System.out.println("テストに失敗しました");
        }
    }
}
