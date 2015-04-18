package model;

import dao.AccountDAO;

/**
 * Created by RyomaArai on 15/04/18.
 */
public class GetUserByFbIdLogic {
    public String execute(String fbUserId_str) {
        AccountDAO dao = new AccountDAO();
        String user_id = dao.findByFbId(fbUserId_str);
        if (user_id != null) {
            return user_id;
        }
        return "";
    }
}
