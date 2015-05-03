package model;

import dao.AccountDAO;

/**
 * Created by RyomaArai on 15/04/22.
 */
public class GetUserByTwIdLogic {
    public String execute(String twUserId_str) {
        AccountDAO dao = new AccountDAO();
        String user_id = dao.findByTwId(twUserId_str);
        if (user_id != null) {
            return user_id;
        } else {
           return null;
        }
    }
}
