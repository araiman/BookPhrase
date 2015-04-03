package model;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by RyomaArai on 15/04/03.
 */
public class GetBookInfoLogic {
    public void execute() throws IOException, NoSuchAlgorithmException, InvalidKeyException {
        Map<String, String> keyMap = new HashMap<String, String>();
        keyMap.put("AWSAccessKeyId", "000000000000000");
        keyMap.put("Version", "2008-08-19");
        keyMap.put("Operation", "ItemLookup");
        keyMap.put("ItemId", "4877712399");
        keyMap.put("ResponseGroup", "Medium");
        keyMap.put("AssociateTag", "jx-22");
        keyMap.put("Service", "AWSECommerceService");
        AmazonSignedRequestsHelper signedRequestsHelper = new AmazonSignedRequestsHelper();
        String urlStr = signedRequestsHelper.sign(keyMap);
        URL url = new URL(urlStr);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    }
}
