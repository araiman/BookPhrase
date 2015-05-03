package model;

import java.io.Serializable;

/**
 * Created by RyomaArai on 15/04/12.
 */
public class Account implements Serializable {
    private long userId;

    public Account() {
    }

    public Account(long userId) {
        this.userId = userId;
    }

    public long getUserId() {
        return this.userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
