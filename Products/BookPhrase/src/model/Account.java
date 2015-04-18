package model;

/**
 * Created by RyomaArai on 15/04/12.
 */
public class Account {
    private int userId;

    public Account() {
    }

    public Account(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
