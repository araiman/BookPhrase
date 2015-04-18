package model;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by RyomaArai on 15/04/03.
 */
public class GetBookURLsLogic {
    // 「ISBN」で、「本のページアドレス」と、「画像のアドレス」を取得し、Mapに入れて返す。
    public Map<String, String> execute(String isbn_str) {
        Map<String, String> bookInfoMap = new HashMap<String, String>();

        // リクエストパラメータの用意
        Map<String, String> keyMap = new HashMap<String, String>();
        keyMap.put("AWSAccessKeyId", "AKIAJ7T4ZII52IKBO2QQ");
        keyMap.put("Version", "2011-08-02");
        keyMap.put("Operation", "ItemLookup");
        keyMap.put("SearchIndex", "Books");
        keyMap.put("IdType", "ISBN");
        keyMap.put("ItemId", isbn_str);
        keyMap.put("ResponseGroup", "Images,Small,Medium");
        keyMap.put("AssociateTag", "arai31133110e-22");
        keyMap.put("Service", "AWSECommerceService");
        try {
            // Amazon Advertising API にリクエストを送信する
            AmazonSignedRequestsHelper signedRequestsHelper = new AmazonSignedRequestsHelper();
            String urlStr = signedRequestsHelper.sign(keyMap);

            // URLから、レスポンスの受信
            URL url = new URL(urlStr);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream is = connection.getInputStream();

            // XMLから、要素を取り出す
            // TODO もっと、短くかけるのではないか？検討する。
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(is);
            Element elementRoot = document.getDocumentElement();

            NodeList items_ndList = elementRoot.getElementsByTagName("Items");
            Element items_element = (Element) items_ndList.item(0);

            NodeList item_ndList = items_element.getElementsByTagName("Item");
            Element item_element = (Element) item_ndList.item(0);

            // item_elementから、detailpageURLと、MediumImageを取得する
            NodeList detailPageURL_ndList = item_element.getElementsByTagName("DetailPageURL");
            String detailPageURL = detailPageURL_ndList.item(0).getFirstChild().getNodeValue();

            NodeList mediumImage_ndList = item_element.getElementsByTagName("MediumImage");
            Element mediumImage_element = (Element) mediumImage_ndList.item(0);
            NodeList url_ndList = mediumImage_element.getElementsByTagName("URL");
            String imgAddress = url_ndList.item(0).getFirstChild().getNodeValue();

            bookInfoMap.put("detailPageURL", detailPageURL);
            bookInfoMap.put("imgAddress", imgAddress);

            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookInfoMap;
    }
}
