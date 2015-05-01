package model;

import dao.AccountDAO;

/**
 * Created by RyomaArai on 15/04/25.
 */
public class GetUserByEmailLogic {
    public String execute(String email, String password) {
        AccountDAO dao = new AccountDAO();
        String user_id = dao.findByEmail(email, password);
        if (user_id != null) {
            return user_id;
        }
        return "";
    }
}
